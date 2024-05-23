package modelo;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String correoElectronico;
    private String clave;

    public Cliente() {

    }

    public int getIdCliente() {
        return idCliente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
