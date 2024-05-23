package chexmoi.controlador;

import java.io.IOException;

import chexmoi.modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ClienteMenuPrincipalControlador {
    private static String mail;
    private static Cliente cliente;

    @FXML
    private BorderPane clienteMenuPrincipal;

    public static void setCliente(String mail) {
        ClienteMenuPrincipalControlador.mail = mail;
    }

    public static Cliente getCliente() {
        if (cliente == null) {
            ClienteControlador clienteControlador = new ClienteControlador();

            // cliente = clienteControlador.obtenerCliente(mail);
        }

        return cliente;
    }

    @FXML
    private void abrirSeccionPropiedades(ActionEvent event) {
        try {
            Cliente cliente = getCliente();

            FXMLLoader parent = new FXMLLoader(getClass().getResource("../vista/SeccionPropiedades.fxml"));
            Parent root = parent.load();

            SeccionPropiedadesControlador seccionPropiedadesControlador = parent.getController();
            seccionPropiedadesControlador.setCliente(cliente);

            clienteMenuPrincipal.setCenter(root);

        } catch (IOException ioExcepcion) {
            ioExcepcion.printStackTrace();
        }
    }

    @FXML
    private void abrirSeccionMensajes(ActionEvent event) {

    }

    @FXML
    private void abrirSeccionFavoritos(ActionEvent event) {

    }

    @FXML
    private void abrirSeccionPerfil(MouseEvent event) {

    }

}
