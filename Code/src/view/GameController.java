package view;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.hero.Character;
import model.hero.CharacterPosition;
import model.hero.Displacement;

public class GameController {

    private Scene sc1;
    private Pane root;
    private Stage heroSelectionStage;

    /**
     * @param root               Pane
     * @param heroSelectionStage Stage of the window
     *                           Initialize the window
     * @author Clement
     */
    public GameController(Pane root, Stage heroSelectionStage) {
        this.heroSelectionStage = heroSelectionStage;
        this.root = root;
        initializeWindow();
    }

    /**
     * @author Clement
     * Initilize game-useful Objects, size of Window, character, key-event.
     */
    private void initializeWindow() {

        sc1 = new Scene(root, 1500, 600.0D);

        Character character = new Character(sc1);
        Displacement d = new Displacement(new CharacterPosition(character, sc1), sc1);


        sc1.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                d.getTimer().start();
                d.eventOnKeyPressed(keyEvent);
            }
        });

        sc1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                d.getTimer().start();
                d.eventOnKeyReleased(keyEvent);
            }
        });

        root.getChildren().addAll(character.getHero(), character.getSkin());
        heroSelectionStage.setTitle("JavSmash - GAME STARTED");
        heroSelectionStage.setFullScreen(false);
        heroSelectionStage.setScene(sc1);
        heroSelectionStage.show();
    }

}
