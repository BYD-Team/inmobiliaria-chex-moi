package chexmoi.controlador;

import java.sql.SQLException;

import chexmoi.modelo.Cliente;
import chexmoi.modelo.Direccion;
import chexmoi.modelo.Propiedad;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class VentanaAgregarPropiedadControlador {

    Cliente cliente;

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
    private Label etiquetaNoAutos;

    @FXML
    private RadioButton wifiNo;

    @FXML
    private Label wifiNoValido;

    @FXML
    private RadioButton wifiSi;

    private Validador validador = new Validador();

    @FXML
    private void initialize() {
        limitarCampos();

        comboBoxOperacion.getItems().addAll("Venta", "Alquiler");

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

    private void limitarCampos() {
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
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @FXML
    private void guardarPropiedad() {
        Propiedad propiedad = new Propiedad();
        Direccion direccion = new Direccion();
        PropiedadControlador propiedadControlador = new PropiedadControlador();
        DireccionControlador direccionControlador = new DireccionControlador();
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

        if (esValido) {
            campoTextoClaveCastral.setText(campoTextoClaveCastral.getText().trim());
            campoTextoNombre.setText(campoTextoNombre.getText().trim());
            campoTextoPrecio.setText(campoTextoPrecio.getText().trim());
            campoTextoDimensiones.setText(campoTextoDimensiones.getText().trim());
            campoTextoHabitaciones.setText(campoTextoHabitaciones.getText().trim());
            campoTextoBanio.setText(campoTextoBanio.getText().trim());
            campoTextoCalle.setText(campoTextoCalle.getText().trim());
            campoTextoColonia.setText(campoTextoColonia.getText().trim());
            campoTextoCP.setText(campoTextoCP.getText().trim());
            campoTextoNoExterior.setText(campoTextoNoExterior.getText().trim());
            campoTextoNoInterior.setText(campoTextoNoInterior.getText().trim());

            direccion.setCalle(campoTextoCalle.getText());
            direccion.setNumeroExterior(Integer.parseInt(campoTextoNoExterior.getText()));

            if (!campoTextoNoInterior.getText().isEmpty()) {
                direccion.setNumeroInterior(Integer.parseInt(campoTextoNoInterior.getText()));
            }

            direccion.setColonia(campoTextoColonia.getText());
            direccion.setCodigoPostal(campoTextoCP.getText());

            propiedad.setClaveCatastral(campoTextoClaveCastral.getText());
            propiedad.setNombre(campoTextoNombre.getText());
            propiedad.setPrecio(Double.parseDouble(campoTextoPrecio.getText()));
            propiedad.setOperacion(comboBoxOperacion.getValue());
            propiedad.setDimensiones(campoTextoDimensiones.getText());
            propiedad.setHabitaciones(Integer.parseInt(campoTextoHabitaciones.getText()));
            propiedad.setBanios(Integer.parseInt(campoTextoBanio.getText()));
            propiedad.setWifi(obtenerValorRadioButton(WiFi));
            propiedad.setMuebles(obtenerValorRadioButton(Muebles));
            propiedad.setEstacionamiento(obtenerValorRadioButton(Estacionamiento));
            propiedad.setCocina(obtenerValorRadioButton(Cocina));
            propiedad.setTerraza(obtenerValorRadioButton(Terraza));
            propiedad.setPatio(obtenerValorRadioButton(Patio));

            if (!campoTextoNoAutos.isVisible()) {
                campoTextoNoAutos.setText("0");
            }

            propiedad.setNumeroAutos(Integer.parseInt(campoTextoNoAutos.getText()));

            try {
                int idDireccion = direccionControlador.agregarDireccion(direccion);
                direccion.setIdDireccion(idDireccion);
                propiedad.setDireccion(direccion);

                int resultadoPropiedad = propiedadControlador.agregarPropiedad(cliente, propiedad);
                if (resultadoPropiedad > 0) {
                    String claveCatastral = propiedad.getClaveCatastral();
                    propiedadControlador.agregarPropietario(claveCatastral, direccion.getIdDireccion(), cliente.getIdCliente());

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Propiedad agregada");
                    alert.setHeaderText("Propiedad agregada exitosamente");
                    alert.setContentText("La propiedad con clave catastral " + claveCatastral + " ha sido agregada exitosamente");
                    alert.showAndWait();

                    Stage stage = (Stage) botonGuardar.getScene().getWindow();
                    stage.close();
                }

            } catch (SQLException e) {
                excepcion(e);
            }
        }
    }

    private void excepcion(SQLException e) {
        if (e.getErrorCode() == 1062) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al agregar propiedad");
            alert.setHeaderText("Ocurrió un error al agregar la propiedad");
            alert.setContentText("La propiedad con la clave catastral ingresada ya existe");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al agregar propiedad");
            alert.setHeaderText("Ocurrió un error al agregar la propiedad");
            alert.setContentText("Ocurrió un error al agregar la propiedad, intente de nuevo");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelar() {
        botonCancelar.getScene().getWindow().hide();
    }

    public String obtenerValorRadioButton(ToggleGroup group) {
        if (group.getSelectedToggle() != null) {
            return ((RadioButton) group.getSelectedToggle()).getText();
        }
        return null;
    }
}
