package chexmoi.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chexmoi.modelo.Cliente;
import chexmoi.modelo.Propiedad;
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

public class SeccionPropiedadesControlador {
    PropiedadControlador propiedadControlador;
    Cliente cliente;

    @FXML
    private ComboBox<String> preciosComboBox;

    @FXML
    private ComboBox<String> habitacionesComboBox;

    @FXML
    private CheckBox cocinaCheckBox;

    @FXML
    private CheckBox estacionamientoCheckBox;

    @FXML
    private CheckBox mueblesCheckBox;

    @FXML
    private CheckBox terrazaCheckBox;

    @FXML
    private CheckBox wifiCheckBox;

    @FXML
    private CheckBox patioCheckBox;

    @FXML
    private FlowPane resultadoBusqueda;

    @FXML
    private Button botonBuscar;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @FXML
    private void buscarPropiedades() {
        botonBuscar.setOnAction(event -> {
            resultadoBusqueda.getChildren().clear();

            List<Propiedad> propiedades = new ArrayList<Propiedad>();
    
            propiedades = propiedadControlador.obtenerPropiedadesConFiltros(obtenerFiltros());

            if (propiedades.isEmpty()) {
                resultadoBusqueda.getChildren().add(crearEtiqueta("No se encontraron propiedades", 20));
    
            } else {
                for (Propiedad propiedad : propiedades) {
                    resultadoBusqueda.getChildren().add(crearPropiedadElemento(propiedad));
                }
            }

        });
    }

    @FXML
    private void initialize() {
        propiedadControlador = new PropiedadControlador();
        mostrarPropiedades();
        llenarPreciosComboBox();
        llenarHabitacionesComboBox();
    }

    @FXML
    private void mostrarPropiedades() {
        resultadoBusqueda.getChildren().clear();

        List<Propiedad> propiedades = new ArrayList<Propiedad>();

        try {
            propiedades = propiedadControlador.obtenerPropiedades();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        if (propiedades.isEmpty()) {
            resultadoBusqueda.getChildren().add(crearEtiqueta("No se encontraron propiedades", 20));

        } else {
            for (Propiedad propiedad : propiedades) {
                resultadoBusqueda.getChildren().add(crearPropiedadElemento(propiedad));
            }
        }
    }

    private void llenarPreciosComboBox() {
        preciosComboBox.getItems().addAll("50000", "100000", "150000", "1000000");
    }

    private void llenarHabitacionesComboBox() {
        for (int i = 1; i <= 12; i++) {
            habitacionesComboBox.getItems().add(String.valueOf(i));
        }
    }

    private String[] obtenerFiltros() {
        String[] filtros = new String[8];

        filtros[0] = preciosComboBox.getValue();
        filtros[1] = habitacionesComboBox.getValue();
        filtros[2] = patioCheckBox.isSelected() ? "Sí" : "No";
        filtros[3] = cocinaCheckBox.isSelected() ? "Sí" : "No";
        filtros[4] = estacionamientoCheckBox.isSelected() ? "Sí" : "No";
        filtros[5] = mueblesCheckBox.isSelected() ? "Sí" : "No";
        filtros[6] = terrazaCheckBox.isSelected() ? "Sí" : "No";
        filtros[7] = wifiCheckBox.isSelected() ? "Sí" : "No";

        return filtros;
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

        propiedadElemento.getChildren().add(etiquetas);
        propiedadElemento.getChildren().add(contenedor);

        return propiedadElemento;
    }


    private Label crearEtiqueta(String etiqueta, int tamanoFuente) {
        Label etiquetaLabel = new Label(etiqueta);
        etiquetaLabel.setFont(new Font("Arial", tamanoFuente));
        etiquetaLabel.setStyle("-fx-text-fill: #fff");
        return etiquetaLabel;
    }

    private HBox crearSeparador() {
        HBox separador = new HBox();
        HBox.setHgrow(separador, Priority.ALWAYS);
        return separador;
    }

    private Button crearBotonVerDetalles(Propiedad propiedad) {
        Button botonVerDetalles = new Button("Ver Detalles");
        botonVerDetalles.setStyle("-fx-background-color: transparent; -fx-border-radius: 3px; -fx-border-color: #fff; -fx-text-fill: #fff");
        botonVerDetalles.setOnAction(event -> abrirVentanaVerDetalles(propiedad));
        return botonVerDetalles;
    }

    @FXML
    private void abrirVentanaVerDetalles(Propiedad propiedad) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/VentanaVerDetalles.fxml"));
            Parent root = loader.load();

            VentanaVerDetallesControlador controlador = loader.getController();
            controlador.setPropiedad(propiedad, propiedad.getDireccion());
            controlador.setCliente(cliente);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Detalles de la propiedad");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException ioExcepcion) {
            ioExcepcion.printStackTrace();
        }
    }
}

