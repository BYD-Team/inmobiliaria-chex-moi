package chexmoi.modelo;

public class Direccion {
    private int idDireccion;
    private String calle;
    private String colonia;
    private int codigoPostal;
    private int numeroExterior;
    private int numeroInterior;

    public Direccion() {
        this.idDireccion = 0;
        this.calle = "";
        this.colonia = "";
        this.codigoPostal = 0;
        this.numeroExterior = 0;
        this.numeroInterior = 0;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(int numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public int getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(int numeroInterior) {
        this.numeroInterior = numeroInterior;
    }
}
