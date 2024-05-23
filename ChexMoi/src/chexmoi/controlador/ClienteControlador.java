package chexmoi.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import chexmoi.modelo.Cliente;

public class ClienteControlador {
    private GestorBaseDeDatos gestorBaseDeDatos;

    public ClienteControlador() {
        gestorBaseDeDatos = new GestorBaseDeDatos();
    }

    public int registrarCliente(Cliente cliente) {
        Connection conexion;
        PreparedStatement preparedStatement; 
        String query = "INSERT INTO cliente (nombre, apellido_paterno, correo_electronico, clave) VALUES (?, ?, ?, ?)";
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
        }

        return filasAfectadas;
    }
}
