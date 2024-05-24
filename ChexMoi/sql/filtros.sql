DELIMITER //

CREATE PROCEDURE filterPropiedades(
    IN maxPrecio FLOAT,
    IN patioValue VARCHAR(2),
    IN numHabitaciones INT
)
BEGIN 
    SET @sql = '
        SELECT c.idPropiedad, c.nombre, c.precio, c.operacion, c.dimensiones,
        c.habitaciones, c.patio, i.idDireccion, i.calle, i.colonia, i.cp, i.numeroExterior, i.numeroInterior  
        FROM propiedad as c
        INNER JOIN direccion i ON c.Direccion_idDireccion = i.idDireccion
        WHERE 1=1';

    IF maxPrecio IS NOT NULL THEN
        SET @sql = CONCAT(@sql, ' AND c.precio <= ', maxPrecio);
    END IF;

    IF patioValue IS NOT NULL THEN
        SET @sql = CONCAT(@sql, ' AND c.patio = ''', patioValue, '''');
    END IF;

    IF numHabitaciones IS NOT NULL THEN
        SET @sql = CONCAT(@sql, ' AND c.habitaciones = ', numHabitaciones);
    END IF;

    PREPARE searchQuery FROM @sql;
    EXECUTE searchQuery;
    DEALLOCATE PREPARE searchQuery;
END //