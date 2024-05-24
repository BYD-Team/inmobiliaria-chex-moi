package chexmoi.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chexmoi.modelo.Propiedad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SeccionPropiedadesDelAgenteInmobiliarioControlador {
    private PropiedadControlador propiedadControlador;

    @FXML
    private ComboBox<String> preciosComboBox;

    @FXML
    private ComboBox<String> habitacionesComboBox;

    @FXML
    private CheckBox patioCheckBox;

    @FXML
    private FlowPane resultadoBusqueda;

    @FXML
    private void buscarPropiedades(ActionEvent event) {

    }

    @FXML
    private void initialize() {
        propiedadControlador = new PropiedadControlador();
        mostrarPropiedades();
    }

    @FXML
    private void mostrarPropiedades() {
        resultadoBusqueda.getChildren().clear();

        try {
            List<Propiedad> propiedades = propiedadControlador.obtenerPropiedades();

            if (propiedades.isEmpty()) {
                resultadoBusqueda.getChildren().add(crearEtiqueta("No se encontraron propiedades", 20));
    
            } else {
                for (Propiedad propiedad : propiedades) {
                    resultadoBusqueda.getChildren().add(crearPropiedadElemento(propiedad));
                }
            }

        } catch (SQLException sqlException) {
            VentanaEmergente ventanaEmergente = new VentanaEmergente();

            String titulo = "Error con la base de datos";
            String encabezado = "Error al mostrar las propiedades";
            String mensaje = "No se pudo obtener el registro de propiedades. Por favor, inténtelo más tarde.";

            ventanaEmergente.mostrarVentanaDeError(titulo, encabezado, mensaje);
        }
    }

    private VBox crearPropiedadElemento(Propiedad propiedad) {
        VBox propiedadElemento = new VBox();

        VBox.setVgrow(propiedadElemento, Priority.ALWAYS);

        VBox etiquetas = new VBox();

        etiquetas.setSpacing(10);
        etiquetas.getChildren().add(crearEtiqueta(propiedad.getNombre(), 20));
        etiquetas.getChildren().add(crearEtiqueta(propiedad.getDireccion().getColonia(), 16));

        HBox contenedor = new HBox();

        contenedor.setSpacing(10);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.getChildren().add(crearEtiqueta(propiedad.getDimensiones(), 14));
        contenedor.getChildren().add(crearSeparador());
        contenedor.getChildren().add(crearBotonEditar(propiedad));

        propiedadElemento.setSpacing(10);
        propiedadElemento.setMinWidth(400);
        propiedadElemento.setPadding(new Insets(10));
        propiedadElemento.setStyle("-fx-border-color: #000;");
        propiedadElemento.getChildren().add(etiquetas);
        propiedadElemento.getChildren().add(contenedor);

        return propiedadElemento;
    }

    private Label crearEtiqueta(String etiqueta, int tamanoFuente) {
        Label etiquetaLabel = new Label(etiqueta);

        etiquetaLabel.setFont(new Font("Arial", tamanoFuente));

        return etiquetaLabel;
    }

    private HBox crearSeparador() {
        HBox separador = new HBox();

        HBox.setHgrow(separador, Priority.ALWAYS);

        return separador;
    }

    private Button crearBotonEditar(Propiedad propiedad) {
        Button botonRentar = new Button("Editar");

        botonRentar.setOnAction(event ->{
            abrirEditarPropiedad(propiedad);
        });

        return botonRentar;
    }

    private void abrirEditarPropiedad(Propiedad propiedad) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/VentanaEditarPropiedad.fxml"));
            Parent ventanaEditarPropiedad = loader.load();

            VentanaEditarPropiedadControlador controlador = loader.getController();
            controlador.setPropiedad(propiedad);

            Scene scene = new Scene(ventanaEditarPropiedad);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setTitle("Editar Propiedad");

            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(resultadoBusqueda.getScene().getWindow());
            stage.showAndWait();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
