import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Deplacement {
    private CharacterPosition cp;
    Thread trh;
    Scene sc;


    public Deplacement(CharacterPosition cp, Scene sc1) {
        this.cp=cp;
        trh = new Thread(new Jump(cp));
        sc = sc1;
    }

    protected void eventOnKeyPressed(KeyEvent keyEvent) throws InterruptedException {

            KeyCode keyCode = keyEvent.getCode();
            switch (keyCode){
                case D:
                    if(cp.getHeroPosX() < sc.getWidth() - 30)
                        cp.setPosX(cp.getHeroPosX()+10);
                    break;
                case Q:
                    if (cp.getHeroPosX() > 30)
                        cp.setPosX(cp.getHeroPosX()-10);
                    break;
                case SPACE:
                    if (!trh.isAlive()) {
                        trh.start();
                    }
                    break;
                //case S:
                  //  cp.setPosY(cp.getHeroPosY()+10);
                    //break;
            }
    }
}
