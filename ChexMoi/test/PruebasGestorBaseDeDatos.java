import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import chexmoi.controlador.GestorBaseDeDatos;

public class PruebasGestorBaseDeDatos {

    @Test
    public void pruebaObtenerConexionExitosa() throws SQLException {
        GestorBaseDeDatos gestorBaseDeDatos = new GestorBaseDeDatos();
        Connection conexion = gestorBaseDeDatos.obtenerConexion();

        assertNotNull(conexion);
        gestorBaseDeDatos.cerrarConexion();
    }

}
