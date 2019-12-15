package model.hero;

/**
 * @author Clement GUYON and Maxime DACISAC
 * HealPoints is an components of the Character which defines number of HealPoints at the spawn, remain
 */

public class HealPoints {
    private int HP;

    public HealPoints() {
        this.HP = 100;
    }

    public int getHP() {
        return HP;
    }

    void setHP(int HP) {
        this.HP = HP;
    }
}
