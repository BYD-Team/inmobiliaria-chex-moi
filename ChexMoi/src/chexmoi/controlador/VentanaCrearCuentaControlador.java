package chexmoi.controlador;

import java.sql.SQLException;
import java.util.regex.Pattern;

import chexmoi.modelo.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaCrearCuentaControlador {

    @FXML
    private Label apellidoNoValido;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonGuardar;

    @FXML
    private HBox botonesHBox;

    @FXML
    private TextField campoTextoApellidoPaterno;

    @FXML
    private TextField campoTextoClave;

    @FXML
    private TextField campoTextoCorreoElectronico;

    @FXML
    private TextField campoTextoNombre;

    @FXML
    private VBox camposTextoVBox;

    @FXML
    private Label claveNoValida;

    @FXML
    private Label correoNoValido;

    @FXML
    private Label etiquetaApellidoPaterno;

    @FXML
    private Label etiquetaClave;

    @FXML
    private Label etiquetaCorreoElectronico;

    @FXML
    private Label etiquetaNombre;

    @FXML
    private VBox etiquetasVBox;

    @FXML
    private Label nombreNoValido;

    @FXML
    private BorderPane ventanaCrearCuenta;

    public void handleBotonCancelar() {
        Stage escenario = (Stage) botonCancelar.getScene().getWindow();
        escenario.close();
    }

    public void handleBotonGuardar() {
        boolean nombreValido = validarNombre();
        boolean apellidoValido = validarApellidoPaterno();
        boolean correoValido = validarCorreoElectronico();
        boolean claveValida = validarClave();

        if (nombreValido && apellidoValido && correoValido && claveValida) {
            ClienteControlador clienteControlador = new ClienteControlador();
            Cliente cliente = new Cliente();

            cliente.setNombre(campoTextoNombre.getText());
            cliente.setApellidoPaterno(campoTextoApellidoPaterno.getText());
            cliente.setCorreoElectronico(campoTextoCorreoElectronico.getText());
            cliente.setClave(campoTextoClave.getText());

            try {
                clienteControlador.registrarCliente(cliente);

                VentanaEmergente ventanaEmergente = new VentanaEmergente();

                ventanaEmergente.mostrarVentanaDeGuardadoExitoso("Cuenta creada", "Tu cuenta ha sido creda");
            
            } catch (SQLException sqlException) {
                VentanaEmergente ventanaEmergente = new VentanaEmergente();

                ventanaEmergente.mostrarVentanaNoSePuedoCrearCuenta();
            }
        } 
    }

    public boolean validarNombre() {
        boolean esValido = true;

        campoTextoNombre.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        nombreNoValido.setVisible(false);

        if (campoTextoNombre.getText().isEmpty()) {
            campoTextoNombre.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff");
            nombreNoValido.setText("Campo Vacío");  
            nombreNoValido.setVisible(true);
            esValido = false;

        } else if (!validateSentence(campoTextoNombre.getText())) {
            campoTextoNombre.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff");
            nombreNoValido.setText("Datos inválidos");
            nombreNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarApellidoPaterno() {
        boolean esValido = true;

        campoTextoApellidoPaterno.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        apellidoNoValido.setVisible(false);

        if (campoTextoApellidoPaterno.getText().isEmpty()) {
            campoTextoApellidoPaterno.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            apellidoNoValido.setText("Campo Vacío");
            apellidoNoValido.setVisible(true);
            esValido = false;

        } else if (!validateSentence(campoTextoApellidoPaterno.getText())) {
            campoTextoApellidoPaterno.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            apellidoNoValido.setText("Datos inválidos");
            apellidoNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarCorreoElectronico() {
        boolean esValido = true;

        campoTextoCorreoElectronico.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        correoNoValido.setVisible(false);

        if (campoTextoCorreoElectronico.getText().isEmpty()) {
            campoTextoCorreoElectronico.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            correoNoValido.setText("Campo Vacío");
            correoNoValido.setVisible(true);
            esValido = false;

        } else if (!validateEmail(campoTextoCorreoElectronico.getText())) {
            campoTextoCorreoElectronico.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            correoNoValido.setText("Correo no válido");
            correoNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarClave() {
        boolean esValido = true;

        campoTextoClave.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        claveNoValida.setVisible(false);

        if (campoTextoClave.getText().isEmpty()) {
            campoTextoClave.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            claveNoValida.setText("Campo Vacío");
            claveNoValida.setVisible(true);
            esValido = false;

        } else if (!validateSentence(campoTextoClave.getText())) {
            campoTextoClave.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            claveNoValida.setText("Datos inválidos");
            claveNoValida.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    private boolean validateSentence(String sentence) {
        Pattern pattern = Pattern.compile("[ \\w&&[^_]]*$", Pattern.UNICODE_CHARACTER_CLASS);
        boolean isValid = pattern.matcher(sentence).matches();

        return isValid;
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[.a-zA-Z_0-9]+@[.a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$");
        boolean isValid = pattern.matcher(email).matches();

        return isValid;
    }
}
