package chexmoi.controlador;

import java.sql.SQLException;
import java.util.regex.Pattern;

import chexmoi.modelo.Propiedad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaEditarPropiedadControlador {
    private PropiedadControlador propiedadControlador;
    private Propiedad propiedad;
    private String operacionEstilo;

    @FXML
    private BorderPane ventanaEditarPropiedad;

    @FXML
    private Label nombreLabel;

    @FXML
    private TextField nombreTextField;

    @FXML
    private Label precioLabel;

    @FXML
    private TextField precioTextField;

    @FXML
    private ComboBox<String> operacionComboBox;

    @FXML
    private Button guardarButton;

    @FXML
    private Button cancelarButton;

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;

        setInitialFields();
        setOperacionComboBox();
    }

    @FXML
    private void initialize() {
        propiedadControlador = new PropiedadControlador();
        operacionEstilo = operacionComboBox.getStyle();

        establecerLimitDeCampos();
    }

    @FXML
    private void cerrarVentanaEditarPropiedad(ActionEvent event) {
        Stage escenario = (Stage) cancelarButton.getScene().getWindow();
        escenario.close();
    }

    @FXML
    private void guardarCambiosDePropiedad(ActionEvent event) {
        guardarPropiedad();
    }

    private void establecerLimitDeCampos() {
        establecerLimiteDeCampo(nombreTextField, 45);
        establecerLimiteDeCampo(precioTextField, 32);
    }

    private void establecerLimiteDeCampo(TextField textField, int maxLength) {
        textField.textProperty().addListener((observador, viejoValor, nuevoValor) -> {
            if (nuevoValor != null && nuevoValor.length() > maxLength) {
                textField.setText(nuevoValor.substring(0, maxLength));
            }
        });
    }

    private void setInitialFields() {
        setTextField(nombreTextField, propiedad.getNombre());
        setTextField(precioTextField, String.valueOf(propiedad.getPrecio()));
    }

    private void setOperacionComboBox() {
        operacionComboBox.getItems().addAll("venta", "alquiler");
        operacionComboBox.setValue(propiedad.getOperacion());
    }

    private void setTextField(TextField textField, String text) {
        textField.setPromptText(text);
        textField.setText(text);
    }

    private void setRegisteredTextField(TextField textField, Label label) {
        setTextField(textField, textField.getText());
        establecerEstiloDeCampoRegistrado(textField, label);
    }

    private void guardarPropiedad() {
        operacionComboBox.setStyle(operacionEstilo);
        boolean hayCambios = false;

        boolean esNombreValido = esFormatoDeNombreValido(nombreTextField, nombreLabel);
        boolean esPrecioValido = esFormatoDePrecioValido(precioTextField, precioLabel);

        try {

            if (esNombreValido && !propiedad.getNombre().equals(nombreTextField.getText())) {
                propiedadControlador.editarNombrePropiedad(propiedad.getIdPropiedad(), nombreTextField.getText());
                setRegisteredTextField(nombreTextField, nombreLabel);
                propiedad.setNombre(nombreTextField.getText());
                hayCambios = true;
            }

            if (esPrecioValido && propiedad.getPrecio() != Float.parseFloat(precioTextField.getText())) {
                propiedadControlador.editarPrecioPropiedad(propiedad.getIdPropiedad(), Float.parseFloat(precioTextField.getText()));
                setRegisteredTextField(precioTextField, precioLabel);
                propiedad.setPrecio(Float.parseFloat(precioTextField.getText()));
                hayCambios = true;
            }

            if (!propiedad.getOperacion().equals(operacionComboBox.getValue())) {
                propiedadControlador.editarOperacionPropiedad(propiedad.getIdPropiedad(), operacionComboBox.getValue());
                operacionComboBox.setStyle("-fx-background-color: transparent; -fx-border-color: #00FF00;");
                propiedad.setOperacion(operacionComboBox.getValue());
                hayCambios = true;
            }

            if (hayCambios) {
                VentanaEmergente ventanaEmergente = new VentanaEmergente();

                String titulo = "Propiedad Actualizada";
                String mensaje = "La propiedad ha sido actualizada exitosamente";

                ventanaEmergente.mostrarVentanaDeActualizacionExitosa(titulo, mensaje);
            }

        } catch (SQLException sqlExcepcion) {
            VentanaEmergente ventanaEmergente = new VentanaEmergente();

            String titulo = "Error con la base de datos";
            String encabezado = "Error al actualizar la propiedad";
            String mensaje = "No se pudo actualizar la propiedad. Por favor, inténtelo más tarde.";

            ventanaEmergente.mostrarVentanaDeError(titulo, encabezado, mensaje);
        }
    }

    private boolean esFormatoDeNombreValido(TextField textField, Label label) {
        establecerEstiloDeCampoPorDefecto(textField, label);
        boolean esValido = true;

        if (esCampoVacio(textField, label)) {
            esValido = false;

        } else if (!esLongitudDeCampoValido(textField, label, 45)) {
            esValido = false;

        } else if (!esFormatoDeSentenciaCampoValido(textField, label)) {
            esValido = false;
        }

        return esValido;
    }

    private boolean esFormatoDePrecioValido(TextField textField, Label label) {
        establecerEstiloDeCampoPorDefecto(textField, label);
        boolean esValido = true;

        if (esCampoVacio(textField, label)) {
            esValido = false;

        } else if (!esLongitudDeCampoValido(textField, label, 32)) {
            esValido = false;

        } else if (!esFormatoDeNumeroCampoValido(textField, label)) {
            esValido = false;
        }

        return esValido;
    }

    private boolean esCampoVacio(TextField textField, Label label) {
        boolean esVacio = false;

        if (textField.getText().isEmpty()) {
            establecerEstiloDeCampoVacio(textField, label);
            esVacio = true;
        }

        return esVacio;
    }

    private boolean esLongitudDeCampoValido(TextField textField, Label label, int longitud) {
        limpiarEspacios(textField);
        boolean esValido = true;

        if (textField.getText().length() > longitud) {
            establecerEstiloDeCampoDeLongitud(textField, label, longitud);
            esValido = false;
        }

        return esValido;
    }

    private boolean esFormatoDeSentenciaCampoValido(TextField textField, Label label) {
        limpiarEspacios(textField);
        boolean esValido = true;

        if (!esSentenciaValida(textField.getText())) {
            establecerEstiloDeCampoInvalido(textField, label);
            esValido = false;
        }

        return esValido;
    }

    private boolean esFormatoDeNumeroCampoValido(TextField textField, Label label) {
        limpiarEspacios(textField);
        boolean esValido = true;

        if (!esNumeroValido(textField.getText())) {
            establecerEstiloDeCampoInvalido(textField, label);
            esValido = false;
        }

        return esValido;
    }

    private void limpiarEspacios(TextField textField) {
        textField.setText(textField.getText().trim());
    }

    private void establecerEstiloDeCampoPorDefecto(TextField textField, Label label) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #777; -fx-text-fill: #fff;");
        label.setText("");
    }

    private void establecerEstiloDeCampoDeLongitud(TextField textField, Label label, int length) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #FF0000; -fx-text-fill: #fff;");
        label.setStyle("-fx-text-fill: #FF0000;");
        label.setText("Deben ser " + length + " caracteres");
    }

    private void establecerEstiloDeCampoVacio(TextField textField, Label label) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #FF0000; -fx-text-fill: #fff;");
        label.setStyle("-fx-text-fill: #FF0000;");
        label.setText("Campo vacío");
    }

    private void establecerEstiloDeCampoInvalido(TextField textField, Label label) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #FF0000; -fx-text-fill: #fff;");
        label.setStyle("-fx-text-fill: #FF0000;");
        label.setText("Campo inválido");
    }

    private void establecerEstiloDeCampoRegistrado(TextField textField, Label label) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #00FF00; -fx-text-fill: #fff;");
        label.setStyle("-fx-text-fill: #00FF00;");
        label.setText("Campo registrado");
    }

    private boolean esNumeroValido(String sentencia) {
        Pattern pattern = Pattern.compile("[0-9.]*$");
        boolean esValido = pattern.matcher(sentencia).matches();

        return esValido;
    }

    private boolean esSentenciaValida(String sentencia) {
        Pattern pattern = Pattern.compile("[ \\w&&[^_]]*$", Pattern.UNICODE_CHARACTER_CLASS);
        boolean esValido = pattern.matcher(sentencia).matches();

        return esValido;
    }

}
