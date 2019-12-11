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
    @FXML
    private Button TestButton;
    private int countClick = 0;
    private boolean isFirstCharacterSelected = false, isSecondCharacterSelected = false;
    private boolean finalState;
    private GameController gc = new GameController();
    private Object firstCharacterSelected, secondCharacterSelected;

    public HeroSelectionController() {

        Initialize();
    }

    @FXML
    private void CharacterSelected(ActionEvent e) {
        System.out.println(firstCharacterSelected);
        if (!isFirstCharacterSelected) {
            isFirstCharacterSelected = true;
            firstCharacterSelected = e.getSource();
        }
        if (isFirstCharacterSelected && !isSecondCharacterSelected) {
            if (e.getSource() != firstCharacterSelected) {
                isSecondCharacterSelected = true;
            } else {
                System.err.println("Same Character Selected");
            }
        }
    }

    @FXML

    private void TestLaunch(ActionEvent e) throws Exception {
        gc.event();
    }

    @FXML
    public void Initialize() {
        this.Clement = new Button();
        this.Maxime = new Button();
        this.TestButton = new Button();
    }

    private void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(this.getClass().getResource("/fxml/HeroSelection.fxml"));
        Scene selectionScene = new Scene(root, 1500, 600.0D);

        root.getChildren().addAll(Clement, Maxime);
        primaryStage.setScene(selectionScene);
        primaryStage.show();
    }

    protected void event() throws Exception {
        this.start(new Stage());
    }
}
