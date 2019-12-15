package model.hero;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 * @author Clement GUYON and Maxime DACISAC
 * Displacement is managing the displacement of the character on x,y,z
 */
public class Displacement {

    private Scene sc;
    private int nbJump = 0, i = 0;
    private boolean left, right, jump, isJumping = false;
    private double gravity = 1d, speed = 2d;
    private double posYinit;
    private CharacterPosition cp;
    private Sprite sprite;

    /**
     * GameLoop who manages displacement on x,y,z depending of keys pressed, released
     */
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {

            int dx = 0;
            double velocityY = 0;
            i = i + 1;
            if (right) {
                dx += 1;
            }
            if (left) {
                dx -= 1;
            }

            if (jump) {
                if (!isJumping) {
                    isJumping = true;
                    cp.setPositionXY(dx, velocityY - 5d);
                    nbJump = nbJump + 1;
                }
            }

            if (isJumping) {
                if (cp.getHeroPosY() < posYinit + 20d) {
                    velocityY = velocityY - (speed - gravity);
                    speed = speed - 0.5d;
                }

                if (nbJump < 2) {
                    if (-5 < speed && speed < 5) {
                        if (jump) {
                            isJumping = false;
                            speed = 20d;
                        }
                    }
                }

                if (cp.getHeroPosY() > posYinit - 10) {
                    isJumping = false;
                    gravity = 5d;
                    speed = 20d;
                    nbJump = 0;
                    cp.setPosY(posYinit);
                }
            }
            cp.setPositionXY(dx, velocityY);
        }
    };

    /**
     * Constructor of Displacement
     *
     * @param cp  defines the actual position of the character
     * @param sc1 defines the actual scene where keys-event are applied
     *            Instantiates the Sprite Class
     * @see Sprite,CharacterPosition
     */
    public Displacement(CharacterPosition cp, Scene sc1) {
        this.cp = cp;
        sc = sc1;
        sprite = new Sprite(cp);
        posYinit = cp.getHeroPosY();
    }

    /**
     * Getter of the gameLoop
     *
     * @return the actual AnimationTimer : timer
     * @see AnimationTimer
     */
    public AnimationTimer getTimer() {
        return timer;
    }

    /**
     * eventOnKeyPressed is called when an keys is press during the AnimationTimer and sets
     * boolean to know in which direction move and when jump.
     *
     * @param keyEvent KeyEvent, used to get which keys is pressed
     */
    public void eventOnKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                left = true;
                sprite.spriteAnimation("Walk");
                break;
            case D:
                right = true;
                sprite.spriteAnimation("Walk");
                break;
            case SPACE:
                jump = true;
                break;
        }
    }

    /**
     * eventOnKeyReleased is used to know when key is released to stop the animation and stop any movement
     *
     * @param keyEvent KeyEvent, used to get which key is released.
     * @see Sprite
     */
    public void eventOnKeyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                left = false;
                sprite.spriteReset();
                break;
            case D:
                right = false;
                sprite.spriteReset();
                break;
            case SPACE:
                jump = false;
                break;
        }
    }
}
