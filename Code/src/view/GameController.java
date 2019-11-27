import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController {

    private void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(this.getClass().getResource("/InGame.fxml"));
        Scene sc1 = new Scene(root, 1500, 600.0D);

        Personnage character = new Personnage();

        sc1.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                Deplacement d=new Deplacement(new CharacterPosition(character));
                d.eventOnKeyPressed(keyEvent);
            }
        });

        root.getChildren().addAll(character.getHero(),character.getSkin());
        primaryStage.setTitle("JavSmash - GAME STARTED");
        primaryStage.setScene(sc1);
        primaryStage.show();
    }

    protected void event() throws Exception {
        this.start(new Stage());
    }
}
