package Hero;

import Interface.PositionAbstract;
import javafx.scene.image.ImageView;

public class CharacterSkinPosition implements PositionAbstract {
    private ImageView skin;

    public CharacterSkinPosition(CharacterSkinLoader skin) {
        this.skin = skin.getSkinImage();
    }

    protected void updatePosSkinY(CharacterPosition cp){
        setPosY(cp.getHeroPosY());
    }

    protected void updatePosSkinX(CharacterPosition cp){
        setPosX(cp.getHeroPosX());
    }

    @Override
    public void setPosX(double pos) {
        skin.setX(pos);
    }

    @Override
    public void setPosY(double pos) {
        skin.setY(pos);
    }


}
