package chexmoi.modelo;

public class Direccion {
    private int idDireccion;
    private String calle;
    private String colonia;
    private String codigoPostal;
    private int numeroExterior;
    private int numeroInterior;

    public Direccion() {
        this.idDireccion = 0;
        this.calle = "";
        this.colonia = "";
        this.codigoPostal = "";
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
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

    public boolean equals(Direccion direccion) {
        return this.idDireccion == direccion.getIdDireccion()
            && this.calle.equals(direccion.getCalle())
            && this.colonia.equals(direccion.getColonia())
            && this.codigoPostal.equals(direccion.getCodigoPostal())
            && this.numeroExterior == direccion.getNumeroExterior()
            && this.numeroInterior == direccion.getNumeroInterior();
    }
}
