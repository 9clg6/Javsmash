import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController {
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/InGame.fxml"));
        Scene sc1 = new Scene(root, 600, 600);

        Personnage character = new Personnage();

        sc1.setOnKeyPressed(keyEvent -> {
            KeyCode keyPressed = keyEvent.getCode();
            if (keyPressed.equals(KeyCode.D)) {
                character.setPosX(character.getPosX() + 20);

                System.out.println(character.getPosX());
            }
            if (keyPressed.equals(KeyCode.Q)) {
                character.setPosX(character.getPosX() - 20);

                System.out.println(character.getPosX());
            }
            if (keyPressed.equals(KeyCode.Z)) {
                character.setPosY(character.getPosY() - 20);

                System.out.println(character.getPosY());
            }
            if (keyPressed.equals(KeyCode.S)) {
                character.setPosY(character.getPosY() + 20);
                System.out.println(character.getPosY());
            }
        });


        root.getChildren().addAll(character.getHero(), character.getSkin());
        primaryStage.setTitle("JavSmash - GAME STARTED");
        primaryStage.setScene(sc1);
        primaryStage.show();
    }

    public void event() throws Exception {
        start(new Stage());
    }

}
