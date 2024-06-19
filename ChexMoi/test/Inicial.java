import java.util.ArrayList;

import chexmoi.modelo.Cliente;
import chexmoi.modelo.Direccion;
import chexmoi.modelo.Propiedad;

public class Inicial {
    private  ArrayList<Direccion> direcciones;
    private ArrayList<Propiedad> propiedades;
    private ArrayList<Cliente> clientes;

    public Inicial() {
        direcciones = new ArrayList<Direccion>();
        propiedades = new ArrayList<Propiedad>();
        clientes = new ArrayList<Cliente>();

        iniciarDirecciones();
        iniciarPropiedades();
        iniciarClientes();
    }

    public ArrayList<Direccion> obtenerDirecciones() {
        return direcciones;
    }

    public ArrayList<Propiedad> obtenerPropiedades() {
        return propiedades;
    }

    public ArrayList<Cliente> obtenerClientes() {
        return clientes;
    }

    private void iniciarDirecciones() {
        Direccion direccion = new Direccion();

        direccion.setIdDireccion(1);
        direccion.setCalle("Calle 1");
        direccion.setColonia("Colonia 1");
        direccion.setCodigoPostal("12345");
        direccion.setNumeroExterior(1);
        direccion.setNumeroInterior(1);

        direcciones.add(direccion);

        direccion = new Direccion();

        direccion.setIdDireccion(2);
        direccion.setCalle("Calle 2");
        direccion.setColonia("Colonia 2");
        direccion.setCodigoPostal("23456");
        direccion.setNumeroExterior(2);
        direccion.setNumeroInterior(2);

        direcciones.add(direccion);

        direccion = new Direccion();

        direccion.setIdDireccion(3);
        direccion.setCalle("Calle 3");
        direccion.setColonia("Colonia 3");
        direccion.setCodigoPostal("34567");
        direccion.setNumeroExterior(3);
        direccion.setNumeroInterior(3);

        direcciones.add(direccion);

        direccion = new Direccion();

        direccion.setIdDireccion(4);
        direccion.setCalle("Calle 4");
        direccion.setColonia("Colonia 4");
        direccion.setCodigoPostal("45678");
        direccion.setNumeroExterior(4);
        direccion.setNumeroInterior(4);

        direcciones.add(direccion);

        direccion = new Direccion();

        direccion.setIdDireccion(5);
        direccion.setCalle("Calle 5");
        direccion.setColonia("Colonia 5");
        direccion.setCodigoPostal("56789");
        direccion.setNumeroExterior(5);
        direccion.setNumeroInterior(5);

        direcciones.add(direccion);

        direccion = new Direccion();

        direccion.setIdDireccion(6);
        direccion.setCalle("Calle 6");
        direccion.setColonia("Colonia 6");
        direccion.setCodigoPostal("67890");
        direccion.setNumeroExterior(6);
        direccion.setNumeroInterior(6);

        direcciones.add(direccion);

        direccion = new Direccion();

        direccion.setIdDireccion(7);
        direccion.setCalle("Calle 7");
        direccion.setColonia("Colonia 7");
        direccion.setCodigoPostal("78901");
        direccion.setNumeroExterior(7);
        direccion.setNumeroInterior(7);

        direcciones.add(direccion);

        direccion = new Direccion();

        direccion.setIdDireccion(8);
        direccion.setCalle("Calle 8");
        direccion.setColonia("Colonia 8");
        direccion.setCodigoPostal("89012");
        direccion.setNumeroExterior(8);
        direccion.setNumeroInterior(8);

        direcciones.add(direccion);

        direccion = new Direccion();

        direccion.setIdDireccion(9);
        direccion.setCalle("Calle 9");
        direccion.setColonia("Colonia 9");
        direccion.setCodigoPostal("90123");
        direccion.setNumeroExterior(9);
        direccion.setNumeroInterior(9);

        direcciones.add(direccion);

        direccion = new Direccion();

        direccion.setIdDireccion(10);
        direccion.setCalle("Calle 10");
        direccion.setColonia("Colonia 10");
        direccion.setCodigoPostal("01234");
        direccion.setNumeroExterior(10);
        direccion.setNumeroInterior(10);

        direcciones.add(direccion);
    }

