import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Deplacement {

    private static int MAX_SPEED = -20;
    private boolean left, right, jumping;
    private double gravity = 10;

    private CharacterPosition cp;
    Scene sc;

    public Deplacement(CharacterPosition cp, Scene sc1) {
        this.cp=cp;
        sc = sc1;
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            int dx = 0;
            int velocityY = 0;

            if (left) dx += 7;
            if (right) dx -= 7;
            if (jumping) velocityY -= 10;

            if (velocityY < MAX_SPEED) {
                velocityY = MAX_SPEED;
            }

            if (!jumping) {
                velocityY += gravity;
            }
            System.out.println(cp.getHeroPosY());
            cp.setPositionXY(dx, velocityY);
        }
    };

    protected void eventOnKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case Q:
                right = true;
                break;
            case D:
                left = true;
                break;
            case SPACE:
                jumping = true;
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
                jumping = false;
                break;

        }
    }


}
