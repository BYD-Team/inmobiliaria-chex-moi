package chexmoi.controlador;

import java.text.DecimalFormat;

import chexmoi.modelo.Cliente;
import chexmoi.modelo.Direccion;
import chexmoi.modelo.Propiedad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VentanaVerDetallesControlador {

    @FXML
    private Button botonOperacion;

    @FXML
    private Button botonRegresar;

    @FXML
    private Label etiquetaAutos;

    @FXML
    private Label etiquetaCP;

    @FXML
    private Label etiquetaCalle;

    @FXML
    private Label etiquetaClaveCatastral;

    @FXML
    private Label etiquetaCocina;

    @FXML
    private Label etiquetaColonia;

    @FXML
    private Label etiquetaDimensiones;

    @FXML
    private Label etiquetaEstacionamiento;

    @FXML
    private Label etiquetaExterior;

    @FXML
    private Label etiquetaInterior;

    @FXML
    private Label etiquetaMuebles;

    @FXML
    private Label etiquetaNoAutos;

    @FXML
    private Label etiquetaNoHabitaciones;

    @FXML
    private Label etiquetaNoBanios;

    @FXML
    private Label etiquetaNombrePropiedad;

    @FXML
    private Label etiquetaOperación;

    @FXML
    private Label etiquetaPatio;

    @FXML
    private Label etiquetaPrecio;

    @FXML
    private Label etiquetaTerraza;

    @FXML
    private Label etiquetaWiFi;

    private Propiedad propiedad;
    private Direccion direccion;
    private Cliente cliente;

    @FXML
    private void initialize() {
        
    }

    public void setPropiedad(Propiedad propiedad, Direccion direccion) {
        this.propiedad = propiedad;
        this.direccion = direccion;
        cargarDatosOriginales();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @FXML
    public void regresar(ActionEvent event) {
        Stage stage = (Stage) botonRegresar.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void comprarAlquilarPropiedad(ActionEvent event) {

    }

    private void cargarDatosOriginales() {
        etiquetaClaveCatastral.setText(propiedad.getClaveCatastral());
        etiquetaNombrePropiedad.setText(propiedad.getNombre());
        DecimalFormat formatoDecimal = new DecimalFormat("#.##");
        String precioFormateado = formatoDecimal.format(propiedad.getPrecio());
        etiquetaPrecio.setText(precioFormateado);
        etiquetaNoHabitaciones.setText(String.valueOf(propiedad.getHabitaciones()));
        etiquetaNoBanios.setText(String.valueOf(propiedad.getBanios()));
        etiquetaDimensiones.setText(String.valueOf(propiedad.getDimensiones()));
        etiquetaNoAutos.setText(String.valueOf(propiedad.getNumeroAutos()));
        etiquetaOperación.setText(propiedad.getOperacion());
    
        etiquetaCalle.setText(direccion.getCalle());
        etiquetaColonia.setText(direccion.getColonia());
        etiquetaCP.setText(direccion.getCodigoPostal());
        etiquetaExterior.setText(String.valueOf(direccion.getNumeroExterior()));
    
        if (direccion.getNumeroInterior() == 0) {
            etiquetaInterior.setText("S/N");
        } else {
            etiquetaInterior.setText(String.valueOf(direccion.getNumeroInterior()));
        }
    
        etiquetaCocina.setText("Sí".equalsIgnoreCase(propiedad.getCocina()) ? "Sí" : "No");
        etiquetaEstacionamiento.setText("Sí".equalsIgnoreCase(propiedad.getEstacionamiento()) ? "Sí" : "No");
        etiquetaMuebles.setText("Sí".equalsIgnoreCase(propiedad.getMuebles()) ? "Sí" : "No");
        etiquetaWiFi.setText("Sí".equalsIgnoreCase(propiedad.getWifi()) ? "Sí" : "No");
        etiquetaPatio.setText("Sí".equalsIgnoreCase(propiedad.getPatio()) ? "Sí" : "No");
        etiquetaTerraza.setText("Sí".equalsIgnoreCase(propiedad.getTerraza()) ? "Sí" : "No");
    }
}
