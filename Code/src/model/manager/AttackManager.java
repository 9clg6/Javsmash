package model.manager;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.entity.Fire;
import model.hero.Character;

public class AttackManager {

    private Character characterOne,characterTwo;
    private Pane root;

    public AttackManager(Character characterOne, Character characterTwo,Pane root) {
        this.root = root;
        this.characterOne = characterOne;
        this.characterTwo = characterTwo;
    }

    public void onAttackKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case E:
                new Fire(characterOne,root);
        }
    }
}
