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
    private String operacionStyle;

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

        setFieldsLimit();
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

    private void setFieldsLimit() {
        setLimitTextField(nombreTextField, 45);
        setLimitTextField(precioTextField, 32);
    }

    private void setLimitTextField(TextField textField, int maxLength) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.length() > maxLength) {
                textField.setText(newValue.substring(0, maxLength));
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
        setRegisteredFieldStyle(textField, label);
    }

    private void guardarPropiedad() {
        boolean esNombreValido = esFormatoDeNombreValido(nombreTextField, nombreLabel);
        boolean esPrecioValido = esFormatoDePrecioValido(precioTextField, precioLabel);
        operacionComboBox.setStyle(operacionStyle + " -fx-border-color: #777;");

        // try {

            if (esNombreValido && !propiedad.getNombre().equals(nombreTextField.getText())) {
                propiedadControlador.editarNombrePropiedad(propiedad.getIdPropiedad(), nombreTextField.getText());
                setRegisteredTextField(nombreTextField, nombreLabel);
                propiedad.setNombre(nombreTextField.getText());
            }

            if (esPrecioValido && propiedad.getPrecio() != Float.parseFloat(precioTextField.getText())) {
                propiedadControlador.editarPrecioPropiedad(propiedad.getIdPropiedad(), Float.parseFloat(precioTextField.getText()));
                setRegisteredTextField(precioTextField, precioLabel);
                propiedad.setPrecio(Float.parseFloat(precioTextField.getText()));
            }

            if (!propiedad.getOperacion().equals(operacionComboBox.getValue())) {
                propiedadControlador.editarOperacionPropiedad(propiedad.getIdPropiedad(), operacionComboBox.getValue());
                operacionComboBox.setStyle(operacionStyle + " -fx-border-color: #00FF00;");
                propiedad.setOperacion(operacionComboBox.getValue());

            } else {
                operacionComboBox.setStyle(operacionStyle + " -fx-border-color: #777;");
            }

        // } catch (SQLException sqlExcepcion) {
        //     sqlExcepcion.printStackTrace();
        // }
    }

    private boolean esFormatoDeNombreValido(TextField textField, Label label) {
        setDefaultFieldStyle(textField, label);
        boolean isValid = true;

        if (isFieldEmpty(textField, label)) {
            isValid = false;

        } else if (!isFieldLengthValid(textField, label, 45)) {
            isValid = false;

        } else if (!isSentenceFieldFormatValid(textField, label)) {
            isValid = false;
        }

        return isValid;
    }

    private boolean esFormatoDePrecioValido(TextField textField, Label label) {
        setDefaultFieldStyle(textField, label);
        boolean isValid = true;

        if (isFieldEmpty(textField, label)) {
            isValid = false;

        } else if (!isFieldLengthValid(textField, label, 32)) {
            isValid = false;

        } else if (!isNumberFieldFormatValid(textField, label)) {
            isValid = false;
        }

        return isValid;
    }

    private boolean isFieldEmpty(TextField textField, Label label) {
        boolean isEmpty = false;

        if (textField.getText().isEmpty()) {
            setEmptyFieldStyle(textField, label);
            isEmpty = true;
        }

        return isEmpty;
    }

    private boolean isFieldLengthValid(TextField textField, Label label, int length) {
        setTrimFormat(textField);
        boolean isValid = true;

        if (textField.getText().length() > length) {
            setLengthFieldStyle(textField, label, length);
            isValid = false;
        }

        return isValid;
    }

    private boolean isSentenceFieldFormatValid(TextField textField, Label label) {
        setTrimFormat(textField);
        boolean isValid = true;

        if (!isSentenceValid(textField.getText())) {
            setInvalidFieldStyle(textField, label);
            isValid = false;
        }

        return isValid;
    }

    private boolean isNumberFieldFormatValid(TextField textField, Label label) {
        setTrimFormat(textField);
        boolean isValid = true;

        if (!isNumberValid(textField.getText())) {
            setInvalidFieldStyle(textField, label);
            isValid = false;
        }

        return isValid;
    }

    private void setTrimFormat(TextField textField) {
        textField.setText(textField.getText().trim());
    }

    private void setDefaultFieldStyle(TextField textField, Label label) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #777; -fx-text-fill: #fff;");
        label.setText("");
    }

    private void setLengthFieldStyle(TextField textField, Label label, int length) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #FF0000; -fx-text-fill: #fff;");
        label.setStyle("-fx-text-fill: #FF0000;");
        label.setText("Deben ser " + length + " caracteres");
    }

    private void setEmptyFieldStyle(TextField textField, Label label) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #FF0000; -fx-text-fill: #fff;");
        label.setStyle("-fx-text-fill: #FF0000;");
        label.setText("Campo vacío");
    }

    private void setInvalidFieldStyle(TextField textField, Label label) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #FF0000; -fx-text-fill: #fff;");
        label.setStyle("-fx-text-fill: #FF0000;");
        label.setText("Campo inválido");
    }

    private void setRegisteredFieldStyle(TextField textField, Label label) {
        textField.setStyle("-fx-background-color: transparent; -fx-border-color: #00FF00; -fx-text-fill: #fff;");
        label.setStyle("-fx-text-fill: #00FF00;");
        label.setText("Campo registrado");
    }

    private boolean isNumberValid(String sentence) {
        Pattern pattern = Pattern.compile("[0-9.]*$");
        boolean isValid = pattern.matcher(sentence).matches();

        return isValid;
    }

    private boolean isSentenceValid(String sentence) {
        Pattern pattern = Pattern.compile("[ \\w&&[^_]]*$", Pattern.UNICODE_CHARACTER_CLASS);
        boolean isValid = pattern.matcher(sentence).matches();

        return isValid;
    }

}