    private void iniciarPropiedades() {
        Propiedad propiedad = new Propiedad();

        propiedad.setClaveCatastral("11122233344455566677");
        propiedad.setNombre("Finca");
        propiedad.setPrecio(1000000.00);
        propiedad.setOperacion("Venta");
        propiedad.setDimensiones("4000");
        propiedad.setHabitaciones(8);
        propiedad.setPatio("Sí");
        propiedad.setDireccion(direcciones.get(1));
        propiedad.setBanios(3);
        propiedad.setCocina("Sí");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("Sí");
        propiedad.setMuebles("Sí");
        propiedad.setWifi("Sí");
        propiedad.setNumeroAutos(4);

        propiedades.add(propiedad);

        propiedad = new Propiedad();

        propiedad.setClaveCatastral("12345111900987654321");
        propiedad.setNombre("Casa de playa");
        propiedad.setPrecio(100000.00);
        propiedad.setOperacion("Alquiler");
        propiedad.setDimensiones("1500");
        propiedad.setHabitaciones(6);
        propiedad.setPatio("Sí");
        propiedad.setDireccion(direcciones.get(1));
        propiedad.setBanios(7);
        propiedad.setCocina("No");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("No");
        propiedad.setMuebles("Sí");
        propiedad.setWifi("No");
        propiedad.setNumeroAutos(1);

        propiedades.add(propiedad);

        propiedad = new Propiedad();

        propiedad.setClaveCatastral("12345678900987640596");
        propiedad.setNombre("Casa de bosque");
        propiedad.setPrecio(375000.00);
        propiedad.setOperacion("Venta");
        propiedad.setDimensiones("2000");
        propiedad.setHabitaciones(4);
        propiedad.setPatio("Sí");
        propiedad.setDireccion(direcciones.get(2));
        propiedad.setBanios(3);
        propiedad.setCocina("Sí");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("No");
        propiedad.setMuebles("Sí");
        propiedad.setWifi("No");
        propiedad.setNumeroAutos(1);

        propiedades.add(propiedad);

        propiedad = new Propiedad();

        propiedad.setClaveCatastral("12345678900987653666");
        propiedad.setNombre("Casa de bosque");
        propiedad.setPrecio(375000.00);
        propiedad.setOperacion("Venta");
        propiedad.setDimensiones("500");
        propiedad.setHabitaciones(2);
        propiedad.setPatio("Sí");
        propiedad.setDireccion(direcciones.get(3));
        propiedad.setBanios(3);
        propiedad.setCocina("Sí");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("No");
        propiedad.setMuebles("Sí");
        propiedad.setWifi("No");
        propiedad.setNumeroAutos(1);

        propiedades.add(propiedad);

        propiedad = new Propiedad();

        propiedad.setClaveCatastral("09876543211234567890");
        propiedad.setNombre("Casa de lago");
        propiedad.setPrecio(800000.00);
        propiedad.setOperacion("Venta");
        propiedad.setDimensiones("2500");
        propiedad.setHabitaciones(6);
        propiedad.setPatio("Sí");
        propiedad.setDireccion(direcciones.get(4));
        propiedad.setBanios(3);
        propiedad.setCocina("Sí");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("No");
        propiedad.setMuebles("Sí");
        propiedad.setWifi("No");
        propiedad.setNumeroAutos(4);

        propiedades.add(propiedad);

        propiedad = new Propiedad();

        propiedad.setClaveCatastral("00100200300400500607");
        propiedad.setNombre("Casa de río");
        propiedad.setPrecio(400000.00);
        propiedad.setOperacion("Venta");
        propiedad.setDimensiones("500");
        propiedad.setHabitaciones(6);
        propiedad.setPatio("Sí");
        propiedad.setDireccion(direcciones.get(5));
        propiedad.setBanios(3);
        propiedad.setCocina("Sí");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("No");
        propiedad.setMuebles("Sí");
        propiedad.setWifi("Sí");
        propiedad.setNumeroAutos(1);

        propiedades.add(propiedad);

        propiedad = new Propiedad();

        propiedad.setClaveCatastral("12345678900987654321");
        propiedad.setNombre("Casa de bosque");
        propiedad.setPrecio(375000.00);
        propiedad.setOperacion("Venta");
        propiedad.setDimensiones("2000");
        propiedad.setHabitaciones(4);
        propiedad.setPatio("Sí");
        propiedad.setDireccion(direcciones.get(6));
        propiedad.setBanios(3);
        propiedad.setCocina("Sí");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("No");
        propiedad.setMuebles("Sí");
        propiedad.setWifi("No");
        propiedad.setNumeroAutos(1);

        propiedades.add(propiedad);

        propiedad = new Propiedad();

        propiedad.setClaveCatastral("10111213141516171009");
        propiedad.setNombre("Casa de desierto");
        propiedad.setPrecio(900000.00);
        propiedad.setOperacion("Alquiler");
        propiedad.setDimensiones("1000");
        propiedad.setHabitaciones(12);
        propiedad.setPatio("No");
        propiedad.setDireccion(direcciones.get(7));
        propiedad.setBanios(1);
        propiedad.setCocina("No");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("No");
        propiedad.setMuebles("No");
        propiedad.setWifi("No");
        propiedad.setNumeroAutos(2);

        propiedades.add(propiedad);

        propiedad = new Propiedad();

        propiedad.setClaveCatastral("91011121314151617181");
        propiedad.setNombre("Casa de pradera");
        propiedad.setPrecio(900000.00);
        propiedad.setOperacion("venta");
        propiedad.setDimensiones("9000 m2");
        propiedad.setHabitaciones(11);
        propiedad.setPatio("Sí");
        propiedad.setDireccion(direcciones.get(8));
        propiedad.setBanios(2);
        propiedad.setCocina("Sí");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("Sí");
        propiedad.setMuebles("Sí");
        propiedad.setWifi("Sí");
        propiedad.setNumeroAutos(3);

        propiedades.add(propiedad);

        propiedad = new Propiedad();

        propiedad.setClaveCatastral("10111213141516171819");
        propiedad.setNombre("Casa de selva");
        propiedad.setPrecio(100000.00);
        propiedad.setOperacion("alquiler");
        propiedad.setDimensiones("1000 m2");
        propiedad.setHabitaciones(12);
        propiedad.setPatio("No");
        propiedad.setDireccion(direcciones.get(9));
        propiedad.setBanios(1);
        propiedad.setCocina("No");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("No");
        propiedad.setMuebles("No");
        propiedad.setWifi("No");
        propiedad.setNumeroAutos(2);

        propiedades.add(propiedad);
    }

