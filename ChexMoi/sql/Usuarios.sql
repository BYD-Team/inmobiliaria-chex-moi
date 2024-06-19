-- SQLBook: Code
-- DROP DATABASE chexmoi;

CREATE USER 'usuario_chexmoi'@'%' IDENTIFIED BY 'u$9Hxt7Wc*';
GRANT USAGE, EXECUTE, INSERT, UPDATE, DELETE, ALTER, SELECT ON chexmoi.* TO 'usuario_chexmoi'@'%';
-- DROP USER 'usuario_chexmoi'@'%';
-- FLUSH PRIVILEGES;

CREATE USER 'usuario_cliente'@'%' IDENTIFIED BY 'db_password';
GRANT USAGE, EXECUTE, INSERT, SELECT ON chexmoi.* TO 'usuario_cliente'@'%';
-- DROP USER 'usuario_cliente'@'%';
-- FLUSH PRIVILEGES;

CREATE USER 'usuario_prueba'@'%' IDENTIFIED BY 'db_password';
GRANT USAGE, EXECUTE, INSERT, UPDATE, DELETE, ALTER, SELECT ON chexmoi.* TO 'usuario_prueba'@'%';
-- DROP USER 'usuario_prueba'@'%';
-- FLUSH PRIVILEGES;
