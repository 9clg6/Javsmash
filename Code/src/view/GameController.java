import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

    public GameController() throws IOException {
    }

    private void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(this.getClass().getResource("/InGame.fxml"));
        Scene sc1 = new Scene(root, 1500, 600.0D);

        Rectangle rect = new Rectangle(sc1.getWidth() - (sc1.getWidth() / 6),20);
        rect.setX(100);
        rect.setY(sc1.getHeight() - 50 );


        Personnage character = new Personnage(sc1);

        sc1.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                Deplacement d = new Deplacement(new CharacterPosition(character, sc1),sc1);

                try {
                    d.eventOnKeyPressed(keyEvent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        root.getChildren().addAll(rect,character.getHero(),character.getSkin());
        primaryStage.setTitle("JavSmash - GAME STARTED");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(sc1);
        primaryStage.show();
    }

    protected void event() throws Exception {
        this.start(new Stage());
    }
}
