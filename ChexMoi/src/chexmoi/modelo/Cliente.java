package chexmoi.modelo;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String correoElectronico;
    private String telefono;
    private String clave;

    public Cliente() {
        this.idCliente = 0;
        this.nombre = "";
        this.apellidoPaterno = "";
        this.correoElectronico = "";
        this.clave = "";
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

    public String getTelefono() {
        return telefono;
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
