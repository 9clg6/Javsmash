package utils;

import javafx.scene.control.Alert;
import model.Interface.Error;

public class CharacterSelectionPopAlert implements Error {
    Alert errorAlert;

    public CharacterSelectionPopAlert(String message) {
        errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("You can't chose the same character.");
        errorAlert.setHeaderText("Character Selection Error.");
        errorAlert.setContentText("The first player has taken :" + message);
    }

    @Override
    public void showError() {
        errorAlert.show();
    }
}
