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

    public void mostrarVentanaDeError(String title, String header, String mesagge) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(mesagge);
    }

    public void mostrarVentanaErrorConBaseDeDatos() {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error de Conexión con la base de datos");
        alert.setContentText("No se pudo conectar con la base de datos. Por favor, inténtelo más tarde.");
        alert.setHeaderText("Error de Conexión con la base de datos");
        alert.showAndWait();
    }
}
