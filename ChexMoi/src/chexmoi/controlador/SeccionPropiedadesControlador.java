package chexmoi.controlador;

// import modelo.Cliente;

public class SeccionPropiedadesControlador {
    // PropiedadControlador propiedadControlador;
    // private Cliente cliente;

    // @FXML
    // private ComboBox<String> preciosComboBox;

    // @FXML
    // private ComboBox<String> habitacionesComboBox;

    // @FXML
    // private CheckBox patioCheckBox;

    // @FXML
    // private HBox preciosComboBox;

    // @FXML
    // private VBox resultadoBusqueda;

    // @FXML
    // private VBox resultadoBusqueda;

    // public void setCliente(Cliente cliente) {
    //     this.cliente = cliente;
    // }

    // @FXML
    // private void buscarPropiedades(ActionEvent event) {

    // }

    // @FXML
    // private void initialize() {
    //     propiedadControlador = new PropiedadControlador();
    // }

    // @
    // private void mostrarPropiedades() {
    //     resultadoBusqueda.getChildren().clear();
    //     List<Propiedad> propiedades = new ArrayList<>();

    //     try {
    //         propiedades = propiedadControlador.obtenerPropiedades();

    //     } catch (DBException dbExcepcion) {
    //         dbExcepcion.printStackTrace();
    //     }

    //     if (propiedades.isEmpty()) {
    //         resultadoBusqueda.getChildren().add(crearEtiqueta("No se encontraron propiedades", 20));

    //     } else {
    //         propiedades.forEach(propiedad -> crearPropiedadElemento(propiedad));
    //     }
    // }

    // private void crearPropiedadElemento(Propiedad propiedad) {
    //     VBox propiedadElemento = new VBox();

    //     VBox.setVgrow(propiedadElemento, Priority.ALWAYS);

    //     VBox etiquetas = new VBox();

    //     etiquetas.getChildren().add(crearEtiqueta(propiedad.getNombre(), 20));
    //     etiquetas.getChildren().add(crearEtiqueta(propiedad.getColonia(), 16));

    //     HBox contenedor = new HBox();

    //     contenedor.getChildren().add(crearEtiqueta(propiedad.getDireccion().getDimensiones(), 14));
    //     contenedor.getChildren().add(crearSeparador());

    //     HBox botones = new HBox();

    //     botones.getChildren().add(crearBotonRentar(propiedad));
    //     botones.getChildren().add(crearBotonComprar(propiedad));

    //     contenedor.getChildren().add(botones);

    //     propiedadElemento.getChildren().add(etiquetas);
    //     propiedadElemento.getChildren().add(contenedor);
    // }

    // private Label crearEtiqueta(Stirng etiqueta, int tamanoFuente) {
    //     Label etiquetaLabel = new Label(etiqueta);

    //     etiquetaLabel.setFont(new Font("Arial", tamanoFuente));

    //     return etiquetaLabel;
    // }

    // private HBox crearSeparador() {
    //     HBox separador = new HBox();

    //     HBox.setHgrow(separador, Priority.ALWAYS);

    //     return separador;
    // }

    // private Button crearBotonRentar(Propiedad propiedad) {
    //     Button botonRentar = new Button("Rentar");

    //     botonRentar.setOnAction(event ->
    //         System.out.println("Rentar");
    //     );

    //     return botonRentar;
    // }

    // private Button crearBotonComprar(Propiedad propiedad) {
    //     Button botonComprar = new Button("Comprar");

    //     botonComprar.setOnAction(event ->
    //         System.out.println("Comprar");
    //     );

    //     return botonComprar;
    // }
}

