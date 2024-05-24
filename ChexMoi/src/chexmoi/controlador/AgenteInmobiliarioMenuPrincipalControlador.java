package chexmoi.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AgenteInmobiliarioMenuPrincipalControlador {

    @FXML
    private BorderPane agenteInmobiliarioMenuPrincipal;

    @FXML
    private void abrirSeccionPropiedades(ActionEvent event) {
        try {
            Parent seccionPropiedadesDelAgenteInmobiliario = FXMLLoader.load(getClass().getResource("../vista/SeccionPropiedadesDelAgenteInmobiliario.fxml"));
            agenteInmobiliarioMenuPrincipal.setCenter(seccionPropiedadesDelAgenteInmobiliario);

        } catch (IOException ioExcepcion) {
            ioExcepcion.printStackTrace();
        }
    }

    @FXML
    private void abrirSeccionDocumentos(ActionEvent event) {

    }

    @FXML
    private void abrirSeccionPerfil(MouseEvent event) {

    }

}
