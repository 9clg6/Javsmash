import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Deplacement {

    private static int MAX_SPEED = -20;
    private boolean left, right, jump, ascension = true;
    private int stepAscend = 1;
    private double gravity = 10;

    private CharacterPosition cp;
    Scene sc;
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            int dx = 0, velocityY = 0;

            if (left) dx += 2;
            if (right) dx -= 2;

            if (jump) {
                if (ascension) {
                    if (cp.getHeroPosY() > sc.getHeight() - 200) {
                        velocityY += 5 * stepAscend;

                        if (cp.getHeroPosY() == sc.getHeight() - 200) {
                            velocityY += 5 * stepAscend;
                        }
                    }

                }


            } else {
                velocityY += gravity;
            }

            if (velocityY < MAX_SPEED) {
                velocityY = MAX_SPEED;
            }
            cp.setPositionXY(dx, velocityY);
        }
    };

    public Deplacement(CharacterPosition cp, Scene sc1) {
        this.cp = cp;
        sc = sc1;
    }

    protected void eventOnKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                right = true;
                break;
            case D:
                left = true;
                break;
            case SPACE:
                jump = true;

                break;
        }
    }

    protected void eventOnKeyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                right = false;
                break;
            case D:
                left = false;
                break;
            case SPACE:
                jump = false;
                break;

        }
    }


}
