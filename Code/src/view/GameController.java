package view;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.hero.Character;
import model.hero.CharacterPosition;
import model.hero.Displacement;

public class GameController {

    private Scene sc1;
    @FXML
    private Pane root;
    private Stage heroSelectionStage;
    private boolean isFirstCharacterSelecter;
    private String firstCharacterSelected, secondCharacterSelected;
    @FXML
    private ProgressBar healthBarPlayerA;
    @FXML
    private ProgressBar healthBarPlayerB;

    /**
     * @param heroSelectionStage Stage of the window
     *                           Initialize the window
     * @author Clement
     */
    public GameController(String firstCharacter, String secondCharacter, Stage heroSelectionStage) {
        this.heroSelectionStage = heroSelectionStage;
        this.firstCharacterSelected = firstCharacter;
        this.secondCharacterSelected = secondCharacter;
    }

    @FXML
    private void initialize() {
        initializeWindow();

        healthBarPlayerA.setOpacity(0);
    }

    /**
     * @author Clement
     * Initilize game-useful Objects, size of Window, character, key-event.
     */
    private void initializeWindow() {

        sc1 = new Scene(root, 1500, 600.0D);


        Character firstCharacter = new Character(sc1, firstCharacterSelected, true);
        Character secondCharacter = new Character(sc1, secondCharacterSelected, false);

        Displacement characterDisplacement = new Displacement(new CharacterPosition(firstCharacter, sc1), new CharacterPosition(secondCharacter, sc1), sc1, root);

        AnimationTimer gameLoop = new AnimationTimer() {

            @Override
            public void handle(long l) {

                characterDisplacement.moving(l);

                sc1.setOnKeyPressed(characterDisplacement::CharacterEventOnKeyPressed);

                sc1.setOnKeyReleased(characterDisplacement::CharacterEventOnKeyReleased);

            }
        };
        gameLoop.start();





        root.getChildren().addAll(firstCharacter.getHero(), firstCharacter.getSkin(), secondCharacter.getHero(), secondCharacter.getSkin());
        heroSelectionStage.setTitle("JavSmash - GAME STARTED");
        heroSelectionStage.setFullScreen(false);
        heroSelectionStage.setResizable(false);
        heroSelectionStage.setScene(sc1);
        heroSelectionStage.show();
    }


}
