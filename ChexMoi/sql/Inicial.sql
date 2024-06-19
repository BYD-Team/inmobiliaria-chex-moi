-- SQLBook: Code

-- SQLBook: Code
INSERT INTO `Direccion` VALUE (1, 'Calle 1', 'Colonia 1', '12345', 1, 1);
INSERT INTO `Direccion` VALUE (2, 'Calle 2', 'Colonia 2', '23456', 2, 2);
INSERT INTO `Direccion` VALUE (3, 'Calle 3', 'Colonia 3', '34567', 3, 3);
INSERT INTO `Direccion` VALUE (4, 'Calle 4', 'Colonia 4', '45678', 4, 4);
INSERT INTO `Direccion` VALUE (5, 'Calle 5', 'Colonia 5', '56789', 5, 5);
INSERT INTO `Direccion` VALUE (6, 'Calle 6', 'Colonia 6', '67890', 6, 6);
INSERT INTO `Direccion` VALUE (7, 'Calle 7', 'Colonia 7', '78901', 7, 7);
INSERT INTO `Direccion` VALUE (8, 'Calle 8', 'Colonia 8', '89012', 8, 8);
INSERT INTO `Direccion` VALUE (9, 'Calle 9', 'Colonia 9', '90123', 9, 9);
INSERT INTO `Direccion` VALUE (10, 'Calle 10', 'Colonia 10', '01234', 10, 10);

INSERT INTO `Propiedad` VALUE (1, 'Casa de campo', 100000, 'venta', '1000 m2', 3, 'Sí', 1);
INSERT INTO `Propiedad` VALUE (2, 'Casa de playa', 200000, 'alquiler', '2000 m2', 4, 'No', 2);
INSERT INTO `Propiedad` VALUE (3, 'Casa de ciudad', 300000, 'venta', '3000 m2', 5, 'Sí', 3);
INSERT INTO `Propiedad` VALUE (4, 'Casa de montaña', 400000, 'alquiler', '4000 m2', 6, 'No', 4);
INSERT INTO `Propiedad` VALUE (5, 'Casa de lago', 500000, 'venta', '5000 m2', 7, 'Sí', 5);
INSERT INTO `Propiedad` VALUE (6, 'Casa de río', 600000, 'alquiler', '6000 m2', 8, 'No', 6);
INSERT INTO `Propiedad` VALUE (7, 'Casa de bosque', 700000, 'venta', '7000 m2', 9, 'Sí', 7);
INSERT INTO `Propiedad` VALUE (8, 'Casa de desierto', 800000, 'alquiler', '8000 m2', 10, 'No', 8);
INSERT INTO `Propiedad` VALUE (9, 'Casa de pradera', 900000, 'venta', '9000 m2', 11, 'Sí', 9);
INSERT INTO `Propiedad` VALUE (10, 'Casa de selva', 100000, 'alquiler', '1000 m2', 12, 'No', 10);

INSERT INTO `Cliente` VALUE (1, 'Juan', 'Pérez', 'juanperez@gmail.com', SHA2('12345', 256), "2201478212");
INSERT INTO `Cliente` VALUE (2, 'María', 'Gómez', 'mariagomez@gmail.com', SHA2('23456', 256), "2791074983");
INSERT INTO `Cliente` VALUE (3, 'José', 'Hernández', 'josehernandez@gmail.com', SHA2('34567', 256), "2281068594");
INSERT INTO `Cliente` VALUE (4, 'Ana', 'Martínez', 'anamartinez@gmail.com', SHA2('45678', 256), "2291074985");
INSERT INTO `Cliente` VALUE (5, 'Pedro', 'López', 'pedrolopez@gmail.com', SHA2('56789', 256), "2281909012");
INSERT INTO `Cliente` VALUE (6, 'Laura', 'Torres', 'lauratorres@gmail.com', SHA2('67890', 256)), "2291074986";
INSERT INTO `Cliente` VALUE (7, 'Carlos', 'Sánchez', 'carlossanchez@gmail.com', SHA2('78901', 256), "2791089012");
INSERT INTO `Cliente` VALUE (8, 'Sofía', 'Ramírez', 'sofiaramirez@gmail.com', SHA2('89012', 256), "2201478213");
INSERT INTO `Cliente` VALUE (9, 'Jorge', 'García', 'jorgegarcia@gmail.com', SHA2('90123', 256), "2791074987");
INSERT INTO `Cliente` VALUE (10, 'Verónica', 'Fernández', 'veronicafernadez@gmail.com', SHA2('01234', 256), "2281068595");

INSERT INTO `Propietario` VALUE (1, 10);
INSERT INTO `Propietario` VALUE (2, 9);
INSERT INTO `Propietario` VALUE (3, 8);
INSERT INTO `Propietario` VALUE (4, 7);
INSERT INTO `Propietario` VALUE (5, 6);
INSERT INTO `Propietario` VALUE (6, 5);
INSERT INTO `Propietario` VALUE (7, 4);
INSERT INTO `Propietario` VALUE (8, 3);
INSERT INTO `Propietario` VALUE (9, 2);
INSERT INTO `Propietario` VALUE (10, 1);
