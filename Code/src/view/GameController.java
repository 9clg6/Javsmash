package view;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.hero.Character;
import model.hero.CharacterPosition;
import model.hero.Displacement;
import model.manager.AttackManager;
import model.manager.ItemManager;
import model.manager.KeyManager;
import model.world.Collision;

import java.util.ArrayList;

public class GameController {

    private static final int MAX_WIDTH = 1500;
    private static final double MAX_HEIGHT = 600.0D;
    private static Scene sc1;

    @FXML
    private Pane root;
    private ArrayList<Character> characterCollection;
    private Stage heroSelectionStage;
    private String firstCharacterSelected, secondCharacterSelected;

    @FXML
    private Rectangle healthBarPlayerA;

    @FXML
    private Rectangle healthBarPlayerB;

    /**
     * @param heroSelectionStage Stage of the window
     *                           Initialize the window
     * @author Clement
     */
    GameController(String firstCharacter, String secondCharacter, Stage heroSelectionStage) {
        this.heroSelectionStage      = heroSelectionStage;
        this.firstCharacterSelected  = firstCharacter;
        this.secondCharacterSelected = secondCharacter;
    }

    @FXML
    private void initialize() {
        initializeWindow();
    }

    public static int getMaxWidth() {
        return MAX_WIDTH;
    }

    public static double getMaxHeight() {
        return MAX_HEIGHT;
    }

    /**
     * @author Clement
     * Initilize game-useful Objects, size of Window, character, key-event.
     */
    private void initializeWindow() {

        sc1 = new Scene(root, MAX_WIDTH, MAX_HEIGHT);
        sc1.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        Character firstCharacter = new Character(sc1, firstCharacterSelected, true);
        Character secondCharacter = new Character(sc1, secondCharacterSelected, false);

        characterCollection = new ArrayList<>();
        characterCollection.add(firstCharacter);
        characterCollection.add(secondCharacter);

        Displacement characterDisplacement = new Displacement(new CharacterPosition(firstCharacter), new CharacterPosition(secondCharacter), root);
        AttackManager attackManager = new AttackManager(firstCharacter, secondCharacter, root);
        KeyManager keyManager = new KeyManager(characterDisplacement, attackManager);
        ItemManager itemmanager = new ItemManager(root);

        Collision collision = new Collision(firstCharacter, secondCharacter);

        AnimationTimer gameLoop = new AnimationTimer() {

            @Override
            public void handle(long l) {

                characterDisplacement.moving(l);

                sc1.setOnKeyPressed(keyManager::separatorOnPress);
                sc1.setOnKeyReleased(keyManager::separatorOnRelease);

                collision.secondCheckCollision();

                attackManager.hasAttacked(l);

                itemmanager.spawnItem(l);

                healthBarPlayerA.setWidth(firstCharacter.getLifeStatus().getHP());
                healthBarPlayerB.setWidth(secondCharacter.getLifeStatus().getHP());

                //System.out.println(Math.random()*1000%500);


                //LIFE DOWNGRADING ACTUALISATION
                //firstCharacter.setLife(firstCharacter.getLifeStatus().getHP()-1);
                //System.out.println(firstCharacter.getLifeStatus().getHP());


            }
        };

        gameLoop.start();


        for (Character character : characterCollection) {
            for (Circle circle : character.getHitbox().getCircleArrayList()) {
                root.getChildren().addAll(circle);
            }
        }

        root.getChildren().addAll(firstCharacter.getHero(),
                firstCharacter.getSkin(),
                secondCharacter.getHero(),
                secondCharacter.getSkin()
        );


        heroSelectionStage.setTitle("JavSmash - GAME STARTED");
        heroSelectionStage.setFullScreen(false);
        heroSelectionStage.setResizable(false);
        heroSelectionStage.setScene(sc1);
        heroSelectionStage.show();
    }
}
