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
    private boolean isFirstCharacterSelecter;
    private String firstCharacterSelected, secondCharacterSelected;
    /**
     * @param root               Pane
     * @param heroSelectionStage Stage of the window
     *                           Initialize the window
     * @author Clement
     */
    public GameController(String firstCharacter, String secondCharacter, Pane root, Stage heroSelectionStage) {
        this.heroSelectionStage = heroSelectionStage;
        this.root = root;
        this.firstCharacterSelected = firstCharacter;
        this.secondCharacterSelected = secondCharacter;
        initializeWindow();


    }

    /**
     * @author Clement
     * Initilize game-useful Objects, size of Window, character, key-event.
     */
    private void initializeWindow() {

        sc1 = new Scene(root, 1500, 600.0D);

        Character firstCharacter = new Character(sc1, firstCharacterSelected, true);
        Character secondCharacter = new Character(sc1, secondCharacterSelected, false);

        Displacement CharacterDisplacement = new Displacement(new CharacterPosition(firstCharacter, sc1), new CharacterPosition(secondCharacter, sc1), sc1, root);


        sc1.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                CharacterDisplacement.getTimer().start();
                CharacterDisplacement.CharacterEventOnKeyPressed(keyEvent);
            }
        });
        sc1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                CharacterDisplacement.getTimer().start();
                CharacterDisplacement.CharacterEventOnKeyReleased(keyEvent);
            }
        });

        root.getChildren().addAll(firstCharacter.getHero(), firstCharacter.getSkin(), secondCharacter.getHero(), secondCharacter.getSkin());
        heroSelectionStage.setTitle("JavSmash - GAME STARTED");
        heroSelectionStage.setFullScreen(false);
        heroSelectionStage.setResizable(false);
        heroSelectionStage.setScene(sc1);
        heroSelectionStage.show();
    }

}
