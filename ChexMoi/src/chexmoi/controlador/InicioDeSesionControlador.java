package chexmoi.controlador;

import java.io.IOException;
import java.sql.SQLException;

import chexmoi.modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioDeSesionControlador {

    @FXML
    private Button crearCuentaButton;

    @FXML
    private Button invitadoButton;
    
    @FXML
    private TextField mailTextField;

    @FXML
    private Label mailLabel;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button iniciarSesionButton; 

    @FXML
    private void iniciarSesion(ActionEvent event) {
        Stage stage = (Stage) iniciarSesionButton.getScene().getWindow();
        Cliente cliente = obtenerCliente(mailTextField.getText(), passwordPasswordField.getText());
        
        if (cliente.getIdCliente() != 0) {
            abrirClienteMenuPrincipal(stage);

        } else if (mailTextField.getText().equals("inmobiliario@gmail.com")) {
            //abrirAgenteInmobiliarioMainMenu
        }

    }

    public Cliente obtenerCliente(String correo, String clave) {
        Cliente cliente = new Cliente();
        ClienteControlador clienteControlador = new ClienteControlador();

        try {
            cliente = clienteControlador.obtenerCliente(correo, clave);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return cliente;
    }

    private void abrirClienteMenuPrincipal(Stage stage) {
        try {
            Parent clienteMenuPrincipal = FXMLLoader.load(getClass().getResource("../vista/ClienteMenuPrincipal.fxml"));
            Scene scene = new Scene(clienteMenuPrincipal);

            stage.setScene(scene);
            stage.setTitle("Menú Principal");
            stage.show();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void abrirVentanaCrearCuenta() {
        try {
            Parent crearCuenta = FXMLLoader.load(getClass().getResource("../vista/VentanaCrearCuenta.fxml"));
            Scene scene = new Scene(crearCuenta);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menú Principal");
            stage.show();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
