import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import chexmoi.controlador.ClienteControlador;
import chexmoi.modelo.Cliente;

public class PruebasClienteControlador {
    
    @Test
    public void testRegistrarCliente() throws SQLException {
        Cliente cliente = new Cliente();
        
        cliente.setNombre("Juan");
        cliente.setApellidoPaterno("Perez");
        cliente.setCorreoElectronico("juan@gmail.com");
        cliente.setClave("1234");
        
        ClienteControlador clienteControlador = new ClienteControlador();
        
        int resultado = clienteControlador.registrarCliente(cliente);
        
        assertEquals(1, resultado);
    }
}
