import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Deplacement {

    private static int MAX_SPEED = -20;
    private boolean left, right, jump, ascension, isJumping=false;
    private double gravity = 5d, speed = 20d;
    private double posYinit, posYpos;

    private CharacterPosition cp;
    Scene sc;
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            int dx = 0;
            double velocityY = 0;

            if (left) dx += 2;
            if (right) dx -= 2;


            if (jump) {
                if (!isJumping) {
                    isJumping = true;
                    posYinit = cp.getHeroPosY();
                    cp.setPositionXY(dx, velocityY - 5d);
                    System.out.println("test 1");
                }
            }
            System.out.println(isJumping);
            if(isJumping){
                if(cp.getHeroPosY() < posYinit+20d){
                    velocityY = velocityY - (speed-gravity);
                    speed = speed - 0.5d;
                    System.out.println("test 2");
                }


                if ( speed < -11.5){
                    isJumping = false;
                    gravity = 5d;
                    speed = 20d;
                    System.out.println("test 3");
                }
            }
            cp.setPositionXY(dx, velocityY);
        }
    };



    public Deplacement(CharacterPosition cp, Scene sc1) {
        this.cp = cp;
        sc = sc1;
        posYinit=cp.getHeroPosY();
        posYpos = posYinit -5;
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
