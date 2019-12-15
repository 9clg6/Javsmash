package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button PlayButton;
    @FXML
    private Button ExitButton;

    /**
     * Entry point for this project.
     *
     * @author Clément GUYON
     * This event is call by the button 'Play' in the main menu and call the function 'startPlaying'
     */
    @FXML
    private void handlePlayButton(ActionEvent e) {
        e.consume();
        try {
            startPlaying();
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    /**
     * @author Clément GUYON
     * This event is call by the button 'Exit' in the main menu and call the function 'exit'
     */
    @FXML
    public void handleExitButton(ActionEvent e) {
        e.consume();
        exit();
    }

    /**
     * @author Clément GUYON
     * This event is consumed by the button 'Exit'. Permitt user to leave properly the application
     */
    private void exit() {
        try {
            System.exit(0);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /**
     * @throws IOException throwable by loader.load()
     *                     This function is call by the button 'Play'. It creates new window for the HeroSelection
     * @author Clément GUYON
     */
    private void startPlaying() throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/HeroSelection.fxml"));

        loader.setController(new HeroSelectionController());

        Pane root = loader.load();

        Scene selectionScene = new Scene(root, 1500, 600.0D);

        primaryStage.setScene(selectionScene);
        primaryStage.show();
    }
}
