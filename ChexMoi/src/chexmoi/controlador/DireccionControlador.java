package chexmoi.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chexmoi.modelo.Direccion;

public class DireccionControlador {
    private GestorBaseDeDatos gestorBaseDeDatos;

    public DireccionControlador() {
        gestorBaseDeDatos = new GestorBaseDeDatos();
    }
    
    public int agregarDireccion(Direccion direccion) throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultSet = null;
        int idDireccion = 0;
    
        String consulta = "INSERT INTO Direccion (calle, colonia, cp, numeroExterior, numeroInterior) VALUES (?, ?, ?, ?, ?)";
    
        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS);
    
            sentencia.setString(1, direccion.getCalle());
            sentencia.setString(2, direccion.getColonia());
            sentencia.setString(3, direccion.getCodigoPostal());
            sentencia.setInt(4, direccion.getNumeroExterior());
            sentencia.setInt(5, direccion.getNumeroInterior());
    
            sentencia.executeUpdate();
            resultSet = sentencia.getGeneratedKeys();
            if (resultSet.next()) {
                idDireccion = resultSet.getInt(1);
            }
    
        } catch (SQLException sqlExcepcion) {
            throw sqlExcepcion;
    
        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }
    
        return idDireccion;
    }  

    public int editarDireccion(Direccion direccion) throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int resultadoConsulta = 0;
    
        String consulta = "UPDATE Direccion SET calle = ?, colonia = ?, cp = ?, numeroExterior = ?, numeroInterior = ? WHERE idDireccion = ?";
    
        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);
    
            sentencia.setString(1, direccion.getCalle());
            sentencia.setString(2, direccion.getColonia());
            sentencia.setString(3, direccion.getCodigoPostal());
            sentencia.setInt(4, direccion.getNumeroExterior());
            sentencia.setInt(5, direccion.getNumeroInterior());
            sentencia.setInt(6, direccion.getIdDireccion());
    
            resultadoConsulta = sentencia.executeUpdate();
    
        } catch (SQLException sqlExcepcion) {
            throw sqlExcepcion;
    
        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }
    
        return resultadoConsulta;
    }
}
