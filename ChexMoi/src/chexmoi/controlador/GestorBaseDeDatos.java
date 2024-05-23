package chexmoi.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class GestorBaseDeDatos {    
    private Connection conexion;

    private final String BASE_DATOS_URL = "jdbc:mysql://localhost:3306/che";
    private final String BASE_DATOS_USUARIO = "root";
    private final String BASE_DATOS_CONTRASENIA = "12345";

    public GestorBaseDeDatos() {
        
    }

    public Connection obtenerConexion() throws SQLException {        
        try {
            conexion = DriverManager.getConnection(BASE_DATOS_URL, BASE_DATOS_USUARIO, BASE_DATOS_CONTRASENIA);

        } catch (SQLTimeoutException sqlTimeoutException) {
            sqlTimeoutException.printStackTrace();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw sqlException;
        }

        return conexion;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
