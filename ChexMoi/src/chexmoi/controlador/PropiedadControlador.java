package chexmoi.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chexmoi.modelo.Direccion;
import chexmoi.modelo.Propiedad;

public class PropiedadControlador {
    private GestorBaseDeDatos gestorBaseDeDatos;

    public PropiedadControlador() {
        gestorBaseDeDatos = new GestorBaseDeDatos();
    }

    public List<Propiedad> obtenerPropiedades() {
        Connection conexion;
        PreparedStatement sentencia;
        ResultSet resultadoConsulta;

        String consulta = "";

        consulta += "SELECT idPropiedad, nombre, precio, operacion, dimensiones, habitaciones, patio, ";
        consulta += "idDireccion, calle, colonia, cp, numeroExterior, numeroInterior ";
        consulta += "FROM Propiedad INNER JOIN Direccion ";
        consulta += "ON idDireccion = Direccion_idDireccion";

        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        Propiedad propiedad;
        Direccion direccion;

        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();

            while (resultadoConsulta.next()) {
                propiedad = new Propiedad();

                propiedad.setIdPropiedad(resultadoConsulta.getInt("idPropiedad"));
                propiedad.setNombre(resultadoConsulta.getString("nombre"));
                propiedad.setPrecio(resultadoConsulta.getFloat("precio"));
                propiedad.setOperacion(resultadoConsulta.getString("operacion"));
                propiedad.setDimensiones(resultadoConsulta.getString("dimensiones"));
                propiedad.setHabitaciones(resultadoConsulta.getInt("habitaciones"));
                propiedad.setPatio(resultadoConsulta.getString("patio"));

                direccion = new Direccion();

                direccion.setIdDireccion(resultadoConsulta.getInt("idDireccion"));
                direccion.setCalle(resultadoConsulta.getString("calle"));
                direccion.setColonia(resultadoConsulta.getString("colonia"));
                direccion.setCodigoPostal(resultadoConsulta.getString("cp"));
                direccion.setNumeroExterior(resultadoConsulta.getInt("numeroExterior"));
                direccion.setNumeroInterior(resultadoConsulta.getInt("numeroInterior"));

                propiedad.setDireccion(direccion);
                propiedades.add(propiedad);
            }

        } catch (Exception exepcion) {
            exepcion.printStackTrace();

        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }

        return propiedades;
    }

    public int editarNombrePropiedad(int idPropiedad, String nombre) {
        Connection conexion;
        PreparedStatement sentencia;

        String consulta = "UPDATE Propiedad SET nombre = ? WHERE idPropiedad = ?";
        int resultadoEditar = 0;

        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);

            sentencia.setString(1, nombre);
            sentencia.setInt(2, idPropiedad);

            resultadoEditar = sentencia.executeUpdate();

        } catch (Exception exepcion) {
            exepcion.printStackTrace();

        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }

        return resultadoEditar;
    }

    public int editarPrecioPropiedad(int idPropiedad, float precio) {
        Connection conexion;
        PreparedStatement sentencia;

        String consulta = "UPDATE Propiedad SET precio = ? WHERE idPropiedad = ?";
        int resultadoEditar = 0;

        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);

            sentencia.setFloat(1, precio);
            sentencia.setInt(2, idPropiedad);

            resultadoEditar = sentencia.executeUpdate();

        } catch (Exception exepcion) {
            exepcion.printStackTrace();

        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }

        return resultadoEditar;
    }

    public int editarOperacionPropiedad(int idPropiedad, String operacion) {
        Connection conexion;
        PreparedStatement sentencia;

        String consulta = "UPDATE Propiedad SET operacion = ? WHERE idPropiedad = ?";
        int resultadoEditar = 0;

        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);

            sentencia.setString(1, operacion);
            sentencia.setInt(2, idPropiedad);

            resultadoEditar = sentencia.executeUpdate();

        } catch (Exception exepcion) {
            exepcion.printStackTrace();

        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }

        return resultadoEditar;
    }
}
