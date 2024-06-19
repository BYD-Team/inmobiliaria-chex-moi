package chexmoi.modelo;

public class Propiedad {
    private String claveCatastral;
    private String nombre;
    private Double precio;
    private String operacion;
    private String dimensiones;
    private int habitaciones;
    private String patio;
    private Direccion direccion;
    private int banios; 
    private String wifi; 
    private String mascotas; 
    private String estacionamiento;
    private String cocina; 
    private String muebles; 
    private String terraza; 
    private int numeroAutos;

    public Propiedad() {
        this.precio = 0.0;
        this.nombre = "";
        this.operacion = "";
        this.dimensiones = "";
        this.habitaciones = 0;
        this.patio = "";
        this.banios = 0;
        this.wifi = "";
        this.mascotas = "";
        this.estacionamiento = "";
        this.cocina = "";
        this.muebles = "";
        this.terraza = "";
        this.direccion = null;
        this.numeroAutos = 0;
    }

    public String getClaveCatastral() {
        return claveCatastral;
    }

    public void setClaveCatastral(String claveCatastral) {
        this.claveCatastral = claveCatastral;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getPatio() {
        return patio;
    }

    public void setPatio(String patio) {
        this.patio = patio;
    }

    public int getBanios() {
        return banios;
    }

    public void setBanios(int banios) {
        this.banios = banios;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getMascotas() {
        return mascotas;
    }

    public void setMascotas(String mascotas) {
        this.mascotas = mascotas;
    }

    public String getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(String estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    public String getCocina() {
        return cocina;
    }

    public void setCocina(String cocina) {
        this.cocina = cocina;
    }

    public String getMuebles() {
        return muebles;
    }

    public void setMuebles(String muebles) {
        this.muebles = muebles;
    }

    public String getTerraza() {
        return terraza;
    }

    public void setTerraza(String terraza) {
        this.terraza = terraza;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setNumeroAutos(int numeroAutos) {
        this.numeroAutos = numeroAutos;
    }

    public int getNumeroAutos() {
        return numeroAutos;
    }

    public boolean equals(Propiedad propiedad) {
        return this.claveCatastral == propiedad.getClaveCatastral()
            && this.nombre.equals(propiedad.getNombre())
            && this.precio == propiedad.getPrecio()
            && this.operacion.equals(propiedad.getOperacion())
            && this.dimensiones.equals(propiedad.getDimensiones())
            && this.habitaciones == propiedad.getHabitaciones()
            && this.patio.equals(propiedad.getPatio())
            && this.direccion.equals(propiedad.getDireccion())
            && this.banios == propiedad.getBanios()
            && this.wifi.equals(propiedad.getWifi())
            && this.mascotas.equals(propiedad.getMascotas())
            && this.estacionamiento.equals(propiedad.getEstacionamiento())
            && this.cocina.equals(propiedad.getCocina())
            && this.muebles.equals(propiedad.getMuebles())
            && this.terraza.equals(propiedad.getTerraza())
            && this.numeroAutos == propiedad.getNumeroAutos();
    }
}
