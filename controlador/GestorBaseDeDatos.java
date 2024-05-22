package controlador;

import java.sql.Connection;

public class GestorBaseDeDatos {
    Connection conexion;
    
    public Connection obtenerConexion() {
        

        return conexion;
    }

    public void cerrarConexion() {

    }
}
