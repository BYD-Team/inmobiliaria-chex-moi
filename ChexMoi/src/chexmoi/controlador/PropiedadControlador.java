package chexmoi.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import chexmoi.modelo.Cliente;
import chexmoi.modelo.Direccion;
import chexmoi.modelo.Propiedad;

public class PropiedadControlador {
    private GestorBaseDeDatos gestorBaseDeDatos;

    public PropiedadControlador() {
        gestorBaseDeDatos = new GestorBaseDeDatos();
    }

    public List<Propiedad> obtenerPropiedades() throws SQLException {
        Connection conexion;
        PreparedStatement sentencia;
        ResultSet resultadoConsulta;

        String consulta = "SELECT claveCatastral, nombre, precio, operacion, dimensiones, habitaciones, patio, " +
                  "idDireccion, calle, colonia, cp, numeroExterior, numeroInterior, numeroAutos, " +
                  "baños, wifi, cocina, estacionamiento, muebles, terraza " +
                  "FROM Propiedad INNER JOIN Direccion " +
                  "ON idDireccion = Direccion_idDireccion";
        

        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        Propiedad propiedad;
        Direccion direccion;

        DecimalFormat formatoDecimal = new DecimalFormat("#.##");

        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);
            resultadoConsulta = sentencia.executeQuery();

            while (resultadoConsulta.next()) {
                propiedad = new Propiedad();

                propiedad.setClaveCatastral(resultadoConsulta.getString("claveCatastral"));
                propiedad.setNombre(resultadoConsulta.getString("nombre"));
                double precio = resultadoConsulta.getDouble("precio");
                String precioFormateado = formatoDecimal.format(precio);
                propiedad.setPrecio(Double.parseDouble(precioFormateado));
                propiedad.setOperacion(resultadoConsulta.getString("operacion"));
                propiedad.setDimensiones(resultadoConsulta.getString("dimensiones"));
                propiedad.setHabitaciones(resultadoConsulta.getInt("habitaciones"));
                propiedad.setBanios(resultadoConsulta.getInt("baños"));
                propiedad.setPatio(resultadoConsulta.getString("patio"));
                propiedad.setWifi(resultadoConsulta.getString("wifi"));
                propiedad.setCocina(resultadoConsulta.getString("cocina"));
                propiedad.setEstacionamiento(resultadoConsulta.getString("estacionamiento"));
                propiedad.setMuebles(resultadoConsulta.getString("muebles"));
                propiedad.setTerraza(resultadoConsulta.getString("terraza"));
                propiedad.setNumeroAutos(resultadoConsulta.getInt("numeroAutos"));

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

        } catch (SQLException sqlExepcion) {
            throw sqlExepcion;

        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }

