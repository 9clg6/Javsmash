import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class MenuController {
    @FXML
    private GridPane GridPaneFather;
    @FXML
    private Button PlayButton;

    @FXML
    private void handlePlayButton(ActionEvent e) {
        e.consume();
        GameController gc = new GameController();
        try {
            gc.event();
        } catch (java.lang.Exception j) {
            System.err.println("java Lang Exception");
        }
    }

    @FXML
    public void initialize() {
        PlayButton = new Button();
        GridPaneFather = new GridPane();
        PlayButton.setOnAction(this::handlePlayButton);
    }


}
