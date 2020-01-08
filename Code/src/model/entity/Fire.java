package model.entity;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.hero.Character;
import model.manager.SkinManager;

public class Fire {
    private static final int RADIUS = 15;
    private static final int OPACITY = 0;
    private Character character;
    private Pane root;
    private Circle fireBallCircle;
    private FirePosition fireballPosition;
    private FireSkinPosition fireSkinPosition;
    private SkinManager skin;

    /**
     * @param character Character who casts the fireball
     * @param root      Actual parent-group ~~~~~~
     */
    public Fire(Character character, Pane root) {
        this.root = root;
        this.character = character;

        initializeFireball();

        skin = new SkinManager("Fireball");
        fireSkinPosition = new FireSkinPosition(skin);
        fireballPosition = new FirePosition(this);

        root.getChildren().addAll(fireBallCircle, skin.getSkinImage());
    }

    public void destruction() {
        root.getChildren().removeAll(fireBallCircle, skin.getSkinImage());

        fireballPosition = null;
        fireSkinPosition = null;
        fireBallCircle = null;
        skin = null;
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

    public Character getCharacter() {
        return character;
    }

    public SkinManager getSkinManager() {
        return skin;
    }

    Circle getFireBallCircle() {
        return fireBallCircle;
    }

    public FirePosition getFireballPosition() {
        return fireballPosition;
    }

    //</editor-fold>
}