        return propiedades;
    }

    public List<Propiedad> obtenerPropiedadesConFiltros(String[] filtro) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultadoConsulta = null;
        List<Propiedad> propiedades = new ArrayList<>();
    
        String consulta = "CALL filterPropiedades(?, ?, ?, ?, ?, ?, ?, ?)";
    
        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);
    
            sentencia.setObject(1, filtro[0] != null && !filtro[0].isEmpty() ? Double.parseDouble(filtro[0]) : null, java.sql.Types.DOUBLE);
            sentencia.setString(2, filtro[2]);
            sentencia.setObject(3, filtro[1] != null && !filtro[1].isEmpty() ? Integer.parseInt(filtro[1]) : null, java.sql.Types.INTEGER);
            sentencia.setString(4, filtro[3]);
            sentencia.setString(5, filtro[4]);
            sentencia.setString(6, filtro[5]);
            sentencia.setString(7, filtro[6]);
            sentencia.setString(8, filtro[7]);
    
            resultadoConsulta = sentencia.executeQuery();
    
            while (resultadoConsulta.next()) {
                Propiedad propiedad = new Propiedad();
    
                propiedad.setClaveCatastral(resultadoConsulta.getString("claveCatastral"));
                propiedad.setNombre(resultadoConsulta.getString("nombre"));
                propiedad.setPrecio(resultadoConsulta.getDouble("precio"));
                propiedad.setOperacion(resultadoConsulta.getString("operacion"));
                propiedad.setDimensiones(resultadoConsulta.getString("dimensiones"));
                propiedad.setHabitaciones(resultadoConsulta.getInt("habitaciones"));
                propiedad.setBanios(resultadoConsulta.getInt("baños"));
                propiedad.setPatio(resultadoConsulta.getString("patio"));
                propiedad.setCocina(resultadoConsulta.getString("cocina"));
                propiedad.setEstacionamiento(resultadoConsulta.getString("estacionamiento"));
                propiedad.setMuebles(resultadoConsulta.getString("muebles"));
                propiedad.setTerraza(resultadoConsulta.getString("terraza"));
                propiedad.setWifi(resultadoConsulta.getString("wifi"));
                propiedad.setNumeroAutos(resultadoConsulta.getInt("numeroAutos"));
    
                Direccion direccion = new Direccion();
                direccion.setIdDireccion(resultadoConsulta.getInt("idDireccion"));
                direccion.setCalle(resultadoConsulta.getString("calle"));
                direccion.setColonia(resultadoConsulta.getString("colonia"));
                direccion.setCodigoPostal(resultadoConsulta.getString("cp"));
                direccion.setNumeroExterior(resultadoConsulta.getInt("numeroExterior"));
                direccion.setNumeroInterior(resultadoConsulta.getInt("numeroInterior"));
    
                propiedad.setDireccion(direccion);
                propiedades.add(propiedad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultadoConsulta != null) resultadoConsulta.close();
                if (sentencia != null) sentencia.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        return propiedades;
    }
    
    public int editarPropiedad(Propiedad propiedad) throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int resultadoConsulta = 0;
    
        String consulta = "UPDATE Propiedad SET nombre = ?, precio = ?, operacion = ?, dimensiones = ?, habitaciones = ?, baños = ?, patio = ?, wifi = ?, cocina = ?, estacionamiento = ?, muebles = ?, terraza = ?, numeroAutos = ? WHERE claveCatastral = ?";
    
        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);
    
            sentencia.setString(1, propiedad.getNombre());
            sentencia.setDouble(2, propiedad.getPrecio());
            sentencia.setString(3, propiedad.getOperacion());
            sentencia.setString(4, propiedad.getDimensiones());
            sentencia.setInt(5, propiedad.getHabitaciones());
            sentencia.setInt(6, propiedad.getBanios());
            sentencia.setString(7, propiedad.getPatio());
            sentencia.setString(8, propiedad.getWifi());
            sentencia.setString(9, propiedad.getCocina());
            sentencia.setString(10, propiedad.getEstacionamiento());
            sentencia.setString(11, propiedad.getMuebles());
            sentencia.setString(12, propiedad.getTerraza());
            sentencia.setInt(13, propiedad.getNumeroAutos());
            sentencia.setString(14, propiedad.getClaveCatastral());
    
            resultadoConsulta = sentencia.executeUpdate();
    
        } catch (SQLException sqlExcepcion) {
            throw sqlExcepcion;
    
        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }
    
        return resultadoConsulta;
    }
    

    public int agregarPropiedad(Cliente cliente, Propiedad propiedad) throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int resultadoConsulta = 0;
    
        String consulta = "INSERT INTO Propiedad (claveCatastral, nombre, precio, operacion, dimensiones, habitaciones, baños, patio, wifi, estacionamiento, cocina, muebles, terraza, Direccion_idDireccion, numeroAutos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS);
    
            sentencia.setString(1, propiedad.getClaveCatastral());
            sentencia.setString(2, propiedad.getNombre());
            sentencia.setDouble(3, propiedad.getPrecio());
            sentencia.setString(4, propiedad.getOperacion());
            sentencia.setString(5, propiedad.getDimensiones());
            sentencia.setInt(6, propiedad.getHabitaciones());
            sentencia.setInt(7, propiedad.getBanios()); 
            sentencia.setString(8, propiedad.getPatio());
            sentencia.setString(9, propiedad.getWifi());
            sentencia.setString(10, propiedad.getEstacionamiento());
            sentencia.setString(11, propiedad.getCocina());
            sentencia.setString(12, propiedad.getMuebles());
            sentencia.setString(13, propiedad.getTerraza());
            sentencia.setInt(14, propiedad.getDireccion().getIdDireccion());
            sentencia.setInt(15, propiedad.getNumeroAutos());
    
            resultadoConsulta = sentencia.executeUpdate();
    
        } catch (SQLException sqlExcepcion) {
            throw sqlExcepcion;
    
        } finally {
            gestorBaseDeDatos.cerrarConexion();
        }
    
        return resultadoConsulta;
    }
    
    
    public int agregarPropietario(String claveCatastral, int idDireccion, int idCliente) throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int resultadoConsulta = 0;
    
        String consulta = "INSERT INTO propietario (Propiedad_claveCatastral, Propiedad_Direccion_idDireccion, Cliente_idCliente) VALUES (?, ?, ?)";
    
        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);
    
            sentencia.setString(1, claveCatastral);
            sentencia.setInt(2, idDireccion);
            sentencia.setInt(3, idCliente);
    
            resultadoConsulta = sentencia.executeUpdate();
    
        } catch (SQLException sqlExcepcion) {
            throw sqlExcepcion;
    
        } finally {
            if (sentencia != null) try { sentencia.close(); } catch (SQLException ignore) {}
            if (conexion != null) try { conexion.close(); } catch (SQLException ignore) {}
        }
    
        return resultadoConsulta;
    }

    public List<Propiedad> obtenerMisPropiedades(Cliente cliente) throws SQLException {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultadoConsulta = null;
        List<Propiedad> propiedades = new ArrayList<>();
    
        String consulta = "SELECT p.claveCatastral, p.nombre, p.precio, p.operacion, p.dimensiones, p.habitaciones, p.patio, " +
                          "p.baños, p.wifi, p.cocina, p.estacionamiento, p.muebles, p.terraza, p.numeroAutos, " +
                          "d.idDireccion, d.calle, d.colonia, d.cp, d.numeroExterior, d.numeroInterior " +
                          "FROM propietario pr " +
                          "JOIN Propiedad p ON pr.Propiedad_claveCatastral = p.claveCatastral " +
                          "JOIN Direccion d ON p.Direccion_idDireccion = d.idDireccion " +
                          "WHERE pr.Cliente_idCliente = ?";
    
        try {
            conexion = gestorBaseDeDatos.obtenerConexion();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, cliente.getIdCliente());
            resultadoConsulta = sentencia.executeQuery();
    
            while (resultadoConsulta.next()) {
                Propiedad propiedad = new Propiedad();
    
                propiedad.setClaveCatastral(resultadoConsulta.getString("claveCatastral"));
                propiedad.setNombre(resultadoConsulta.getString("nombre"));
                propiedad.setPrecio(resultadoConsulta.getDouble("precio"));
                propiedad.setOperacion(resultadoConsulta.getString("operacion"));
                propiedad.setDimensiones(resultadoConsulta.getString("dimensiones"));
                propiedad.setHabitaciones(resultadoConsulta.getInt("habitaciones"));
                propiedad.setPatio(resultadoConsulta.getString("patio"));
                propiedad.setBanios(resultadoConsulta.getInt("baños"));
                propiedad.setWifi(resultadoConsulta.getString("wifi"));
                propiedad.setCocina(resultadoConsulta.getString("cocina"));
                propiedad.setEstacionamiento(resultadoConsulta.getString("estacionamiento"));
                propiedad.setMuebles(resultadoConsulta.getString("muebles"));
                propiedad.setTerraza(resultadoConsulta.getString("terraza"));
                propiedad.setNumeroAutos(resultadoConsulta.getInt("numeroAutos"));               
    
                Direccion direccion = new Direccion();
                direccion.setIdDireccion(resultadoConsulta.getInt("idDireccion"));
                direccion.setCalle(resultadoConsulta.getString("calle"));
                direccion.setColonia(resultadoConsulta.getString("colonia"));
                direccion.setCodigoPostal(resultadoConsulta.getString("cp"));
                direccion.setNumeroExterior(resultadoConsulta.getInt("numeroExterior"));
                direccion.setNumeroInterior(resultadoConsulta.getInt("numeroInterior"));
    
                propiedad.setDireccion(direccion);
                propiedades.add(propiedad);
            }
            
        } catch (SQLException sqlExcepcion) {
            sqlExcepcion.printStackTrace();
            throw sqlExcepcion;
        } finally {
            if (resultadoConsulta != null) try { resultadoConsulta.close(); } catch (SQLException ignore) {}
            if (sentencia != null) try { sentencia.close(); } catch (SQLException ignore) {}
            if (conexion != null) try { conexion.close(); } catch (SQLException ignore) {}
        }
    
        return propiedades;
    }
       
}
