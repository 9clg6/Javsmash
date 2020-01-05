package model.manager;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.entity.Fire;
import model.hero.Character;

/***
 * Manager of Attack
 * @author Clément GUYON
 */
public class AttackManager {

    public static final int MAX_RANGE_FIREBALL_VALUE = 600;
    public static final int FIREBALL_MOVEMENT_ITERATOR = 10;
    private Character characterOne, characterTwo, characterWhoAttacked;
    private Pane root;
    private Fire fireBall;

    /**
     * Constructor that defines two character and the actual parent-group
     *
     * @param characterOne First Character selected
     * @param characterTwo Second Character selected
     * @param root         Actual parent group
     */
    public AttackManager(Character characterOne, Character characterTwo, Pane root) {
        this.root = root;
        this.characterOne = characterOne;
        this.characterTwo = characterTwo;
    }

    /***
     * Key Event starts when an key is pressed, here E for first character and NUMPAD0 for the second one.
     * If an fireball has been thrown before, destruct this instance and instantiates another one
     *
     * @param keyEvent Event of onKeyPressed
     */
    void onAttackKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case E:
                characterWhoAttacked = characterOne;

                if (fireBall != null) {
                    fireBall.destruction();
                }

                fireBall = new Fire(characterOne, root);
                break;
            case NUMPAD0:
                characterWhoAttacked = characterTwo;

                if (fireBall != null) {
                    fireBall.destruction();
                }

                fireBall = new Fire(characterTwo, root);
                break;

        }
    }

    /**
     * Check if an fireball is casted, if not throw new Fireball at the position of the character who attacked (ref {@link #characterWhoAttacked})
     *
     * @throws NullPointerException is thrown if any fireBall is casted
     */
    public void hasAttacked() {
        try {

            if (fireBall != null) {
                if (!(characterWhoAttacked == characterOne && fireBall.getFireballPosition().getPosX() > fireBall.getCharacter().getHero().getX() + MAX_RANGE_FIREBALL_VALUE)) {
                    fireBall.getFireballPosition().setPosXY(fireBall.getFireballPosition().getPosX() + FIREBALL_MOVEMENT_ITERATOR, fireBall.getFireballPosition().getPosY());
                } else {
                    fireBall.destruction();
                    System.gc();
                }
            }

        } catch (NullPointerException e) {

        }


    }

}
