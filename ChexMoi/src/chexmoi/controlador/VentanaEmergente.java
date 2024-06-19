package chexmoi.controlador;

import javafx.scene.control.Alert;

public class VentanaEmergente {
    
    public void mostrarVentanaDeGuardadoExitoso(String title, String mesagge) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setContentText(mesagge);
        alert.setHeaderText("Guardado Exitoso");
        alert.showAndWait();
    }

    public void mostrarVentanaDeActualizacionExitosa(String title, String mesagge) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setContentText(mesagge);
        alert.setHeaderText("Actualización Exitosa");
        alert.showAndWait();
    }

    public void mostrarVentanaDeError(String title, String header, String messagge) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(messagge);
        alert.showAndWait();
    }

    public void mostrarVentanaNoSePuedoCrearCuenta() {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("No fue posible crear la cuenta");
        alert.setContentText("La cuenta no puede ser creada en este momento. Por favor inténtelo más tarde");
        alert.setHeaderText("Cuenta no creada");
        alert.showAndWait();
    }

    public void mostraVentanaYaRegistrado(String encabezado, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
