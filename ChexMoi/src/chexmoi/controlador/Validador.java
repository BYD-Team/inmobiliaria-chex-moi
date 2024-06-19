package chexmoi.controlador;

import java.util.regex.Pattern;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Validador {

    public boolean validarNombre(TextField campoTextoNombre, Label nombreNoValido) {
        boolean esValido = true;
        String texto = campoTextoNombre.getText().trim();

        campoTextoNombre.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        nombreNoValido.setVisible(false);

        if (texto.isEmpty()) {
            campoTextoNombre.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff");
            nombreNoValido.setText("Campo Vacío");  
            nombreNoValido.setVisible(true);
            esValido = false;

        } else if (!validarFormatoNombre(texto)) {
            campoTextoNombre.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff");
            nombreNoValido.setText("Datos inválidos");
            nombreNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarApellidoPaterno(TextField campoTextoApellidoPaterno, Label apellidoNoValido) {
        boolean esValido = true;
        String texto = campoTextoApellidoPaterno.getText().trim();

        campoTextoApellidoPaterno.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        apellidoNoValido.setVisible(false);

        if (texto.isEmpty()) {
            campoTextoApellidoPaterno.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            apellidoNoValido.setText("Campo Vacío");
            apellidoNoValido.setVisible(true);
            esValido = false;

        } else if (!validarFormatoNombre(texto)) {
            campoTextoApellidoPaterno.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            apellidoNoValido.setText("Datos inválidos");
            apellidoNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarCorreoElectronico(TextField campoTextoCorreoElectronico, Label correoNoValido) {
        boolean esValido = true;
        String texto = campoTextoCorreoElectronico.getText().trim();

        campoTextoCorreoElectronico.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        correoNoValido.setVisible(false);

        if (texto.isEmpty()) {
            campoTextoCorreoElectronico.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            correoNoValido.setText("Campo Vacío");
            correoNoValido.setVisible(true);
            esValido = false;

        } else if (!validarFormatoCorreo(texto)) {
            campoTextoCorreoElectronico.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            correoNoValido.setText("Correo no válido");
            correoNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarClave(TextField campoTextoClave, Label claveNoValida) {
        boolean esValido = true;

        campoTextoClave.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        claveNoValida.setVisible(false);

        if (campoTextoClave.getText().isEmpty()) {
            campoTextoClave.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            claveNoValida.setText("Campo Vacío");
            claveNoValida.setVisible(true);
            esValido = false;

        } else if (!validarFormatoClave(campoTextoClave.getText())) {
            campoTextoClave.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            claveNoValida.setText("Datos inválidos");
            claveNoValida.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarTelefono(TextField campoTextoTelefono, Label telefonoNoValido) {
        boolean esValido = true;
        String texto = campoTextoTelefono.getText().trim();

        campoTextoTelefono.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        telefonoNoValido.setVisible(false);

        if (texto.isEmpty()) {
            campoTextoTelefono.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            telefonoNoValido.setText("Campo Vacío");
            telefonoNoValido.setVisible(true);
            esValido = false;

        } else if (!validarFormatoTelefono(texto)) {
            campoTextoTelefono.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            telefonoNoValido.setText("Número no válido");
            telefonoNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarPrecio(TextField campoTextoPrecio, Label precioNoValido) {
        boolean esValido = true;
        String texto = campoTextoPrecio.getText().trim();

        campoTextoPrecio.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        precioNoValido.setVisible(false);

        if (texto.isEmpty()) {
            campoTextoPrecio.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            precioNoValido.setText("Campo Vacío");
            precioNoValido.setVisible(true);
            esValido = false;
        } else {
            try {
                double precio = Double.parseDouble(texto);
                if (!validarFormatoPrecio(precio)) {
                    campoTextoPrecio.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
                    precioNoValido.setText("Precio no válido");
                    precioNoValido.setVisible(true);
                    esValido = false;
                }
            } catch (NumberFormatException e) {
                campoTextoPrecio.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
                precioNoValido.setText("Formato no válido");
                precioNoValido.setVisible(true);
                esValido = false;
            }
        }

        return esValido;
    }

    public boolean validarTexto(TextField campoTexto, Label labelNoValido) {
        boolean esValido = true;
        String texto = campoTexto.getText().trim();

        campoTexto.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        labelNoValido.setVisible(false);

        if (texto.isEmpty()) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Campo vacío");
            labelNoValido.setVisible(true);
            esValido = false;
        } else if (!validarFormatoNombre(texto)) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Campo inválido");
            labelNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarColonia(TextField campoTexto, Label labelNoValido) {
        boolean esValido = true;
        String texto = campoTexto.getText().trim();
    
        campoTexto.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        labelNoValido.setVisible(false);
    
        if (texto.isEmpty()) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Campo vacío");
            labelNoValido.setVisible(true);
            esValido = false;
        } else if (!validarFormatoColonia(texto)) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Campo inválido");
            labelNoValido.setVisible(true);
            esValido = false;
        }
    
        return esValido;
    }

    public boolean validarCalle(TextField campoTexto, Label labelNoValido) {
        boolean esValido = true;
        String texto = campoTexto.getText().trim();
    
        campoTexto.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        labelNoValido.setVisible(false);
    
        if (texto.isEmpty()) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Campo vacío");
            labelNoValido.setVisible(true);
            esValido = false;
        } else if (!validarFormatoCalle(texto)) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Campo inválido");
            labelNoValido.setVisible(true);
            esValido = false;
        }
    
        return esValido;
    }

    public boolean validarRadioButton(ToggleGroup toggleGroup, Label labelNoValido, String campoNombre) {
        boolean esValido = true;

        labelNoValido.setVisible(false);

        if (toggleGroup.getSelectedToggle() == null) {
            labelNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarOperacion(ComboBox<String> comboBox, Label operacionNoValida) {
        boolean esValido = true;

        comboBox.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        operacionNoValida.setVisible(false);

        if (comboBox.getValue() == null) {
            comboBox.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            operacionNoValida.setText("Operación no seleccionada");
            operacionNoValida.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarNumerico(TextField campoTexto, Label labelNoValido) {
        boolean esValido = true;
        String texto = campoTexto.getText().trim();

        campoTexto.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        labelNoValido.setVisible(false);

        if (texto.isEmpty()) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Campo vacío");
            labelNoValido.setVisible(true);
            esValido = false;
            
        } else if (!validarFormatoNumerico(texto)) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Datos inválidos");
            labelNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    public boolean validarNumeroInterno(TextField campoTexto, Label labelNoValido) {
        boolean esValido = true;
        String texto = campoTexto.getText().trim();
    
        campoTexto.setStyle("-fx-border-color: #777; -fx-background-color: transparent; -fx-text-fill: #fff;");
        labelNoValido.setVisible(false);
    
        if (!texto.isEmpty() && !validarFormatoNumerico(texto)) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Datos inválidos");
            labelNoValido.setVisible(true);
            esValido = false;
        }
    
        return esValido;
    }    

    public boolean validarClaveCatastral(TextField campoTexto, Label labelNoValido) {
        boolean esValido = true;
        String texto = campoTexto.getText().trim();

        if (texto.isEmpty()) {
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Datos inválidos");
            labelNoValido.setVisible(true);
        
        } else if (!validarFormatoClaveCatastral(texto)){
            campoTexto.setStyle("-fx-border-color: red; -fx-background-color: transparent; -fx-text-fill: #fff;");
            labelNoValido.setText("Datos inválidos");
            labelNoValido.setVisible(true);
            esValido = false;
        }

        return esValido;
    }

    private boolean validarFormatoCalle(String texto) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\s,.'\\-áéíóúÁÉÍÓÚüÜ#]+$");
        return pattern.matcher(texto).matches();
    }    

    public boolean validarDimensiones(TextField campoTextoDimensiones, Label dimensionesNoValido) {
        return validarNumerico(campoTextoDimensiones, dimensionesNoValido);
    }

    private boolean validarFormatoPrecio(Double precio) {
        if (precio < 0) {
            return false;
        }
    
        String precioString = String.format("%.2f", precio);
        Pattern pattern = Pattern.compile("^\\d+(\\.\\d{1,2})?$");
        return pattern.matcher(precioString).matches();
    }
    

    private boolean validarFormatoColonia(String texto) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\s,.'\\-áéíóúÁÉÍÓÚüÜ#]+$");
        return pattern.matcher(texto).matches();
    }

    private boolean validarFormatoNombre(String texto) {
        Pattern pattern = Pattern.compile("^[\\p{L}]+(?:\\s+[\\p{L}]+)*$", Pattern.UNICODE_CHARACTER_CLASS);
        return pattern.matcher(texto).matches();
    }
    
    private boolean validarFormatoClave(String sentence) {
        Pattern pattern = Pattern.compile("^[\\p{L}0-9 \\-!@#$%^&*()_+\\[\\]{}|;:',.<>/?]*$", Pattern.UNICODE_CHARACTER_CLASS);
        boolean esValido = pattern.matcher(sentence).matches();
    
        return esValido;
    }    

    private boolean validarFormatoCorreo(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        return pattern.matcher(email).matches();
    }    

    private boolean validarFormatoTelefono(String sentence) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        return pattern.matcher(sentence).matches();
    }    

    public void limitarCampos(TextField campoTexto, int limite) {
        campoTexto.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > limite) {
                campoTexto.setText(oldValue);
            }
        });
    }

    private boolean validarFormatoNumerico(String texto) {
        Pattern pattern = Pattern.compile("^\\d+$");
        return pattern.matcher(texto).matches();
    }

    private boolean validarFormatoClaveCatastral(String texto) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{20}$");
        return pattern.matcher(texto).matches();
    }

    public void limitarCamposNumericos(TextField campoTexto) {
        campoTexto.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                campoTexto.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}
