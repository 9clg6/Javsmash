import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Deplacement {

    private static int MAX_SPEED = -20;
    private static double gravity = -3;
    Scene sc;
    private boolean left, right, jump, onGround = true, isJumping, isFalling;
    private CharacterPosition cp;
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            int dx = 0, dy = 0, velocityY = -5;

            if (left) dx += 2;
            if (right) dx -= 2;

            System.out.println("isFalling = " + isFalling);
            System.out.println("isJumping = " + isJumping);
            System.out.println("onGround = " + onGround);
            System.out.println(cp.getHeroPosY());

            if (jump && onGround) {
                if (cp.getHeroPosY() == 545.5) {
                    onGround = true;
                    isJumping = false;
                    isFalling = false;
                }
                if (onGround) {
                    if (cp.getHeroPosY() > sc.getHeight() - 300) {
                        dy += velocityY;
                        isJumping = true;
                    }
                }
                if (cp.getHeroPosY() == 296.5) {
                    onGround = false;
                    isJumping = false;
                    isFalling = true;
                    dy -= gravity;
                }
            } else {
                dy -= gravity;
            }

            cp.setPositionXY(dx, dy);
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
