package model.hero;

import javafx.scene.image.Image;
import model.entity.FirePosition;

/**
 * @author Clement GUYON
 * Sprite is use to change the skin of the character while he is walking to do an walk-animation
 * This class is used by the class Displacement
 */
class Sprite {
    private CharacterPosition cp;
    private FirePosition fp;
    private int count = 1, i = 1;

    /**
     * @param cp defines the position of the character
     *           Defines the CharacterPosition
     */
    Sprite(CharacterPosition cp) {
        this.cp = cp;
    }

    Sprite(FirePosition fp) {
        this.fp = fp;
    }

    /**
     * @param typeOfMovement tells if the character is walking, jumping, dying...
     *                       spriteAnimation is changing the image of the skin in function of the type of displacement and the character.
     */
    void spriteAnimation(String typeOfMovement) {
        count++;
        if (count % 5 == 0) {
            if (typeOfMovement.equals("Walk")) {
                if (i + 1 > 14) {
                    i = 1;
                }
                i++;
                Image imgChange = new Image(cp.getPersonnage().getSkinLoader().getRepertory() + "Walk/" + i + ".png");
                cp.getPersonnage().getSkinLoader().setSkinImage(imgChange);
            }
        }
    }

    /**
     * @author Clement
     * spriteReset permits to set default-position of the skin when any key is pressed.
     */
    void spriteReset() {
        cp.getPersonnage().getSkinLoader().setSkinImage(new Image(cp.getPersonnage().getSkinLoader().getRepertory() + "Walk/" + "1.png"));
    }
}
