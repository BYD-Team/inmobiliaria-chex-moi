package chexmoi.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chexmoi.modelo.Cliente;

public class ClienteControlador {
    private GestorBaseDeDatos gestorBaseDeDatos;

    public ClienteControlador() {
        gestorBaseDeDatos = new GestorBaseDeDatos();
    }

    public int registrarCliente(Cliente cliente) throws SQLException {
        Connection conexion;
        PreparedStatement preparedStatement; 
        String query = "INSERT INTO cliente (nombre, apellidoPaterno, correoElectronico, clave) VALUES (?, ?, ?, SHA2(?,256))";
        int filasAfectadas = 0;

        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellidoPaterno());
            preparedStatement.setString(3, cliente.getCorreoElectronico());
            preparedStatement.setString(4, cliente.getClave());

            filasAfectadas = preparedStatement.executeUpdate();
        
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
            throw sqlException;
        
        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }

        return filasAfectadas;
    }

    public Cliente obtenerCliente(String correoElectronico, String clave) throws SQLException {
        Connection conexion;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = "SELECT * FROM cliente WHERE correoElectronico = ? AND clave = SHA2(?,256)";
        Cliente cliente = null;

        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, correoElectronico);
            preparedStatement.setString(2, clave);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellidoPaterno(resultSet.getString("apellidoPaterno"));
                cliente.setCorreoElectronico(resultSet.getString("correoElectronico"));
                cliente.setClave(resultSet.getString("clave"));
            }
        
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
            throw sqlException;
        
        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }

        return cliente;
    }
}
