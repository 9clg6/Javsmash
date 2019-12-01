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
    private Button ExitButton;

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
    private void handleExitButton(ActionEvent e) {
        e.consume();
        try {
            System.exit(0);
        } catch (Exception exc) {
            System.err.println("Error in exit");
        }
    }

    @FXML
    public void initialize() {
        this.PlayButton = new Button();
        this.GridPaneFather = new GridPane();
        this.PlayButton.setOnAction(this::handlePlayButton);
        this.ExitButton = new Button();
        this.ExitButton.setOnAction(this::handleExitButton);
    }
}
