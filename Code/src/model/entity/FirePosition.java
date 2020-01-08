package model.entity;

import model.Interface.IPosition;

public class FirePosition implements IPosition {

    private static final int FIREBALL_CHARACTER_DISTANCE = 20;
    private Fire fireBall;

    FirePosition(Fire fireBall) {
        this.fireBall = fireBall;
        spawnInitPosition();
    }

    private void spawnInitPosition() {
        setPosXY(fireBall.getCharacter().getHero().getX() + 40, fireBall.getCharacter().getHero().getY() + FIREBALL_CHARACTER_DISTANCE);
    }

    //<editor-fold desc="POSITION SETTER X & Y and XY">
    public void setPosXY(double X, double Y) {
        setPosX(X);
        setPosY(Y);
    }

    //<editor-fold desc="POSITION X & Y GETTER">
    public double getPosY() {
        return fireBall.getFireBallCircle().getCenterY();
    }

    @Override
    public void setPosY(double pos) {
        fireBall.getFireBallCircle().setCenterY(pos);
        fireBall.getFireSkinPosition().updatePosSkinY(this);
    }
    //</editor-fold>


    public Fire getFireBall() {
        return fireBall;
    }

    public double getPosX() {
        return fireBall.getFireBallCircle().getCenterX();
    }

    @Override
    public void setPosX(double pos) {
        fireBall.getFireBallCircle().setCenterX(pos);
        fireBall.getFireSkinPosition().updatePosSkinX(this);
    }
    //</editor-fold>


}
