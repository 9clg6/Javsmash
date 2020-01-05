package model.entity;

import javafx.scene.image.ImageView;
import model.Interface.IPosition;
import model.manager.SkinManager;

public class FireSkinPosition implements IPosition {

    private ImageView skin;

    FireSkinPosition(SkinManager skin) {
        this.skin = skin.getSkinImage();
        skin.getSkinImage().setFitHeight(60);
        skin.getSkinImage().setFitWidth(80);
    }

    //<editor-fold desc="POSITION X & Y UPDATER">
    void updatePosSkinX(FirePosition firePosition) {
        setPosX(firePosition.getPosX() - 50);
    }

    void updatePosSkinY(FirePosition firePosition) {
        setPosY(firePosition.getPosY() - 20);
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

    public double getPosY() {
        return skin.getY();
    }

    @Override
    public void setPosY(double pos) {
        skin.setY(pos);
    }
}
