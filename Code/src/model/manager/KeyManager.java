package model.manager;

import javafx.scene.input.KeyEvent;
import model.hero.Displacement;

public class KeyManager {
    private Displacement displacement;
    private AttackManager attackManager;

    public KeyManager(Displacement displacement, AttackManager attackManager) {
        this.displacement = displacement;
        this.attackManager = attackManager;
    }

    public void separatorOnPress(KeyEvent keyEvent){

        displacement.CharacterEventOnKeyPressed(keyEvent);
        attackManager.onAttackKeyPressed(keyEvent);
    }

    public void separatorOnRelease(KeyEvent keyEvent){
        displacement.CharacterEventOnKeyReleased(keyEvent);
    }
}