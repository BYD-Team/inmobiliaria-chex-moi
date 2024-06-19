DELIMITER //

CREATE PROCEDURE filterPropiedades(
    IN maxPrecio DOUBLE,
    IN patioValue VARCHAR(2),
    IN numHabitaciones INT,
    IN cocinaValue VARCHAR(2),
    IN estacionamientoValue VARCHAR(2),
    IN mueblesValue VARCHAR(2),
    IN terrazaValue VARCHAR(2),
    IN wifiValue VARCHAR(2)
)
BEGIN 
    SET @sql = '
        SELECT c.claveCatastral, c.nombre, c.precio, c.operacion, c.dimensiones,
        c.habitaciones, c.baños, c.patio, c.cocina, c.estacionamiento, c.muebles, c.terraza, c.wifi,
        i.idDireccion, i.calle, i.colonia, i.cp, i.numeroExterior, i.numeroInterior, c.numeroAutos  
        FROM propiedad as c
        INNER JOIN direccion i ON c.Direccion_idDireccion = i.idDireccion
        WHERE 1=1';

    IF maxPrecio IS NOT NULL THEN
        SET @sql = CONCAT(@sql, ' AND c.precio <= ', maxPrecio);
    END IF;

    IF patioValue IS NOT NULL AND patioValue != '' THEN
        SET @sql = CONCAT(@sql, ' AND c.patio = ''', patioValue, '''');
    END IF;

    IF numHabitaciones IS NOT NULL THEN
        SET @sql = CONCAT(@sql, ' AND c.habitaciones = ', numHabitaciones);
    END IF;

    IF cocinaValue IS NOT NULL AND cocinaValue != '' THEN
        SET @sql = CONCAT(@sql, ' AND c.cocina = ''', cocinaValue, '''');
    END IF;

    IF estacionamientoValue IS NOT NULL AND estacionamientoValue != '' THEN
        SET @sql = CONCAT(@sql, ' AND c.estacionamiento = ''', estacionamientoValue, '''');
    END IF;

    IF mueblesValue IS NOT NULL AND mueblesValue != '' THEN
        SET @sql = CONCAT(@sql, ' AND c.muebles = ''', mueblesValue, '''');
    END IF;

    IF terrazaValue IS NOT NULL AND terrazaValue != '' THEN
        SET @sql = CONCAT(@sql, ' AND c.terraza = ''', terrazaValue, '''');
    END IF;

    IF wifiValue IS NOT NULL AND wifiValue != '' THEN
        SET @sql = CONCAT(@sql, ' AND c.wifi = ''', wifiValue, '''');
    END IF;

    PREPARE searchQuery FROM @sql;
    EXECUTE searchQuery;
    DEALLOCATE PREPARE searchQuery;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE obtenerPropiedadesConDireccion(
    IN clienteId INT
)
BEGIN
    SELECT 
        p.claveCatastral,
        p.nombre,
        p.precio,
        p.operacion,
        p.dimensiones,
        p.habitaciones,
        p.patio,
        p.banios,
        p.wifi,
        p.cocina,
        p.estacionamiento,
        p.muebles,
        d.idDireccion,
        d.calle,
        d.colonia,
        d.cp AS codigoPostal,
        d.numeroExterior,
        d.numeroInterior,
        p.numeroAutos
    FROM 
        propietario pr
        JOIN propiedad p ON pr.Propiedad_claveCatastral = p.claveCatastral
        JOIN direccion d ON p.Direccion_idDireccion = d.idDireccion
    WHERE 
        pr.Cliente_idCliente = clienteId;
END //

DELIMITER ;
