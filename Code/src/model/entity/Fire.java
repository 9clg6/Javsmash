package model.entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.hero.Character;
import model.manager.SkinManager;

public class Fire {
    private static final int RADIUS = 15;
    private static final int OPACITY = 0;
    public static final double DAMAGE = 0.5;


    private Pane root;
    private Circle fireBallCircle;

    private FirePosition fireballPosition;

    private SkinManager skin;
    private FireSkinPosition fireSkinPosition;
    private double direction;
    private double posinitx, posinity;
    private FireDisplacement fireDisplacement;

    /**
     * @param root      Actual parent-group ~~~~~~
     */
    public Fire(Pane root, double posinitx, double posinity) {
        this.root = root;
        this.posinitx = posinitx;
        this.posinity= posinity;

        initializeFireball();

        skin = new SkinManager("Fireball");
        fireSkinPosition = new FireSkinPosition(skin);
        fireballPosition = new FirePosition(this);
        fireDisplacement= new FireDisplacement(this);

        root.getChildren().addAll(fireBallCircle, skin.getSkinImage());
    }

    /***
     *
     * @return damage of Fireball
     */
    public static double getDAMAGE() {
        return DAMAGE;
    }

    /**
     * Initialization of the fireball's base : Base Type, colors, size, opacity.
     */
    private void initializeFireball() {
        fireBallCircle = new Circle();

        fireBallCircle.setRadius(RADIUS);
        fireBallCircle.setOpacity(OPACITY);
    }

    //<editor-fold desc="Getter of Character, fireSkinPosition & FireBall">
    FireSkinPosition getFireSkinPosition() {
        return fireSkinPosition;
    }

    /**
     * Destructs the current fireball
     */
    public void destruction() {
        root.getChildren().removeAll(fireBallCircle, skin.getSkinImage());

        fireballPosition = null;
        fireSkinPosition = null;
        fireBallCircle = null;
        skin = null;
    }



    /***
     * @return the skin manager
     */
    public SkinManager getSkinManager() {
        return skin;
    }

    /***
     * @return the base-shape of fireball
     */
    public Circle getFireBallCircle() {
        return fireBallCircle;
    }

    /***
     * @return the actual position of fireball
     */
    public FirePosition getFireballPosition() {
        return fireballPosition;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getPosinitx() {
        return posinitx;
    }

    public double getPosinity() {
        return posinity;
    }

    public FireDisplacement getFireDisplacement() {
        return fireDisplacement;
    }


    //</editor-fold>
}
