package model.entity;

import javafx.scene.shape.Circle;
import model.Interface.IPosition;

public class FirePosition implements IPosition {

    private Circle fireball;

    public FirePosition(Circle fireball) {
        this.fireball = fireball;
    }

    @Override
    public void setPosX(double pos) {
        fireball.setCenterX(pos);
    }

    @Override
    public void setPosY(double pos) {
        fireball.setCenterY(pos);
    }

    public void setPosXY(double X, double Y){
        setPosX(X);
        setPosY(Y);
    }


}
