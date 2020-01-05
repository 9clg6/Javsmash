package model.hero;

/**
 * @author Clement GUYON and Maxime DACISAC
 * HealPoints is an components of the Character which defines number of HealPoints at the spawn, remain
 */

public class HealPoints {
    private double HP;
    private static double MIN_HP = 0;

    public HealPoints() {
        this.HP = 200;
    }

    public double getHP() {
        return Math.max(HP, MIN_HP);
    }

    void setHP(double HP) {
        this.HP = HP;
    }
}
