package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button PlayButton;
    @FXML
    private Button ExitButton;

    public MenuController() {
    }

    @FXML
    private void handlePlayButton(ActionEvent e) {
        e.consume();
        try {
            start();
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    @FXML
    public void handleExitButton(ActionEvent e) {
        e.consume();
        exit();
    }

    private void exit() {
        try {
            System.exit(0);
        } catch (Exception exc) {
            System.err.println("Error in exit");
        }
    }

    @FXML
    public void initialize() {
        this.PlayButton = new Button();
        this.PlayButton.setOnAction(this::handlePlayButton);
        this.ExitButton = new Button();
        this.ExitButton.setOnAction(this::handleExitButton);
    }


    private void start() throws Exception {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        Pane root = FXMLLoader.load(this.getClass().getResource("/fxml/HeroSelection.fxml"));
        Scene selectionScene = new Scene(root, 1500, 600.0D);

        primaryStage.setScene(selectionScene);
        primaryStage.show();
    }
}
