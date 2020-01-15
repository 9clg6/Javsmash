package model.manager;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.entity.Fire;
import model.entity.FireDisplacement;
import model.hero.Character;

/***
 * Manager of Attack
 * @author Clément GUYON
 */
public class AttackManager {

    public static final int MAX_RANGE_FIREBALL_VALUE = 600;
    private static final long ONE_MICRO_SECOND = 1000000;
    private Character characterOne, characterTwo, characterWhoAttacked;
    private Pane root;
    private Fire fireBall;
    private FireDisplacement fireDisplacement;
    private long timeDisplacementFireball;
    private double characterScale;


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

                isFireballNull();
                fireBall = new Fire(characterOne, root);

                fireDisplacement = new FireDisplacement(fireBall);
                characterScale= characterWhoAttacked.getSkin().getScaleX();
                break;
            case NUMPAD0:
                characterWhoAttacked = characterTwo;

                isFireballNull();

                fireBall = new Fire(characterTwo, root);
                fireDisplacement = new FireDisplacement(fireBall);
                characterScale= characterWhoAttacked.getSkin().getScaleX();

                break;

        }
    }

    /**
     * Check if an fireball is casted, if not throw new Fireball at the position of the character who attacked (ref {@link #characterWhoAttacked})
     *
     * @throws NullPointerException is thrown if any fireBall is casted
     */
    public void hasAttacked(long time) {
        try {
            if (!(fireBall.getFireballPosition().getPosX() > fireBall.getCharacter().getHero().getX() + MAX_RANGE_FIREBALL_VALUE)) {

                    if (time - timeDisplacementFireball > ONE_MICRO_SECOND) {
                        fireDisplacement.goForward(characterScale);
                        timeDisplacementFireball = time;
                    }

                } else {
                    fireBall.destruction();
                    System.gc();
                }

        } catch (NullPointerException ignored) {

        }
    }

    /***
     *
     */
    private void isFireballNull() {
        try {
            if (fireBall != null) {
                fireBall.destruction();
            }
        } catch (NullPointerException ignored) {
        }
    }

    public Fire getFireBall() {
        return fireBall;
    }

    public Character getCharacterWhoAttacked() {
        return characterWhoAttacked;
    }
}
