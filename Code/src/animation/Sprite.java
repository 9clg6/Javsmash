package animation;

import javafx.scene.image.Image;
import model.Interface.ISprite;
import model.entity.FirePosition;
import model.hero.CharacterPosition;

/**
 * @author Clement GUYON
 * Sprite is use to change the skin of the character while he is walking to do an walk-animation
 * This class is used by the class Displacement
 */
public class Sprite<T> implements ISprite {
    public static final int MAX_ITERATOR_CHARACTER = 14;
    public static final int MAX_ITERATOR_FIREBALL = 5;
    public static final int SWITCH_SKIN_SPEED = 5;
    public static final int ZERO = 0;
    private static final int incrementer = 1;
    private static int counter = 1, iterator = 1;
    private T elementPosition;

    /**
     * @param elementPosition defines the position of the character
     *                        Defines the CharacterPosition
     */
    public Sprite(T elementPosition) {
        this.elementPosition = elementPosition;
    }

    /**
     * @param typeOfMovement tells if the character is walking, jumping, dying...
     *                       spriteAnimation is changing the image of the skin in function of the type of displacement and the character.
     */
    @Override
    public void spriteAnimation(String typeOfMovement) {
        counter++;
        if (counter % SWITCH_SKIN_SPEED == ZERO) {
            if (typeOfMovement.equals("Forward")) {
                if (elementPosition instanceof CharacterPosition) {
                    if (iterator + incrementer > MAX_ITERATOR_CHARACTER) {
                        iterator = incrementer;
                    }
                    iterator++;
                    Image imgChange = new Image(((CharacterPosition) elementPosition).getPersonnage().getSkinManager().getRepertory() + "Walk/" + iterator + ".png");
                    ((CharacterPosition) elementPosition).getPersonnage().getSkinManager().setSkinImage(imgChange);

                } else {
                    if (elementPosition instanceof FirePosition) {
                        if (iterator + incrementer > MAX_ITERATOR_FIREBALL) {
                            iterator = incrementer;
                        }
                        iterator++;
                        Image imgChange = new Image(((FirePosition) elementPosition).getFireBall().getSkinManager().getRepertory() + iterator + ".png");
                        ((FirePosition) elementPosition).getFireBall().getSkinManager().setSkinImage(imgChange);
                    }
                }
            }
        }
    }

    /**
     * @author Clement
     * spriteReset permits to set default-position of the skin when any key is pressed.
     */
    public void spriteReset() {
        if (elementPosition instanceof CharacterPosition) {
            ((CharacterPosition) elementPosition).getPersonnage().getSkinManager().setSkinImage(new Image(((CharacterPosition) elementPosition).getPersonnage().getSkinManager().getRepertory() + "Walk/" + "1.png"));
        } else {
            if (elementPosition instanceof FirePosition) {
                ((FirePosition) elementPosition).getFireBall().getSkinManager().setSkinImage(new Image(((FirePosition) elementPosition).getFireBall().getSkinManager().getRepertory() + "1.png"));
            }
        }
    }


}
