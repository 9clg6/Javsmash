package model.hero;

import javafx.scene.image.ImageView;
import model.Interface.IPosition;

/**
 * @author Clement GUYON
 * Class used to manage the position of the skin
 */
public class CharacterSkinIPosition implements IPosition {
    private ImageView skin;

    /**
     * Constructor
     *
     * @param skin types of CharacterSkinLoader
     * @see CharacterSkinLoader
     */
    public CharacterSkinIPosition(CharacterSkinLoader skin) {
        this.skin = skin.getSkinImage();
    }

    /**
     * updatePosSkinY updates the position of the skin in Y
     *
     * @param cp types of CharacterPosition
     */
    void updatePosSkinY(CharacterPosition cp) {
        setPosY(cp.getHeroPosY());
    }

    /**
     * updatePosSkinY updates the position of the skin in X
     *
     * @param cp types of CharacterPosition
     */
    void updatePosSkinX(CharacterPosition cp) {
        setPosX(cp.getHeroPosX());
    }

    /**
     * setPosX sets the position of the skin in Y
     *
     * @param pos types of double
     */
    @Override
    public void setPosX(double pos) {
        skin.setX(pos);
    }

    /**
     * setPosX sets the position of the skin in X
     * @param pos types of double
     */
    @Override
    public void setPosY(double pos) {
        skin.setY(pos);
    }


}
