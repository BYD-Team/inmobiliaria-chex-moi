package chexmoi.controlador;

import java.sql.SQLException;

import chexmoi.modelo.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SeccionPerfilControlador {
    Cliente cliente;
    private String correoOriginal;
    private String telefonoOriginal;
    private String apellidoOriginal;
    private String nombreOriginal;
    private Validador validador;

    @FXML
    private TextField campoTextoApellido;

    @FXML
    private TextField campoTextoCorreo;

    @FXML
    private TextField campoTextoNombre;

    @FXML
    private TextField campoTextoTelefono;

    @FXML
    private Button cancelButton;

    @FXML
    private Button editButton;

    @FXML
    private Label etiquetaApellidoNoValido;

    @FXML
    private Label etiquetaCorreoNoValido;

    @FXML
    private Label etiquetaNombreCompleto;

    @FXML
    private Label etiquetaNombreNoValido;

    @FXML
    private Label etiquetaTelefonoNoValido;

    @FXML
    private Button saveButton;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        cargarInformacion();
    }

    private String nombreCompleto() {
        String nombre = cliente.getNombre();
        String apellido = cliente.getApellidoPaterno();
        return nombre + " " + apellido;
    }

    public void cargarInformacion() {
        etiquetaNombreCompleto.setText(nombreCompleto());
        campoTextoCorreo.setText(cliente.getCorreoElectronico());
        campoTextoTelefono.setText(cliente.getTelefono());
        campoTextoApellido.setText(cliente.getApellidoPaterno());
        campoTextoNombre.setText(cliente.getNombre());

        correoOriginal = cliente.getCorreoElectronico();
        telefonoOriginal = cliente.getTelefono();
        apellidoOriginal = cliente.getApellidoPaterno();
        nombreOriginal = cliente.getNombre();
    }

    @FXML
    private void initialize() {
        validador = new Validador();

        campoTextoCorreo.setEditable(false);
        campoTextoTelefono.setEditable(false);
        campoTextoApellido.setEditable(false);
        campoTextoNombre.setEditable(false);

        saveButton.setVisible(false);
        cancelButton.setVisible(false);

        validador.limitarCampos(campoTextoNombre, 45);
        validador.limitarCampos(campoTextoApellido, 20);
        validador.limitarCampos(campoTextoCorreo, 45);
        validador.limitarCampos(campoTextoTelefono, 10);
    }

    @FXML
    private void editarPerfil() {
        campoTextoCorreo.setEditable(true);
        campoTextoTelefono.setEditable(true);
        campoTextoApellido.setEditable(true);
        campoTextoNombre.setEditable(true);

        saveButton.setVisible(true);
        cancelButton.setVisible(true);
        editButton.setVisible(false);
    }

    @FXML
    private void guardarEdicion() {
        ClienteControlador clienteControlador = new ClienteControlador();

        boolean nombreValido = validador.validarNombre(campoTextoNombre, etiquetaNombreNoValido);
        boolean apellidoValido = validador.validarApellidoPaterno(campoTextoApellido, etiquetaApellidoNoValido);
        boolean correoValido = validador.validarCorreoElectronico(campoTextoCorreo, etiquetaCorreoNoValido);
        boolean telefonoValido = validador.validarTelefono(campoTextoTelefono, etiquetaTelefonoNoValido);

        if (nombreValido && apellidoValido && correoValido && telefonoValido) {
            try {
                boolean actualizacionExitosa = false;

                campoTextoCorreo.setText(campoTextoCorreo.getText().trim());
                campoTextoTelefono.setText(campoTextoTelefono.getText().trim());
                campoTextoApellido.setText(campoTextoApellido.getText().trim());
                campoTextoNombre.setText(campoTextoNombre.getText().trim());

                if (!cliente.getCorreoElectronico().equals(campoTextoCorreo.getText())) {
                    cliente.setCorreoElectronico(campoTextoCorreo.getText().trim());
                    actualizacionExitosa = clienteControlador.actualizarCorreo(cliente) > 0;
                    correoOriginal = campoTextoCorreo.getText();
                }

                if (!cliente.getTelefono().equals(campoTextoTelefono.getText())) {
                    cliente.setTelefono(campoTextoTelefono.getText());
                    actualizacionExitosa = clienteControlador.actualizarTelefono(cliente) > 0;
                    telefonoOriginal = campoTextoTelefono.getText();
                }

                if (!cliente.getApellidoPaterno().equals(campoTextoApellido.getText())) {
                    cliente.setApellidoPaterno(campoTextoApellido.getText().trim());
                    actualizacionExitosa = clienteControlador.actualizarApellidoPaterno(cliente) > 0;
                    apellidoOriginal = campoTextoApellido.getText();
                    etiquetaNombreCompleto.setText(nombreCompleto());
                }

                if (!cliente.getNombre().equals(campoTextoNombre.getText())) {
                    cliente.setNombre(campoTextoNombre.getText().trim());
                    actualizacionExitosa = clienteControlador.actualizarNombre(cliente) > 0;
                    nombreOriginal = campoTextoNombre.getText();
                    etiquetaNombreCompleto.setText(nombreCompleto());
                }


                if (actualizacionExitosa) {
                    esActualizacionExitosa();
                }

            } catch (SQLException sqlException) {
                VentanaEmergente ventanaEmergente = new VentanaEmergente();
                ventanaEmergente.mostrarVentanaDeError("Error al actualizar", "Error al actualizar", "Hubo un error para actualizar el perfil, intente de nuevo más tarde.");
            }
        }
    }

    private void esActualizacionExitosa() {
        VentanaEmergente ventanaEmergente = new VentanaEmergente();
        ventanaEmergente.mostrarVentanaDeGuardadoExitoso("Perfil actualizado", "Tu perfil ha sido actualizado exitosamente");

        campoTextoCorreo.setEditable(false);
        campoTextoTelefono.setEditable(false);
        campoTextoApellido.setEditable(false);
        campoTextoNombre.setEditable(false);

        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        editButton.setVisible(true);
    }

    @FXML
    private void cancelarEdicion() {
        campoTextoCorreo.setText(correoOriginal);
        campoTextoTelefono.setText(telefonoOriginal);
        campoTextoApellido.setText(apellidoOriginal);
        campoTextoNombre.setText(nombreOriginal);

        campoTextoCorreo.setEditable(false);
        campoTextoTelefono.setEditable(false);
        campoTextoApellido.setEditable(false);
        campoTextoNombre.setEditable(false);
        
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        editButton.setVisible(true);
    }
}
