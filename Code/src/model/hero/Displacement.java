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
    private int nbJump = 0;
    private float tifloat;
    private boolean left, right, jump, isJumping = false;
    private long timeinit, timeinitx, onesecond = 1000000000, timex, ti;
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


            if (right) {
                timex = l - timeinitx;
                if (timex > 1000000) {
                    dx = 3;
                    timeinitx = l;
                    System.out.println("DROITE");
                }
            }

            if (left) {
                timex = l - timeinitx;
                if (timex > 1000000) {
                    dx = -3;
                    timeinitx = l;
                    System.out.println("GAUCHE");
                }
            }

            if (jump) {
                if (!isJumping) {
                    isJumping = true;
                    timeinit = l;
                    nbJump = nbJump + 1;
                }
            }

            ti = l - timeinit;
            tifloat = (float) ti / 1000000000;


            if (isJumping) {
                if (0.5 < tifloat && tifloat > 0.65 && nbJump < 2 && jump) {
                    timeinit = l;
                    isJumping = true;
                    nbJump = nbJump + 1;
                } else {
                    velocityY = -10 * Math.cos(Math.PI * tifloat);
                }

                if (nbJump < 2 && (l - timeinit) > onesecond) {
                    isJumping = false;
                    nbJump = 0;
                }

                if (nbJump == 2 && (l - timeinit) > (1.5 * onesecond)) {
                    isJumping = false;
                    nbJump = 0;
                    System.out.println("STOP");
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
