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

    private int nbJumpA = 0;
    private int nbJumpB = 0;

    private float tifloatA;
    private float tifloatB;

    private boolean leftA, rightA, jumpA, isJumpingA = false;
    private boolean leftB, rightB, jumpB, isJumpingB = false;

    private long timeInitA, timeInitB, timeinitxA, timeinitxB, oneSecond = 1000000000, timexA, timexB, ti, ty;

    private CharacterPosition firstCp, secondCp;
    private Sprite spriteA, spriteB;
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            int dxA = 0, dxB = 0;
            double velocityYA = 0, velocityYB = 0;

            if (rightA) {
                timexA = l - timeinitxA;
                if (timexA > 1000000) {
                    dxA = 3;
                    timeinitxA = l;
                }
            }

            if (rightB) {
                timexB = l - timeinitxB;
                if (timexB > 1000000) {
                    dxB = 3;
                    timeinitxB = l;
                }
            }

            if (leftA) {
                timexA = l - timeinitxA;
                if (timexA > 1000000) {
                    dxA = -3;
                    timeinitxA = l;
                }
            }


            if (leftB) {
                timexB = l - timeinitxB;
                if (timexB > 1000000) {
                    dxB = -3;
                    timeinitxB = l;
                }
            }

            if (jumpA) {
                if (!isJumpingA) {
                    isJumpingA = true;
                    timeInitA = l;
                    nbJumpA = nbJumpA + 1;
                }
            }

            ti = l - timeInitA;

            if (jumpB) {
                if (!isJumpingB) {
                    isJumpingB = true;
                    timeInitB = l;
                    nbJumpB = nbJumpB + 1;
                }
            }

            ty = l - timeInitB;

            tifloatA = (float) ti / 1000000000;
            tifloatB = (float) ty / 1000000000;

            if (isJumpingA) {
                if (0.5 < tifloatA && tifloatA > 0.65 && nbJumpA < 2 && jumpA) {
                    timeInitA = l;
                    isJumpingA = true;
                    nbJumpA = nbJumpA + 1;
                } else {
                    velocityYA = -10 * Math.cos(Math.PI * tifloatA);
                }

                if (nbJumpA < 2 && (l - timeInitA) > oneSecond) {
                    isJumpingA = false;
                    nbJumpA = 0;
                }

                if (nbJumpA == 2 && (l - timeInitA) > (1.5 * oneSecond)) {
                    isJumpingA = false;
                    nbJumpA = 0;
                }
            }

            firstCp.setPositionXY(dxA, velocityYA);

            if (isJumpingB) {
                if (0.5 < tifloatB && tifloatB > 0.65 && nbJumpB < 2 && jumpB) {
                    timeInitB = l;
                    isJumpingB = true;
                    nbJumpB = nbJumpB + 1;
                } else {
                    velocityYB = -10 * Math.cos(Math.PI * tifloatB);
                }

                if (nbJumpB < 2 && (l - timeInitB) > oneSecond) {
                    isJumpingB = false;
                    nbJumpB = 0;
                }

                if (nbJumpB == 2 && (l - timeInitB) > (1.5 * oneSecond)) {
                    isJumpingB = false;
                    nbJumpB = 0;
                }
            }

            secondCp.setPositionXY(dxB, velocityYB);
        }
    };

    /**
     * GameLoop who manages displacement on x,y,z depending of keys pressed, released
     * Constructor of Displacement
     *
     * @param firstCp  defines the actual position of the first character
     * @param secondCp defines the actual position of the second character
     * @param sc1      defines the actual scene where keys-event are applied
     *                 Instantiates the Sprite Class
     * @see Sprite, CharacterPosition
     */
    public Displacement(CharacterPosition firstCp, CharacterPosition secondCp, Scene sc1) {
        this.firstCp = firstCp;
        this.secondCp = secondCp;

        sc = sc1;
        spriteA = new Sprite(this.firstCp);
        spriteB = new Sprite(this.secondCp);
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
     * CharacterEventOnKeyPressed is called when an keys is press during the AnimationTimer and sets
     * boolean to know in which direction move and when jumpA.
     *
     * @param keyEvent KeyEvent, used to get which keys is pressed
     */
    public void CharacterEventOnKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                leftA = true;
                spriteA.spriteAnimation("Walk");
                firstCp.getPersonnage().getSkin().setScaleX(-1);
                break;
            case D:
                rightA = true;
                spriteA.spriteAnimation("Walk");
                firstCp.getPersonnage().getSkin().setScaleX(1);
                break;
            case SPACE:
                jumpA = true;
                break;

            case LEFT:
                leftB = true;
                spriteB.spriteAnimation("Walk");
                secondCp.getPersonnage().getSkin().setScaleX(1);
                break;
            case RIGHT:
                rightB = true;
                spriteB.spriteAnimation("Walk");
                secondCp.getPersonnage().getSkin().setScaleX(-1);
                break;
            case UP:
                jumpB = true;
                break;
            case E:
                new RangeAttack(firstCp.getPersonnage());
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
