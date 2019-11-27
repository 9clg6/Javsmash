import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class GameController {
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/InGame.fxml"));


        Circle hero = new Circle();
        hero.setCenterX(100);
        hero.setCenterY(300);
        hero.setRadius(30);
        hero.setFill(Color.BLACK);

        try {
            Image skin = new Image(new FileInputStream(getClass().getResource("skin1.png").toString()));
            ImageView img = new ImageView(skin);

        } catch (Exception e) {
            System.err.println("Skin non-chargé");
        }


        root.getChildren().add(hero);
        primaryStage.setTitle("JavSmash - GAME STARTED");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public void event() throws Exception {
        start(new Stage());
    }

}
