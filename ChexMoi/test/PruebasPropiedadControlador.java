import chexmoi.controlador.PropiedadControlador;
import chexmoi.modelo.Cliente;
import chexmoi.modelo.Direccion;
import chexmoi.modelo.Propiedad;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class PruebasPropiedadControlador {
    private PropiedadControlador controlador;
    private Inicial inicial;

    @Before
    public void setUp() {
        controlador = new PropiedadControlador();
        inicial = new Inicial(); 
    }

    @Test
    public void testObtenerPropiedades() {
        try {
            List<Propiedad> propiedades = controlador.obtenerPropiedades();
            assertNotNull(propiedades);
            assertTrue(propiedades.size() > 0);
        } catch (SQLException e) {
            fail("Error al obtener propiedades: " + e.getMessage());
        }
    }

    @Test
    public void testAgregarPropiedad() {
        Cliente cliente = inicial.obtenerClientes().get(0);
        Direccion direccion = inicial.obtenerDirecciones().get(0);

        Propiedad propiedad = new Propiedad();
        propiedad.setClaveCatastral("11122233344455566677");
        propiedad.setNombre("Nueva Propiedad");
        propiedad.setPrecio(500000.00);
        propiedad.setOperacion("Venta");
        propiedad.setDimensiones("2000");
        propiedad.setHabitaciones(5);
        propiedad.setPatio("Sí");
        propiedad.setDireccion(direccion);
        propiedad.setBanios(3);
        propiedad.setCocina("Sí");
        propiedad.setEstacionamiento("Sí");
        propiedad.setTerraza("Sí");
        propiedad.setMuebles("Sí");
        propiedad.setWifi("Sí");
        propiedad.setNumeroAutos(2);

        try {
            int resultado = controlador.agregarPropiedad(cliente, propiedad);
            assertEquals(1, resultado);
        } catch (SQLException e) {
            fail("Error al agregar propiedad: " + e.getMessage());
        }
    }

    @Test
    public void testEditarPropiedad() {
        Propiedad propiedad = inicial.obtenerPropiedades().get(0);
        propiedad.setNombre("Propiedad Editada");

        try {
            int resultado = controlador.editarPropiedad(propiedad);
            assertEquals(1, resultado);
        } catch (SQLException e) {
            fail("Error al editar propiedad: " + e.getMessage());
        }
    }

    @Test
    public void testObtenerMisPropiedades() {
        Cliente cliente = inicial.obtenerClientes().get(0);

        try {
            List<Propiedad> propiedades = controlador.obtenerMisPropiedades(cliente);
            assertNotNull(propiedades);
            assertTrue(propiedades.size() > 0);
        } catch (SQLException e) {
            fail("Error al obtener mis propiedades: " + e.getMessage());
        }
    }

    @Test
    public void testAgregarPropietario() throws SQLException {
        Cliente cliente = inicial.obtenerClientes().get(0);
        Propiedad propiedad = inicial.obtenerPropiedades().get(0);

        int resultado = controlador.agregarPropietario(
            propiedad.getClaveCatastral(), 
            propiedad.getDireccion().getIdDireccion(), 
            cliente.getIdCliente()
        );
        
        assertEquals(1, resultado);
    }
}
