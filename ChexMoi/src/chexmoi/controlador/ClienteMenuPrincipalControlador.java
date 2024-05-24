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
    private Cliente cliente;

    @FXML
    private BorderPane clienteMenuPrincipal;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @FXML
    private void abrirSeccionPropiedades(ActionEvent event) {
        try {
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
