import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Deplacement {
    private CharacterPosition cp;
    Thread trh;


    public Deplacement(CharacterPosition cp) {
        this.cp=cp;
        trh = new Thread(new Jump(cp));
    }

    protected void eventOnKeyPressed(KeyEvent keyEvent) throws InterruptedException {

            KeyCode keyCode = keyEvent.getCode();
            switch (keyCode){
                case D:
                    cp.setPosX(cp.getHeroPosX()+10);
                    break;
                case Q:
                    cp.setPosX(cp.getHeroPosX()-10);
                    break;
                case Z:
                    if (!trh.isAlive()) {
                        trh.start();
                    }
                    break;
                case S:
                    cp.setPosY(cp.getHeroPosY()+10);
                    break;
            }
    }
}
