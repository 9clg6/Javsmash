import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MenuController {
    @FXML
    private GridPane GridPaneFather;
    @FXML
    private Button PlayButton;

    public MenuController() {
    }

    @FXML
    private void handlePlayButton(ActionEvent e) {
        e.consume();

        try {
            GameController gc = new GameController();
            gc.event();
        } catch (Exception var3) {
            System.err.println("java Lang Exception");
        }

    }

    @FXML
    public void initialize() {
        this.PlayButton = new Button();
        this.GridPaneFather = new GridPane();
        this.PlayButton.setOnAction(this::handlePlayButton);
    }
}
