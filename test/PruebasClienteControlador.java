package test;

import controlador.ClienteControlador;
import modelo.Cliente;

public class PruebasClienteControlador {
    
    //@Test
    public void testRegistrarCliente() {
        ClienteControlador clienteControlador = new ClienteControlador();
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidoPaterno("Perez");
        cliente.setCorreoElectronico("juan@gmail.com");
    }
}
