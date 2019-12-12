package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.hero.Character;
import model.hero.CharacterPosition;
import model.hero.Deplacement;

public class HeroSelectionController {
    @FXML
    private Button Clement;
    @FXML
    private Button Maxime;
    @FXML
    private Button TestButton;
    private boolean isFirstCharacterSelected = false, isSecondCharacterSelected = false;
    private boolean finalState;
    private Object firstCharacterSelected, secondCharacterSelected;

    public HeroSelectionController() {

    }

    @FXML
    private void characterSelected(ActionEvent e) throws Exception {
        if (!isFirstCharacterSelected) {
            System.out.println("First Charac selected");
            isFirstCharacterSelected = true;
            firstCharacterSelected = e.getSource();
        } else {
            if (isFirstCharacterSelected && !isSecondCharacterSelected) {
                if (e.getTarget() != firstCharacterSelected) {
                    isSecondCharacterSelected = true;
                    secondCharacterSelected = e.getSource();
                    updateFinalState();

                    if (finalState) {
                        start();
                    }

                } else {
                    System.err.println("Same Character Selected");
                }
            }
        }


    }

    private void updateFinalState() {
        finalState = isFirstCharacterSelected && isSecondCharacterSelected;
    }

    @FXML

    private void testLaunch(ActionEvent e) throws Exception {
        start();
    }

    @FXML
    private void initialize() {

    }

    private void start() throws Exception {
        Stage heroSelectionStage = new Stage();
        heroSelectionStage.initModality(Modality.APPLICATION_MODAL);
        Pane root = FXMLLoader.load(this.getClass().getResource("/fxml/InGame.fxml"));
        Scene sc1 = new Scene(root, 1500, 600.0D);

        Character character = new Character(sc1);
        Deplacement d = new Deplacement(new CharacterPosition(character, sc1), sc1);


        sc1.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                d.getTimer().start();
                d.eventOnKeyPressed(keyEvent);

                if (keyEvent.getCode() == KeyCode.ESCAPE) {

                }

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