    private void iniciarClientes() {
        Cliente cliente = new Cliente();

        cliente.setIdCliente(1);
        cliente.setNombre("Juan");
        cliente.setApellidoPaterno("Pérez");
        cliente.setCorreoElectronico("juanperez@gmail.com");
        cliente.setClave("12345");

        clientes.add(cliente);

        cliente = new Cliente();

        cliente.setIdCliente(2);
        cliente.setNombre("María");
        cliente.setApellidoPaterno("Gómez");
        cliente.setCorreoElectronico("mariagomez@gmail.com");
        cliente.setClave("23456");

        clientes.add(cliente);

        cliente = new Cliente();

        cliente.setIdCliente(3);
        cliente.setNombre("José");
        cliente.setApellidoPaterno("Hernández");
        cliente.setCorreoElectronico("josehernandez@gmail.com");
        cliente.setClave("34567");

        clientes.add(cliente);

        cliente = new Cliente();

        cliente.setIdCliente(4);
        cliente.setNombre("Ana");
        cliente.setApellidoPaterno("Martínez");
        cliente.setCorreoElectronico("anamartinez@gmail.com");
        cliente.setClave("45678");

        clientes.add(cliente);

        cliente = new Cliente();

        cliente.setIdCliente(5);
        cliente.setNombre("Pedro");
        cliente.setApellidoPaterno("López");
        cliente.setCorreoElectronico("pedrolopez@gmail.com");
        cliente.setClave("56789");

        clientes.add(cliente);

        cliente = new Cliente();

        cliente.setIdCliente(6);
        cliente.setNombre("Laura");
        cliente.setApellidoPaterno("Torres");
        cliente.setCorreoElectronico("lauratorres@gmail.com");
        cliente.setClave("67890");

        clientes.add(cliente);

        cliente = new Cliente();

        cliente.setIdCliente(7);
        cliente.setNombre("Carlos");
        cliente.setApellidoPaterno("Sánchez");
        cliente.setCorreoElectronico("carlossanchez@gmail.com");
        cliente.setClave("78901");

        clientes.add(cliente);

        cliente = new Cliente();

        cliente.setIdCliente(8);
        cliente.setNombre("Sofía");
        cliente.setApellidoPaterno("Ramírez");
        cliente.setCorreoElectronico("sofiaramirez@gmail.com");
        cliente.setClave("89012");

        clientes.add(cliente);

        cliente = new Cliente();

        cliente.setIdCliente(9);
        cliente.setNombre("Jorge");
        cliente.setApellidoPaterno("García");
        cliente.setCorreoElectronico("jorgegarcia@gmail.com");
        cliente.setClave("90123");

        clientes.add(cliente);

        cliente = new Cliente();

        cliente.setIdCliente(10);

        cliente.setNombre("Verónica");
        cliente.setApellidoPaterno("Fernández");
        cliente.setCorreoElectronico("veronicafernadez@gmail.com");
        cliente.setClave("01234");

        clientes.add(cliente);
    }
}
