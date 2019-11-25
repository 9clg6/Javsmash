import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage secondaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/InGame.fxml"));//java.io.IOException est lancée par la méthode.load

            root.getChildrenUnmodifiable().addAll();

            secondaryStage.setTitle("JAVSMASH - ACTUALLY PLAYING");
            secondaryStage.setScene(new Scene(root, 300, 275));
            secondaryStage.show();
        } catch (java.io.IOException e) {
            System.out.println("start GameController Window Error | FilePersistence Manager error");
        }
    }

}
