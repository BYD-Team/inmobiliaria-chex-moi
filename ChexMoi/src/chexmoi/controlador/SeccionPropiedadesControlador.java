package chexmoi.controlador;

import java.util.ArrayList;
import java.util.List;

import chexmoi.modelo.Cliente;
import chexmoi.modelo.Propiedad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SeccionPropiedadesControlador {
    PropiedadControlador propiedadControlador;
    private Cliente cliente;

    @FXML
    private ComboBox<String> preciosComboBox;

    @FXML
    private ComboBox<String> habitacionesComboBox;

    @FXML
    private CheckBox patioCheckBox;

    @FXML
    private VBox resultadoBusqueda;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @FXML
    private void buscarPropiedades(ActionEvent event) {

    }

    @FXML
    private void initialize() {
        propiedadControlador = new PropiedadControlador();
    }

    @FXML
    private void mostrarPropiedades() {
        resultadoBusqueda.getChildren().clear();

        List<Propiedad> propiedades = new ArrayList<Propiedad>();

        propiedades = propiedadControlador.obtenerPropiedades();

        if (propiedades.isEmpty()) {
            resultadoBusqueda.getChildren().add(crearEtiqueta("No se encontraron propiedades", 20));

        } else {
            propiedades.forEach(propiedad -> crearPropiedadElemento(propiedad));
        }
    }

    private void crearPropiedadElemento(Propiedad propiedad) {
        VBox propiedadElemento = new VBox();

        VBox.setVgrow(propiedadElemento, Priority.ALWAYS);

        VBox etiquetas = new VBox();

        etiquetas.getChildren().add(crearEtiqueta(propiedad.getNombre(), 20));
        etiquetas.getChildren().add(crearEtiqueta(propiedad.getDireccion().getColonia(), 16));

        HBox contenedor = new HBox();

        contenedor.getChildren().add(crearEtiqueta(propiedad.getDimensiones(), 14));
        contenedor.getChildren().add(crearSeparador());

        HBox botones = new HBox();

        botones.getChildren().add(crearBotonRentar(propiedad));
        botones.getChildren().add(crearBotonComprar(propiedad));

        contenedor.getChildren().add(botones);

        propiedadElemento.getChildren().add(etiquetas);
        propiedadElemento.getChildren().add(contenedor);
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

    private Button crearBotonRentar(Propiedad propiedad) {
        Button botonRentar = new Button("Rentar");

        botonRentar.setOnAction(event ->{
            System.out.println(cliente.getNombre() + "Rentar");
        });

        return botonRentar;
    }

    private Button crearBotonComprar(Propiedad propiedad) {
        Button botonComprar = new Button("Comprar");

        botonComprar.setOnAction(event -> {
            System.out.println(cliente.getNombre() + " Comprar");
        }); 

        return botonComprar;
    }
}

