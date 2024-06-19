package chexmoi.controlador;

import java.io.IOException;

import chexmoi.modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class ClienteMenuPrincipalControlador {
    private Cliente cliente;
    private ContextMenu contextMenu;

    @FXML
    private BorderPane clienteMenuPrincipal;
    
    @FXML
    private ImageView imagenPerfil;


    @FXML
    private void initialize() {
        abrirSeccionPropiedades(null);
        
        contextMenu = new ContextMenu();
        
        MenuItem cerrarSesionItem = new MenuItem("Cerrar sesión");
        cerrarSesionItem.setOnAction(this::cerrarSesion);
        
        MenuItem verPerfilItem = new MenuItem("Ver perfil");
        verPerfilItem.setOnAction(this::abrirSeccionPerfil);

        contextMenu.getItems().addAll(verPerfilItem, cerrarSesionItem);
        
        if (imagenPerfil != null) {
            imagenPerfil.setOnMousePressed(event -> {
                if (event.isPrimaryButtonDown()) {
                    contextMenu.show(imagenPerfil, event.getScreenX(), event.getScreenY());
                }
            });
        }
    }

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
    private void abrirSeccionMisPropiedades(ActionEvent event) {
        try {
            FXMLLoader parent = new FXMLLoader(getClass().getResource("../vista/SeccionMisPropiedades.fxml"));
            Parent root = parent.load();

            SeccionMisPropiedadesControlador seccionMisPropiedadesControlador = parent.getController();
            seccionMisPropiedadesControlador.setCliente(cliente);

            clienteMenuPrincipal.setCenter(root);

        } catch (IOException ioExcepcion) {
            ioExcepcion.printStackTrace();
        }
    }

    @FXML
    private void abrirSeccionMensajes(ActionEvent event) {
        // Implementar abrirSeccionMensajes
    }

    @FXML
    private void abrirSeccionFavoritos(ActionEvent event) {
        // Implementar abrirSeccionFavoritos
    }

    @FXML
    private void abrirSeccionPerfil(ActionEvent event) {
        try {
            FXMLLoader parent = new FXMLLoader(getClass().getResource("../vista/SeccionPerfil.fxml"));
            Parent root = parent.load();

            SeccionPerfilControlador seccionPerfilControlador = parent.getController();
            seccionPerfilControlador.setCliente(cliente);

            clienteMenuPrincipal.setCenter(root);

        } catch (IOException ioExcepcion) {
            ioExcepcion.printStackTrace();
        }
    }
 
    @FXML
    private void abrirSeccionPerfil(MouseEvent event) {
        abrirSeccionPerfil((ActionEvent) null);
    }

    private void cerrarSesion(ActionEvent event) {
        Stage stage = (Stage) clienteMenuPrincipal.getScene().getWindow();
        
        stage.close();

        abrirInicioDeSesionPrincipal();
    }

    private void abrirInicioDeSesionPrincipal() {
        try {
            FXMLLoader inicioSesion = new FXMLLoader(getClass().getResource("../vista/InicioDeSesion.fxml"));
            Parent inicioDeSesionParent = inicioSesion.load();

            Scene scene = new Scene(inicioDeSesionParent);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setTitle("Inicio de sesión");
            stage.show();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
