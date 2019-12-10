import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController {
    private Scene sc1;

    public Scene getSc1() {
        return sc1;
    }

    public GameController() {
    }

    private void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(this.getClass().getResource("/fxml/InGame.fxml"));
        sc1 = new Scene(root, 1500, 600.0D);

        Character character = new Character(sc1);
        Deplacement d = new Deplacement(new CharacterPosition(character, sc1), sc1);


        sc1.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                d.timer.start();
                d.eventOnKeyPressed(keyEvent);

                if (keyEvent.getCode() == KeyCode.ESCAPE){

                }

            }
        });

        sc1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                d.timer.start();
                d.eventOnKeyReleased(keyEvent);
            }
        });

        root.getChildren().addAll(character.getHero(), character.getSkin());
        primaryStage.setTitle("JavSmash - GAME STARTED");
        primaryStage.setFullScreen(false);
        primaryStage.setScene(sc1);
        primaryStage.show();
    }

    protected void event() throws Exception {
        this.start(new Stage());
    }


}
