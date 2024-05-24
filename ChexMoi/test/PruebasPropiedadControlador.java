import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import chexmoi.controlador.PropiedadControlador;
import chexmoi.modelo.Propiedad;

public class PruebasPropiedadControlador {
    public Inicial inicial = new Inicial();

    @Test
    public void pruebaObtenerPropiedadesExitosa() throws Exception {
        PropiedadControlador propiedadControlador = new PropiedadControlador();

        List<Propiedad> propiedadesExperadas = inicial.obtenerPropiedades();
        List<Propiedad> propiedadesActuales = propiedadControlador.obtenerPropiedades();

        assertEquals(propiedadesExperadas.size(), propiedadesActuales.size());

        for (int i = 0; i < propiedadesExperadas.size(); i++) {
            assertTrue(propiedadesExperadas.get(i).equals(propiedadesActuales.get(i)));
        }
    }

    @Test
    public void pruebaEditarNombreDePropiedadExitosa() throws Exception {
        Propiedad propiedadOriginal = inicial.obtenerPropiedades().get(0);

        PropiedadControlador propiedadControlador = new PropiedadControlador();
        int resultadoEditar;

        resultadoEditar = propiedadControlador.editarNombrePropiedad(propiedadOriginal.getIdPropiedad(), "Casa de Prueba");
        assertEquals(1, resultadoEditar);

        resultadoEditar = propiedadControlador.editarNombrePropiedad(propiedadOriginal.getIdPropiedad(), propiedadOriginal.getNombre());
        assertEquals(1, resultadoEditar);
    }

    @Test
    public void pruebaEditarNombreDePropiedadFallida() throws SQLException {
        PropiedadControlador propiedadControlador = new PropiedadControlador();
        int resultadoEditar = propiedadControlador.editarNombrePropiedad(-1, "Casa de Prueba");

        assertEquals(0, resultadoEditar);
    }

    @Test
    public void pruebaEditarPrecioDePropiedadExitosa() throws Exception {
        Propiedad propiedadOriginal = inicial.obtenerPropiedades().get(0);

        PropiedadControlador propiedadControlador = new PropiedadControlador();
        int resultadoEditar;

        resultadoEditar = propiedadControlador.editarPrecioPropiedad(propiedadOriginal.getIdPropiedad(), 1000000);
        assertEquals(1, resultadoEditar);

        resultadoEditar = propiedadControlador.editarPrecioPropiedad(propiedadOriginal.getIdPropiedad(), propiedadOriginal.getPrecio());
        assertEquals(1, resultadoEditar);
    }

    @Test
    public void pruebaEditarPrecioDePropiedadFallida() throws SQLException {
        PropiedadControlador propiedadControlador = new PropiedadControlador();
        int resultadoEditar = propiedadControlador.editarPrecioPropiedad(-1, 1000000);

        assertEquals(0, resultadoEditar);
    }

    @Test
    public void pruebaEditarOperacionDePropiedadExitosa() throws Exception {
        Propiedad propiedadOriginal = inicial.obtenerPropiedades().get(0);

        PropiedadControlador propiedadControlador = new PropiedadControlador();
        int resultadoEditar;

        resultadoEditar = propiedadControlador.editarOperacionPropiedad(propiedadOriginal.getIdPropiedad(), "Venta");
        assertEquals(1, resultadoEditar);

        resultadoEditar = propiedadControlador.editarOperacionPropiedad(propiedadOriginal.getIdPropiedad(), propiedadOriginal.getOperacion());
        assertEquals(1, resultadoEditar);
    }

    @Test
    public void pruebaEditarOperacionDePropiedadFallida() throws SQLException {
        PropiedadControlador propiedadControlador = new PropiedadControlador();
        int resultadoEditar = propiedadControlador.editarOperacionPropiedad(-1, "Venta");

        assertEquals(0, resultadoEditar);
    }

}
