package model.entity;

import javafx.scene.image.ImageView;
import model.Interface.IPosition;
import model.Interface.ISkinPosition;
import model.manager.SkinManager;

public class FireSkinPosition implements IPosition, ISkinPosition {

    private ImageView skin;

    FireSkinPosition(SkinManager skin) {
        this.skin = skin.getSkinImage();
        skin.getSkinImage().setFitHeight(60);
        skin.getSkinImage().setFitWidth(80);
    }


    //<editor-fold desc="POSITION X & Y UPDATER">
    public void updatePosSkinX(double pos) {
        setPosX(pos - 50);
    }

    public void updatePosSkinY(double pos) {
        setPosY(pos - 20);
    }
    //</editor-fold>

    public double getPosX() {
        return skin.getX();
    }

    //<editor-fold desc="POSITION SETTER X & Y">
    @Override
    public void setPosX(double pos) {
        skin.setX(pos);
    }
    //</editor-fold>

    @Override
    public void setPosY(double pos) {
        skin.setY(pos);
    }
}
