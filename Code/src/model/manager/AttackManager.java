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
    private static final long ONESECOND = 1000000000;
    private static final long ONE_MICRO_SECOND = 1000000;
    private Character characterOne, characterTwo, characterWhoAttacked;
    private Pane root;
    private Fire fireBall;
    private FireDisplacement fireDisplacement;
    private long timeDisplacementFireball;
    private double characterScale;
    private long timeGlobal, timeLastAttackCharA, timeLastAttackCharB, timeSinceLastDisplacement;



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
                if (timeGlobal - timeLastAttackCharA > 0.75 * ONESECOND) {
                    newAttack(characterOne, 1);
                    timeLastAttackCharA = timeGlobal;
                }


                break;
            case NUMPAD0:
                if (timeGlobal - timeLastAttackCharB > 0.75 * ONESECOND) {
                    newAttack(characterTwo, -1);
                    timeLastAttackCharB = timeGlobal;

                }

                break;

        }
    }

    private void newAttack(Character c, double scale) {
        Fire fireBall = new Fire(root, c.getSkin().getX(), c.getSkin().getY());
        fireBall.setDirection(c.getSkin().getScaleX() * scale);
        c.AddFireBall(fireBall);
    }

    /**
     * Check if an fireball is casted, if not throw new Fireball at the position of the character who attacked (ref {@link #characterWhoAttacked})
     *
     * @throws NullPointerException is thrown if any fireBall is casted
     */
    public void hasAttacked(long time) {

        try {
            this.timeGlobal = time;

            if (time - timeSinceLastDisplacement > ONE_MICRO_SECOND) {
                goForwards(characterOne);
                goForwards(characterTwo);
                timeSinceLastDisplacement = time;
            }


        } catch (NullPointerException ignored) {

        }

    }


    private void goForwards(Character c) {
        if (c.getListFireBall().size()>0) {
            for (Fire fire : c.getListFireBall()) {
                if (fire.getFireballPosition().getPosX() > root.getWidth() || fire.getFireballPosition().getPosX() < 0) {
                    c.getListFireBall().remove(fire);
                    System.out.println(c.getListFireBall().size());
                    fire.destruction();

                } else {
                    fire.getFireDisplacement().goForward();
                }
            }
        }
    }


    public Fire getFireBall() {
        return fireBall;
    }

    public Character getCharacterWhoAttacked() {
        return characterWhoAttacked;
    }
}
