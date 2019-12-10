import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Deplacement {

    private int nbJump = 0;
    private boolean left, right, jump, isJumping = false;
    private double gravity = 5d, speed = 20d;
    private double posYinit;
    private CharacterPosition cp;
    private Sprite sprite;
    Scene sc;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            int dx = 0;
            double velocityY = 0;

            if (right) {
                dx += 2;
                sprite.SpriteAnimation("Walk");

            }
            if (left) {
                dx -= 2;
                sprite.SpriteAnimation("Walk");
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


    public Deplacement(CharacterPosition cp, Scene sc1) {
        this.cp = cp;
        sc = sc1;
        sprite = new Sprite(cp);
        posYinit = cp.getHeroPosY();
    }

    protected void eventOnKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                left = true;
                break;
            case D:
                right = true;
                break;
            case SPACE:
                jump = true;
                break;
        }
    }

    protected void eventOnKeyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                left = false;
                sprite.SpriteReset();
                break;
            case D:
                right = false;
                sprite.SpriteReset();
                break;
            case SPACE:
                jump = false;
                break;

        }
    }


}
