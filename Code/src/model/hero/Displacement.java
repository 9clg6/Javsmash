package model.hero;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * @author Clement GUYON and Maxime DACISAC
 * Displacement is managing the displacement of the character on x,y,z
 */
public class Displacement {
    private Pane root;

    private boolean leftA, rightA, jumpA, Aattacking;
    private boolean leftB, rightB, jumpB;

    private long timeinitA, timeinitB, timeA, timeB, oneSecond = 1000000000, timeinitAttackA;

    private CharacterPosition firstCp, secondCp;
    private Sprite spriteA, spriteB;


    /**
     * GameLoop who manages displacement on x,y,z depending of keys pressed, released
     * Constructor of Displacement
     *
     * @param firstCp  defines the actual position of the first character
     * @param secondCp defines the actual position of the second character
     *                 Instantiates the Sprite Class
     * @see Sprite, CharacterPosition
     */

    public Displacement(CharacterPosition firstCp, CharacterPosition secondCp, Pane root) {
        this.firstCp = firstCp;
        this.secondCp = secondCp;
        this.root = root;

        spriteA = new Sprite(this.firstCp);
        spriteB = new Sprite(this.secondCp);
    }

    private void swapScale(CharacterPosition characterPosition) {
        if (characterPosition.getPersonnage().getSkin().getScaleX() == 1 && leftA || rightB) {
            setScale(characterPosition, -1);

        } else {
            if (characterPosition.getPersonnage().getSkin().getScaleX() == -1 && rightA || leftB)
                setScale(characterPosition, 1);

        }
    }

    private void setScale(CharacterPosition characterPosition, double orientation) {
        characterPosition.getPersonnage().getSkin().setScaleX(orientation);
        characterPosition.getPersonnage().getHero().setScaleX(orientation);
    }

    public boolean moving(long l) {

        timeA = l - timeinitA;
        if (movingLR(firstCp, leftA, rightA, timeA)) {
            timeinitA = l;
        }

        timeB = l - timeinitB;
        if (movingLR(secondCp, leftB, rightB, timeB)) {
            timeinitB = l;
        }

        jump(firstCp, jumpA, l);

        jump(secondCp, jumpB, l);

        if (Aattacking) {
            if (l - timeinitAttackA > 2 * oneSecond) {
                new RangeAttack(firstCp.getPersonnage(), root);
                Aattacking = false;
                timeinitAttackA = l;
            }
        }
        return false;
    }

    private boolean movingLR(CharacterPosition cp, boolean isMovingL, boolean isMovingR, long time) {
        double dx = 3;

        if (isMovingL)
            dx = dx * -1;

        if (isMovingL || isMovingR) {

            if (time > oneSecond / 1000) {
                cp.setPosX(dx);
                return true;
            }
        }
        return false;
    }


    private void jump(CharacterPosition cp, boolean jump, long l) {


        if (jump && !cp.isJumping()) {
            cp.setJumping(true);
            cp.setNbJump(cp.getNbJump() + 1);
            cp.setTimeInit(l);


        }
        cp.setTi(l - cp.getTimeInit());
        cp.setTiFloat((float) cp.getTi() / 1000000000);

        if (cp.isJumping()) {


            if (0.5 < cp.getTiFloat() && cp.getTiFloat() > 0.6 && cp.getNbJump() < 2 && jump) {
                cp.setJumping(true);
                cp.setNbJump(cp.getNbJump() + 1);
                cp.setTimeInit(l);

            } else {
                cp.setPosY(-10 * Math.cos(Math.PI * cp.getTiFloat()));

            }

            if (cp.getNbJump() < 2 && (l - cp.getTimeInit()) > oneSecond) {
                cp.setJumping(false);
                cp.setNbJump(0);

            }

            if (cp.getNbJump() == 2 && (l - cp.getTimeInit()) > (1.5 * oneSecond)) {
                cp.setJumping(false);
                cp.setNbJump(0);
            }
        }
    }

    /**
     * CharacterEventOnKeyPressed is called when an keys is press during the AnimationTimer and sets
     * boolean to know in which direction move and when jumpA.
     *
     * @param keyEvent KeyEvent, used to get which keys is pressed
     */
    public void CharacterEventOnKeyPressed(KeyEvent keyEvent) {
        spriteA.spriteAnimation("Walk");
        spriteB.spriteAnimation("Walk");
        switch (keyEvent.getCode()) {
            case Q:
                leftA = true;
                swapScale(firstCp);
                break;
            case D:
                rightA = true;
                swapScale(firstCp);
                break;
            case SPACE:
                jumpA = true;
                break;

            case LEFT:
                leftB = true;
                swapScale(secondCp);
                break;
            case RIGHT:
                rightB = true;
                swapScale(secondCp);
                break;
            case UP:
                jumpB = true;
                break;
        }
    }

    /**
     * CharacterEventOnKeyReleased is used to know when key is released to stop the animation and stop any movement
     *
     * @param keyEvent KeyEvent, used to get which key is released.
     * @see Sprite
     */
    public void CharacterEventOnKeyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                leftA = false;
                spriteA.spriteReset();
                break;
            case D:
                rightA = false;
                spriteA.spriteReset();
                break;
            case SPACE:
                jumpA = false;
                break;

            case LEFT:
                leftB = false;
                spriteB.spriteReset();
                break;
            case RIGHT:
                rightB = false;
                spriteB.spriteReset();
                break;
            case UP:
                jumpB = false;
                break;
        }
    }
}
