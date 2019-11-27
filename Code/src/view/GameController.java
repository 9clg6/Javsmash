import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;
import java.text.AttributedCharacterIterator;

public class GameController {
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/InGame.fxml"));



        ImageIcon icoBackground= new ImageIcon(getClass().getResource("/img/skin1.png"));
        ImageIcon icoCharac = new ImageIcon(getClass().getResource("/skin1.png"));



        primaryStage.setTitle("JavSmash - GAME STARTED");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public void event() throws Exception {
        start(new Stage());
    }

}
