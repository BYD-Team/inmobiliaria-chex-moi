import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chexmoi.controlador.ClienteControlador;
import chexmoi.modelo.Cliente;

public class PruebasClienteControlador {
    
    @Test
    public void testRegistrarCliente() {
        ClienteControlador clienteControlador = new ClienteControlador();
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidoPaterno("Perez");
        cliente.setCorreoElectronico("juan@gmail.com");

        int resultado = clienteControlador.registrarCliente(cliente);
        assertEquals(1, resultado);
    }
}
