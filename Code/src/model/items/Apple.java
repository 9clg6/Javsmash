package model.items;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.entity.FirePosition;
import model.entity.FireSkinPosition;
import model.manager.SkinManager;

/**
 * @author Clement GUYON
 */

public class Apple extends Consumable {

    private static int healPoints = 15;
    private boolean isConsumed;
    private long timeappear;

    private static final int RADIUS = 15;
    private static final int OPACITY = 0;

    private Pane root;
    private Circle appleCircle;
    private FirePosition applePosition;
    private FireSkinPosition appleSkinPosition;
    private SkinManager skin;

    public Apple() {

        skin = new SkinManager("Apple");
        //appleSkinPosition = new AppleSkinPosition(skin);
        //applePosition = new ApplePosition(this);

    }

    public boolean isConsumed(){
        return isConsumed;
    }
}
