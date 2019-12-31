package model.items;

/**
 * @author Clement GUYON
 */

public class Apple extends Consumable {

    private static int healPoints = 15;
    private boolean isConsumed;

    public Apple() {

    }

    public boolean isConsumed(){
        return isConsumed;
    }
}
