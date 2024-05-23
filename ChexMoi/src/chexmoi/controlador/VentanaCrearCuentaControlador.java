package chexmoi.controlador;

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
    private BorderPane ventanaCrearCuenta;

    public void handleBotonCancelar() {
        Stage escenario = (Stage) botonCancelar.getScene().getWindow();
        escenario.close();
    }

    public void handleBotonGuardar() {
        ClienteControlador clienteControlador = new ClienteControlador();
        Cliente cliente = new Cliente();

        cliente.setNombre(campoTextoNombre.getText());
        cliente.setApellidoPaterno(campoTextoApellidoPaterno.getText());
        cliente.setCorreoElectronico(campoTextoCorreoElectronico.getText());
        cliente.setClave(campoTextoClave.getText());

        clienteControlador.registrarCliente(cliente);
    }
}
