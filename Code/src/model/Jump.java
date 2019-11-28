import javafx.application.Platform;

import static java.lang.Thread.sleep;

public class Jump implements Runnable {
    private final double MAX_JUMP = 50;
    private boolean isJumping = false;
    private double posY;

    private CharacterPosition cp;

    public Jump(CharacterPosition cp) {
        this.cp = cp;
    }

    public void doJump(boolean jumping) throws InterruptedException {
        if (jumping) {
            for (double i = 0; i < MAX_JUMP; ++i) {
                posY += i;
                sleep(100);
                Platform.runLater(() ->
                        cp.setPosY(cp.getHeroPosY() - posY));
            }
            setJumping(false);
        }
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    @Override
    public void run() {
        try {
            doJump(isJumping());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
