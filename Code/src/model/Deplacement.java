import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Deplacement {
    private CharacterPosition cp;
    private Jump jump = new Jump(cp);



    public Deplacement(CharacterPosition cp) {
        this.cp=cp;
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
                    new Thread(jump).start();
                    break;
                case S:
                    cp.setPosY(cp.getHeroPosY()+10);
                    break;
            }
    }
}
