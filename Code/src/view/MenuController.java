import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
            HeroSelectionController CharacterSelection = new HeroSelectionController();
            CharacterSelection.event();
        } catch (Exception var3) {
            System.err.println(var3.getMessage());
        }
    }

    @FXML
    public void handleExitButton(ActionEvent e) {
        e.consume();
        exit();
    }

    private void exit(){
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
}
