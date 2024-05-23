import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import chexmoi.controlador.GestorBaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDeDatosTest {

    @Test
    public void obtenerConexionPrueba() throws SQLException {
        GestorBaseDeDatos gestorBaseDeDatos = new GestorBaseDeDatos();
        Connection connection = gestorBaseDeDatos.obtenerConexion();

        assertNotNull(connection);

        gestorBaseDeDatos.cerrarConexion();
    }
}