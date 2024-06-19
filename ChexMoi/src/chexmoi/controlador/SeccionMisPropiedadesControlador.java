package chexmoi.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chexmoi.modelo.Cliente;
import chexmoi.modelo.Propiedad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SeccionMisPropiedadesControlador {

    private Cliente cliente;
    private PropiedadControlador propiedadControlador;

    @FXML
    private Button botonAgregarPropiedad;

    @FXML
    private FlowPane resultadoBusqueda;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        mostrarPropiedades();
    }

    @FXML
    private void initialize() {
        propiedadControlador = new PropiedadControlador();
    }

    @FXML
    private void abrirVentanaVerDetallesMisPropiedades(Propiedad propiedad) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/VentanaVerDetallesMisPropiedades.fxml"));
            Parent root = loader.load();

            VentanaVerDetallesMisPropiedadesControlador controlador = loader.getController();
            controlador.setPropiedad(propiedad, propiedad.getDireccion());

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Detalles de mis propiedades");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException ioExcepcion) {
            ioExcepcion.printStackTrace();
        }
    }

    
    @FXML
    private void abrirVentanaAgregarPropiedad(ActionEvent event) {
        try {
            FXMLLoader parent = new FXMLLoader(getClass().getResource("../vista/VentanaAgregarPropiedad.fxml"));
            Parent root = parent.load();

            VentanaAgregarPropiedadControlador controlador = parent.getController();
            controlador.setCliente(cliente);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Agregar Propiedad");
            stage.setScene(new Scene(root));

            stage.setOnHiding(evt -> mostrarPropiedades());

            stage.show();

        } catch (IOException ioExcepcion) {
            ioExcepcion.printStackTrace();
        }
    }


    @FXML
    public void mostrarPropiedades() {
        resultadoBusqueda.getChildren().clear();

        if (cliente == null) {
            resultadoBusqueda.getChildren().add(crearEtiqueta("No se ha especificado un cliente", 20));
            return;
        }

        List<Propiedad> propiedades = new ArrayList<>();

        try {
            propiedades = propiedadControlador.obtenerMisPropiedades(cliente);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            resultadoBusqueda.getChildren().add(crearEtiqueta("Error al obtener propiedades", 20));
            return;
        }

        if (propiedades.isEmpty()) {
            resultadoBusqueda.getChildren().add(crearEtiqueta("No se encontraron propiedades", 20));
        } else {
            for (Propiedad propiedad : propiedades) {
                resultadoBusqueda.getChildren().add(crearPropiedadElemento(propiedad));
            }
        }
    }

    private Label crearEtiqueta(String texto, int tamanoFuente) {
        Label etiqueta = new Label(texto);
        etiqueta.setFont(new Font("Arial", tamanoFuente));
        etiqueta.setStyle("-fx-text-fill: #fff;");
        return etiqueta;
    }

    private VBox crearPropiedadElemento(Propiedad propiedad) {
        VBox propiedadElemento = new VBox();
        propiedadElemento.setSpacing(10);
        propiedadElemento.setMinWidth(400);
        propiedadElemento.setPadding(new Insets(10));
        propiedadElemento.setStyle("-fx-border-color: #777;");

        VBox etiquetas = new VBox();
        etiquetas.setSpacing(10);
        etiquetas.getChildren().add(crearEtiqueta(propiedad.getNombre(), 20));
        etiquetas.getChildren().add(crearEtiqueta(propiedad.getDireccion().getColonia(), 16));

        HBox contenedor = new HBox();
        contenedor.setSpacing(10);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.getChildren().add(crearEtiqueta(propiedad.getDimensiones(), 14));
        contenedor.getChildren().add(crearSeparador());

        HBox botones = new HBox();
        botones.setSpacing(10);
        botones.getChildren().add(crearBotonVerDetalles(propiedad));

        contenedor.getChildren().add(botones);

        propiedadElemento.getChildren().addAll(etiquetas, contenedor);
        return propiedadElemento;
    }

    private HBox crearSeparador() {
        HBox separador = new HBox();
        HBox.setHgrow(separador, Priority.ALWAYS);
        return separador;
    }

    private Button crearBotonVerDetalles(Propiedad propiedad) {
        Button botonVerDetalles = new Button("Ver detalles");
        botonVerDetalles.setStyle("-fx-background-color: transparent; -fx-border-radius: 3px; -fx-border-color: #fff; -fx-text-fill: #fff;");
        botonVerDetalles.setOnAction(event -> {
            abrirVentanaVerDetallesMisPropiedades(propiedad);
        });
        return botonVerDetalles;
    }
}
