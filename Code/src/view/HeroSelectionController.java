import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HeroSelectionController {
    @FXML
    private Button Clement;
    @FXML
    private Button Maxime;
    private GameController gc = new GameController();


    public HeroSelectionController() {
        Initialize();
    }

    @FXML
    private void CharacterSelectionated(ActionEvent e) {
        System.out.println("Character Selectionated");
    }

    @FXML
    public void Initialize(){
        this.Clement    =new Button();
        this.Maxime     =new Button();
    }

    private void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(this.getClass().getResource("/fxml/HeroSelection.fxml"));
        Scene selectionScene = new Scene(root, 1500, 600.0D);

        root.getChildren().addAll(Clement,Maxime);
        primaryStage.setScene(selectionScene);
        primaryStage.show();
    }

    protected void event() throws Exception {
        this.start(new Stage());
    }
}
