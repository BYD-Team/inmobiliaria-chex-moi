package chexmoi.controlador;

import java.sql.SQLException;
import java.text.DecimalFormat;

import chexmoi.modelo.Direccion;
import chexmoi.modelo.Propiedad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class VentanaVerDetallesMisPropiedadesControlador {

    @FXML
    private ToggleGroup Cocina;

    @FXML
    private ToggleGroup Estacionamiento;

    @FXML
    private ToggleGroup Muebles;

    @FXML
    private ToggleGroup Patio;

    @FXML
    private ToggleGroup Terraza;

    @FXML
    private ToggleGroup WiFi;

    @FXML
    private Label banioNoValido;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonGuardar;

    @FXML
    private Label calleNoValida;

    @FXML
    private TextField campoTextoBanio;

    @FXML
    private TextField campoTextoCP;

    @FXML
    private TextField campoTextoCalle;

    @FXML
    private TextField campoTextoClaveCastral;

    @FXML
    private TextField campoTextoColonia;

    @FXML
    private TextField campoTextoDimensiones;

    @FXML
    private TextField campoTextoHabitaciones;

    @FXML
    private TextField campoTextoNoAutos;

    @FXML
    private TextField campoTextoNoExterior;

    @FXML
    private TextField campoTextoNoInterior;

    @FXML
    private TextField campoTextoNombre;

    @FXML
    private TextField campoTextoPrecio;

    @FXML
    private Label cocinaCampoObligatorio;

    @FXML
    private RadioButton cocinaNo;

    @FXML
    private RadioButton cocinaSi;

    @FXML
    private Label coloniaNoValida;

    @FXML
    private ComboBox<String> comboBoxOperacion;

    @FXML
    private Label cpNoValido;

    @FXML
    private Label dimensionesNoValido;

    @FXML
    private Label estacionamientoCampoObligatorio;

    @FXML
    private RadioButton estacionamientoNo;

    @FXML
    private RadioButton estacionamientoSi;

    @FXML
    private Label etiquetaClaveCastralNoValida;

    @FXML
    private Label etiquetaNoAutos;

    @FXML
    private Label etiquetaNombreNoValido;

    @FXML
    private Label etiquetaPrecioNoValido;

    @FXML
    private Label habitacionesNoValida;

    @FXML
    private Label mueblesCampoObligatorio;

    @FXML
    private RadioButton mueblesNo;

    @FXML
    private RadioButton mueblesSi;

    @FXML
    private Label noAutosNoValido;

    @FXML
    private Label noExteriorNoValido;

    @FXML
    private Label noInteriorNoValido;

    @FXML
    private Label operacionNoValida;

    @FXML
    private Label patioNoValido;

    @FXML
    private Label terrazaCampoObligatorio;

    @FXML
    private RadioButton terrazaNo;

    @FXML
    private RadioButton terrazaSi;

    @FXML
    private RadioButton wifiNo;

    @FXML
    private RadioButton patioNo;

    @FXML
    private RadioButton patioSi;

    @FXML
    private Label wifiNoValido;

    @FXML
    private RadioButton wifiSi;

    @FXML
    private Button botonEditar;

    private Propiedad propiedad;
    private Direccion direccion;
    private Validador validador;

    public void setPropiedad(Propiedad propiedad, Direccion direccion) {
        this.propiedad = propiedad;
        this.direccion = direccion;
        cargarDatosOriginales();
    }

    @FXML
    private void initialize() {
        validador = new Validador();
        comboBoxOperacion.getItems().addAll("Venta", "Alquiler");

        validador.limitarCampos(campoTextoNoAutos, 3);
        validador.limitarCampos(campoTextoColonia, 45);
        validador.limitarCampos(campoTextoNoInterior, 4);
        validador.limitarCampos(campoTextoHabitaciones, 3);
        validador.limitarCampos(campoTextoDimensiones, 8);
        validador.limitarCampos(campoTextoNoExterior, 4);
        validador.limitarCampos(campoTextoCalle, 45);
        validador.limitarCampos(campoTextoCP, 5);
        validador.limitarCampos(campoTextoBanio, 3);
        validador.limitarCampos(campoTextoPrecio, 10);
        validador.limitarCampos(campoTextoNombre, 45);
        validador.limitarCampos(campoTextoClaveCastral, 20);

        Estacionamiento.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (estacionamientoSi.isSelected()) {
                campoTextoNoAutos.setVisible(true);
                etiquetaNoAutos.setVisible(true);
            } else if (estacionamientoNo.isSelected()){
                campoTextoNoAutos.setVisible(false);
                etiquetaNoAutos.setVisible(false);
                noAutosNoValido.setVisible(false);
            }
        });
    }

    private void cargarDatosOriginales() {
        campoTextoClaveCastral.setText(propiedad.getClaveCatastral());
        campoTextoNombre.setText(propiedad.getNombre());
        DecimalFormat formatoDecimal = new DecimalFormat("#.##");
        String precioFormateado = formatoDecimal.format(propiedad.getPrecio());
        campoTextoPrecio.setText(precioFormateado);
        campoTextoHabitaciones.setText(String.valueOf(propiedad.getHabitaciones()));
        campoTextoBanio.setText(String.valueOf(propiedad.getBanios()));
        campoTextoDimensiones.setText(String.valueOf(propiedad.getDimensiones()));
        campoTextoNoAutos.setText(String.valueOf(propiedad.getNumeroAutos()));
    
        switch (propiedad.getOperacion()) {
            case "Venta":
                comboBoxOperacion.getSelectionModel().select(0);
                break;
            case "Alquiler":
                comboBoxOperacion.getSelectionModel().select(1);
                break;
        }
    
        campoTextoCalle.setText(direccion.getCalle());
        campoTextoColonia.setText(direccion.getColonia());
        campoTextoCP.setText(direccion.getCodigoPostal());
        campoTextoNoExterior.setText(String.valueOf(direccion.getNumeroExterior()));
    
        if (direccion.getNumeroInterior() == 0) {
            campoTextoNoInterior.setText("");
        } else {
            campoTextoNoInterior.setText(String.valueOf(direccion.getNumeroInterior()));
        }
    
        setRadioButtonValue(patioSi, patioNo, propiedad.getPatio());
        setRadioButtonValue(wifiSi, wifiNo, propiedad.getWifi());
        setRadioButtonValue(cocinaSi, cocinaNo, propiedad.getCocina());
        setRadioButtonValue(terrazaSi, terrazaNo, propiedad.getTerraza());
        setRadioButtonValue(mueblesSi, mueblesNo, propiedad.getMuebles());
        setRadioButtonValue(estacionamientoSi, estacionamientoNo, propiedad.getEstacionamiento());
    }
    
    private void setRadioButtonValue(RadioButton si, RadioButton no, String value) {
        if (value != null && value.equalsIgnoreCase("sí")) {
            si.setSelected(true);
        } else {
            no.setSelected(true);
        }
    }    
    
    private String getRadioButtonValue(RadioButton si, RadioButton no) {
        return si.isSelected() ? "Sí" : "No";
    }

    @FXML
    private void guardarPropiedad(ActionEvent event) {
        if (validarCampos()) {
            propiedad.setClaveCatastral(campoTextoClaveCastral.getText());
            propiedad.setNombre(campoTextoNombre.getText());
            propiedad.setPrecio(Double.parseDouble(campoTextoPrecio.getText()));
            propiedad.setHabitaciones(Integer.parseInt(campoTextoHabitaciones.getText()));
            propiedad.setBanios(Integer.parseInt(campoTextoBanio.getText()));
            propiedad.setDimensiones(campoTextoDimensiones.getText());
            propiedad.setNumeroAutos(Integer.parseInt(campoTextoNoAutos.getText()));
            propiedad.setOperacion(comboBoxOperacion.getSelectionModel().getSelectedItem());

            direccion.setCalle(campoTextoCalle.getText());
            direccion.setColonia(campoTextoColonia.getText());
            direccion.setCodigoPostal(campoTextoCP.getText());
            direccion.setNumeroExterior(Integer.parseInt(campoTextoNoExterior.getText()));
            if (!campoTextoNoInterior.getText().isEmpty()) {
                direccion.setNumeroInterior(Integer.parseInt(campoTextoNoInterior.getText()));
            } else {
                direccion.setNumeroInterior(0);
            }
            propiedad.setDireccion(direccion);
            propiedad.setPatio(getRadioButtonValue(patioSi, patioNo));
            propiedad.setWifi(getRadioButtonValue(wifiSi, wifiNo));
            propiedad.setCocina(getRadioButtonValue(cocinaSi, cocinaNo));
            propiedad.setTerraza(getRadioButtonValue(terrazaSi, terrazaNo));
            propiedad.setMuebles(getRadioButtonValue(mueblesSi, mueblesNo));
            propiedad.setEstacionamiento(getRadioButtonValue(estacionamientoSi, estacionamientoNo));

            PropiedadControlador propiedadControlador = new PropiedadControlador();
            DireccionControlador direccionControlador = new DireccionControlador();

            try {
                direccionControlador.editarDireccion(direccion);
                propiedadControlador.editarPropiedad(propiedad);

                hacerCamposNoEditables();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText("Propiedad guardada con éxito");
                alert.showAndWait();

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error al editar la propiedad");
                alert.setContentText("Ocurrió un error al editar la propiedad. Inténtelo de nuevo.");
                alert.showAndWait();

                cargarDatosOriginales();
            }
        }
    }

    private boolean validarCampos() {
        Validador validador = new Validador();

        boolean esValido = true;

        esValido &= validador.validarClaveCatastral(campoTextoClaveCastral, etiquetaClaveCastralNoValida);
        esValido &= validador.validarNombre(campoTextoNombre, etiquetaNombreNoValido);
        esValido &= validador.validarPrecio(campoTextoPrecio, etiquetaPrecioNoValido);
        esValido &= validador.validarOperacion(comboBoxOperacion, operacionNoValida);
        esValido &= validador.validarDimensiones(campoTextoDimensiones, dimensionesNoValido);
        esValido &= validador.validarNumerico(campoTextoHabitaciones, habitacionesNoValida);
        esValido &= validador.validarCalle(campoTextoCalle, calleNoValida);
        esValido &= validador.validarColonia(campoTextoColonia, coloniaNoValida);
        esValido &= validador.validarNumerico(campoTextoCP, cpNoValido);
        esValido &= validador.validarNumerico(campoTextoNoExterior, noExteriorNoValido);
        esValido &= validador.validarNumeroInterno(campoTextoNoInterior, noInteriorNoValido);
        esValido &= validador.validarNumerico(campoTextoBanio, banioNoValido);
        esValido &= validador.validarRadioButton(WiFi, wifiNoValido, "WiFi");
        esValido &= validador.validarRadioButton(Muebles, mueblesCampoObligatorio, "Muebles");
        esValido &= validador.validarRadioButton(Estacionamiento, estacionamientoCampoObligatorio, "Estacionamiento");
        esValido &= validador.validarRadioButton(Cocina, cocinaCampoObligatorio, "Cocina");
        esValido &= validador.validarRadioButton(Terraza, terrazaCampoObligatorio, "Terraza");
        esValido &= validador.validarRadioButton(Patio, patioNoValido, "Patio");

        if (estacionamientoSi.isSelected()) {
            esValido &= validador.validarNumerico(campoTextoNoAutos, noAutosNoValido);
        }

        return esValido;
    }
    
    @FXML
    public void editarPropiedad() {
        campoTextoClaveCastral.setEditable(true);
        campoTextoNombre.setEditable(true);
        campoTextoPrecio.setEditable(true);
        campoTextoHabitaciones.setEditable(true);
        campoTextoBanio.setEditable(true);
        campoTextoDimensiones.setEditable(true);
        campoTextoNoAutos.setEditable(true);
        comboBoxOperacion.setDisable(false);
        campoTextoCalle.setEditable(true);
        campoTextoColonia.setEditable(true);
        campoTextoCP.setEditable(true);
        campoTextoNoExterior.setEditable(true);
        campoTextoNoInterior.setEditable(true);
        patioSi.setDisable(false);
        patioNo.setDisable(false);
        wifiSi.setDisable(false);
        wifiNo.setDisable(false);
        cocinaSi.setDisable(false);
        cocinaNo.setDisable(false);
        terrazaSi.setDisable(false);
        terrazaNo.setDisable(false);
        mueblesSi.setDisable(false);
        mueblesNo.setDisable(false);
        estacionamientoSi.setDisable(false);
        estacionamientoNo.setDisable(false);

        botonEditar.setVisible(false);
        botonGuardar.setVisible(true);
        botonCancelar.setVisible(true);
    }

    private void hacerCamposNoEditables() {
        campoTextoClaveCastral.setEditable(false);
        campoTextoNombre.setEditable(false);
        campoTextoPrecio.setEditable(false);
        campoTextoHabitaciones.setEditable(false);
        campoTextoBanio.setEditable(false);
        campoTextoDimensiones.setEditable(false);
        campoTextoNoAutos.setEditable(false);
        comboBoxOperacion.setDisable(true);
        campoTextoCalle.setEditable(false);
        campoTextoColonia.setEditable(false);
        campoTextoCP.setEditable(false);
        campoTextoNoExterior.setEditable(false);
        campoTextoNoInterior.setEditable(false);
        patioSi.setDisable(true);
        patioNo.setDisable(true);
        wifiSi.setDisable(true);
        wifiNo.setDisable(true);
        cocinaSi.setDisable(true);
        cocinaNo.setDisable(true);
        terrazaSi.setDisable(true);
        terrazaNo.setDisable(true);
        mueblesSi.setDisable(true);
        mueblesNo.setDisable(true);
        estacionamientoSi.setDisable(true);
        estacionamientoNo.setDisable(true);

        botonEditar.setVisible(true);
        botonGuardar.setVisible(false);
        botonCancelar.setVisible(false);
    }

    public void cancelarEdicion() {
        hacerCamposNoEditables();
        cargarDatosOriginales();
    }
}
