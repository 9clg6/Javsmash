package model.hero;

import javafx.scene.Scene;

/**
 * @author Clement GUYON
 * CharacterPositiong manages the position of the character
 */
public class CharacterPosition implements model.Interface.IPosition {
    private Character p;
    private Scene s1;

    /**
     * Constructor
     *
     * @param p  defines the character
     * @param s1 defines the scene
     */
    public CharacterPosition(Character p, Scene s1) {
        this.p = p;
        this.s1 = s1;

        setPosX(p.getHero().getX());
        setPosY(p.getHero().getY());
    }

    /**
     * Setter of position X and Y
     *
     * @param posX type of double
     * @param posY type of double
     */
    void setPositionXY(double posX, double posY) {
        setPosX(posX);
        setPosY(posY);
    }

    /**
     * Setter of the position X of the character
     *
     * @param position type of double
     */
    public void setPosX(double position) {
        p.getHero().setX(p.getHero().getX() + position);
        p.getSp().updatePosSkinX(this);

        if (p.getHero().getX() < 32) {
            p.getHero().setX(s1.getWidth() - s1.getWidth() + 32);
        }
        if (p.getHero().getX() > s1.getWidth() - 64) {
            p.getHero().setX(s1.getWidth() - 64);
        }

    }

    /**
     * Setter of the position Y of the character
     *
     * @param position type of double
     */
    public void setPosY(double position) {
        if (!(p.getHero().getY() + position > s1.getHeight() - 52)) {
            p.getHero().setY(p.getHero().getY() + position);
            p.getSp().updatePosSkinY(this);
        }
    }

    /**
     * Getter of the character
     *
     * @return p Character
     */
    Character getPersonnage() {
        return p;
    }

    /**
     * Setter of the position XY at spawn
     */
    void spawnHeroPosition(boolean isFirstCharacterSelected) {
        if (isFirstCharacterSelected) {
            setPositionXY(32, 540.5);

        } else {
            setPositionXY(350, 540.5);

        }
    }

    /**
     * Getter of position Y
     *
     * @return the position Y of the Circle which defines the character
     */
    double getHeroPosY() {
        return p.getHero().getY();
    }

    /**
     * Getter of position X
     *
     * @return the position X of the Circle which defines the character
     */
    double getHeroPosX() {
        return p.getHero().getX();
    }
}
