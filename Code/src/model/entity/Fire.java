package model.entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.Interface.AttackEntity;
import model.hero.Character;
import model.manager.SkinManager;

public class Fire implements AttackEntity {
    private static final int RADIUS = 15;
    private static final int OPACITY = 0;
    public static final double DAMAGE = 0.15;

    private Character character;
    private Pane root;
    private Circle fireBallCircle;

    private FirePosition fireballPosition;

    private SkinManager skin;
    private FireSkinPosition fireSkinPosition;

    /**
     * @param character Character who casts the fireball
     * @param root      Actual parent-group ~~~~~~
     */
    public Fire(Character character, Pane root) {
        this.root = root;
        this.character = character;

        initialize();

        skin = new SkinManager("Fireball");
        fireSkinPosition = new FireSkinPosition(skin);
        fireballPosition = new FirePosition(this);

        root.getChildren().addAll(fireBallCircle, skin.getSkinImage());
    }



    /**
     * Initialization of the fireball's base : Base Type, colors, size, opacity.
     */
    @Override
    public void initialize() {
        fireBallCircle = new Circle();

        fireBallCircle.setRadius(RADIUS);
        fireBallCircle.setOpacity(OPACITY);
    }

    /**
     * Destructs the current fireball
     */
    @Override
    public void destruction() {
        root.getChildren().removeAll(fireBallCircle, skin.getSkinImage());

        fireballPosition = null;
        fireSkinPosition = null;
        fireBallCircle = null;
        skin = null;
    }

    /***
     *
     * @return damage of Fireball
     */
    public static double getDAMAGE() {
        return DAMAGE;
    }

    /***
     * Getter of the character
     * @return the character who cast the fireball
     */
    public Character getCharacter() {
        return character;
    }

    //<editor-fold desc="Getter of Character, fireSkinPosition & FireBall">
    FireSkinPosition getFireSkinPosition() {
        return fireSkinPosition;
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

    //</editor-fold>
}
