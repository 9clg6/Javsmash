import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private GridPane GridPaneFather;
    @FXML
    private Button PlayButton;

    @FXML
    private void handlePlayButton(ActionEvent event) {
        try {
            GameController windowPlay = new GameController();
            try {
                windowPlay.start(new Stage());
            } catch (Exception e) {
                System.out.println("Erreur instanciation fenêtre Jeu");
            }
        } catch (Exception e) {
            System.out.println("Erreur à l'ouverture du jeu");
        }
    }

    @FXML
    public void initialize() {
        PlayButton = new Button();
        GridPaneFather = new GridPane();
        PlayButton.setOnAction(this::handlePlayButton);
    }


}
