import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import chexmoi.controlador.ClienteControlador;
import chexmoi.modelo.Cliente;

public class PruebasClienteControlador {

    private ClienteControlador clienteControlador;

    @Before
    public void setUp() {
        clienteControlador = new ClienteControlador();
    }

    @Test
    public void testRegistrarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidoPaterno("Pérez");
        cliente.setCorreoElectronico("juan.perez@example.com");
        cliente.setClave("clave123");
        cliente.setTelefono("1234567890");

        try {
            int resultado = clienteControlador.registrarCliente(cliente);
            assertEquals(1, resultado);
        } catch (SQLException e) {
            fail("Error al registrar cliente: " + e.getMessage());
        }
    }

    @Test
    public void testObtenerCliente() throws SQLException {
        String correoElectronico = "juan.perez@example.com";
        String clave = "clave123";

        Cliente cliente = clienteControlador.obtenerCliente(correoElectronico, clave);
        assertNotNull(cliente);
        assertEquals(correoElectronico, cliente.getCorreoElectronico());
    }

    @Test
    public void testActualizarCorreo() throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setCorreoElectronico("nuevo.correo@example.com");

        int resultado = clienteControlador.actualizarCorreo(cliente);
        assertEquals(1, resultado);
    }

    @Test
    public void testActualizarTelefono() throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setTelefono("0987654321");

        int resultado = clienteControlador.actualizarTelefono(cliente);
        assertEquals(1, resultado);
    }

    @Test
    public void testActualizarApellidoPaterno() throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setApellidoPaterno("González");

        int resultado = clienteControlador.actualizarApellidoPaterno(cliente);
        assertEquals(1, resultado);
    }

    @Test
    public void testActualizarNombre() throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("Carlos");

        int resultado = clienteControlador.actualizarNombre(cliente);
        assertEquals(1, resultado);
    }
}
