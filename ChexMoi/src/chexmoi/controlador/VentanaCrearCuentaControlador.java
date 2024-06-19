package chexmoi.controlador;

import java.sql.SQLException;

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
    Validador validador;

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
    private TextField campoTextoTelefono;

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
    private Label etiquetaTelefono;

    @FXML
    private VBox etiquetasVBox;

    @FXML
    private Label nombreNoValido;

    @FXML
    private Label telefonoNoValido;

    @FXML
    private BorderPane ventanaCrearCuenta;

    @FXML
    private void initialize() {
        validador = new Validador();

        validador.limitarCampos(campoTextoNombre, 45);
        validador.limitarCampos(campoTextoApellidoPaterno, 20);
        validador.limitarCampos(campoTextoCorreoElectronico, 45);
        validador.limitarCampos(campoTextoClave, 255);
        validador.limitarCampos(campoTextoTelefono, 10);
    }

    public void handleBotonCancelar() {
        Stage escenario = (Stage) botonCancelar.getScene().getWindow();
        escenario.close();
    }

    public void handleBotonGuardar() {
        boolean nombreValido = validador.validarNombre(campoTextoNombre, nombreNoValido);
        boolean apellidoValido = validador.validarApellidoPaterno(campoTextoApellidoPaterno, apellidoNoValido);
        boolean correoValido = validador.validarCorreoElectronico(campoTextoCorreoElectronico, correoNoValido);
        boolean claveValida = validador.validarClave(campoTextoClave, claveNoValida);
        boolean telefonoValido = validador.validarTelefono(campoTextoTelefono, telefonoNoValido);

        if (nombreValido && apellidoValido && correoValido && claveValida && telefonoValido) {
            
            campoTextoCorreoElectronico.setText(campoTextoCorreoElectronico.getText().trim());
            campoTextoTelefono.setText(campoTextoTelefono.getText().trim());
            campoTextoApellidoPaterno.setText(campoTextoApellidoPaterno.getText().trim());
            campoTextoNombre.setText(campoTextoNombre.getText().trim());

            ClienteControlador clienteControlador = new ClienteControlador();
            Cliente cliente = new Cliente();

            cliente.setNombre(campoTextoNombre.getText());
            cliente.setApellidoPaterno(campoTextoApellidoPaterno.getText());
            cliente.setCorreoElectronico(campoTextoCorreoElectronico.getText());
            cliente.setClave(campoTextoClave.getText());
            cliente.setTelefono(campoTextoTelefono.getText());

            try {
                clienteControlador.registrarCliente(cliente);

                VentanaEmergente ventanaEmergente = new VentanaEmergente();

                ventanaEmergente.mostrarVentanaDeGuardadoExitoso("Cuenta creada", "Tu cuenta ha sido creda");
            
                Stage escenario = (Stage) botonGuardar.getScene().getWindow();
                escenario.close();
                
            } catch (SQLException sqlException) {
                excepcion(sqlException);
            }
        } 
    }

    private void excepcion(SQLException e) {
        if (e.getErrorCode() == 1062) {
            VentanaEmergente ventanaEmergente = new VentanaEmergente();

            ventanaEmergente.mostraVentanaYaRegistrado("Correo ya registrado", "Ese correo ya está asociado a otra cuenta");
            
        } else {
            VentanaEmergente ventanaEmergente = new VentanaEmergente();

            ventanaEmergente.mostrarVentanaNoSePuedoCrearCuenta();
        }
    }
}
