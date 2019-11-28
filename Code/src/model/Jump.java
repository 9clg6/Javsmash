import static java.lang.Thread.sleep;

public class Jump implements Runnable {
    private final double MAX_JUMP = 15;

    private CharacterPosition cp;

    public Jump(CharacterPosition cp) {
        this.cp = cp;
    }

    public void doJump() throws InterruptedException {

        double originY = cp.getHeroPosY();
            for (double i = 0; i < MAX_JUMP; ++i) {
                cp.setPosY(cp.getHeroPosY() - i);
                sleep(20);
            }

        sleep(35);
        for (double i = 0; cp.getHeroPosY() < originY; ++i) {
            cp.setPosY(cp.getHeroPosY() + i);
            sleep(20);
        }
    }

    @Override
    public void run() {
        try {
            doJump();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
