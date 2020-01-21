package utils;

import javafx.scene.control.Alert;
import model.Interface.Error;

public class FileNullPopAlert implements Error {
    Alert errorAlert;

    public FileNullPopAlert(String message) {
        errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setTitle("None file selected");
        errorAlert.setHeaderText("File selection error");
        errorAlert.setContentText(message);
    }

    @Override
    public void showError() {

    }
}
