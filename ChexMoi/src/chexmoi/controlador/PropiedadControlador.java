package chexmoi.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chexmoi.modelo.Propiedad;

public class PropiedadControlador {
    private GestorBaseDeDatos gestorBaseDeDatos;

    public PropiedadControlador() {
        gestorBaseDeDatos = new GestorBaseDeDatos();
    }

    public List<Propiedad> obtenerPropiedades() {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        String consulta = "SELECT * FROM Propiedad";
        List<Propiedad> propiedades = new ArrayList<Propiedad>();

        try {
            // conexion = gestorBaseDeDatos.abrirConexion();
            sentencia = conexion.prepareStatement(consulta);

            ResultSet resultadoConsulta = sentencia.executeQuery();

            while (resultadoConsulta.next()) {
                Propiedad propiedad = new Propiedad();

                propiedad.setIdPropiedad(resultadoConsulta.getInt("idPropiedad"));
                propiedad.setNombre(resultadoConsulta.getString("nombre"));
                propiedad.setPrecio(resultadoConsulta.getFloat("precio"));
                propiedad.setOperacion(resultadoConsulta.getString("operacion"));
                propiedad.setDimensiones(resultadoConsulta.getString("dimensiones"));
                propiedad.setHabitaciones(resultadoConsulta.getInt("habitaciones"));
                propiedad.setPatio(resultadoConsulta.getString("patio"));

                propiedades.add(propiedad);
            }

        } catch (Exception exepcion) {
            exepcion.printStackTrace();

        } finally {
            // gestorBaseDeDatos.cerrarConexion();
        }

        return propiedades;
    } 

    public int editarNombrePropiedad(int idPropiedad, String nombre) {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        String consulta = "UPDATE Propiedad SET nombre = ? WHERE idPropiedad = ?";
        int resultadoEditar = 0;

        try {
            // conexion = gestorBaseDeDatos.abrirConexion();
            sentencia = conexion.prepareStatement(consulta);

            sentencia.setString(1, nombre);

            resultadoEditar = sentencia.executeUpdate();

        } catch (Exception exepcion) {
            exepcion.printStackTrace();

        } finally {
            // gestorBaseDeDatos.cerrarConexion();
        }

        return resultadoEditar;
    }

    public int editarPrecioPropiedad(int idPropiedad, float precio) {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        String consulta = "UPDATE Propiedad SET precio = ? WHERE idPropiedad = ?";
        int resultadoEditar = 0;

        try {
            // conexion = gestorBaseDeDatos.abrirConexion();
            sentencia = conexion.prepareStatement(consulta);

            sentencia.setFloat(1, precio);

            resultadoEditar = sentencia.executeUpdate();

        } catch (Exception exepcion) {
            exepcion.printStackTrace();

        } finally {
            // gestorBaseDeDatos.cerrarConexion();
        }

        return resultadoEditar;
    }

    public int editarOperacionPropiedad(int idPropiedad, String operacion) {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        String consulta = "UPDATE Propiedad SET operacion = ? WHERE idPropiedad = ?";
        int resultadoEditar = 0;

        try {
            // conexion = gestorBaseDeDatos.abrirConexion();
            sentencia = conexion.prepareStatement(consulta);

            sentencia.setString(1, operacion);

            resultadoEditar = sentencia.executeUpdate();

        } catch (Exception exepcion) {
            exepcion.printStackTrace();

        } finally {
            // gestorBaseDeDatos.cerrarConexion();
        }

        return resultadoEditar;
    }
}
