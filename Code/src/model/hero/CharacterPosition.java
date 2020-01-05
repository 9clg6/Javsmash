package model.hero;

import javafx.scene.Scene;

/**
 * @author Clement GUYON
 * CharacterPosition manages the position of the character
 */
public class CharacterPosition implements model.Interface.IPosition {
    public static final int SECONDCHARACTER_POS_X_AT_SPAWN = 350;
    public static final double SECONDCHARACTER_POS_Y_AT_SPAWN = 540.5;
    private static final int ZERO = 0;
    private static final int LEFT_MAP_LIMIT = 32;
    private static final int RIGHT_MAP_LIMIT = 64;
    private static final int VERTICAL_BOTTOM_LIMIT = 52;
    private static final int FIRSTCHARACTER_POS_X_AT_SPAWN = 32;
    private static final double FIRSTCHARACTER_POS_Y_AT_SPAWN = 540.5;
    private Character p;
    private Scene s1;
    private int nbJump = ZERO;
    private boolean isJumping = false;
    private long timeInit;
    private long ti;
    private float tiFloat;

    /**
     * Constructor
     *
     * @param p  defines the character
     * @param s1 defines the scene
     */
    public CharacterPosition(Character p, Scene s1) {
        this.p = p;
        this.s1 = s1;

        setPositionXY(p.getHero().getX(), p.getHero().getY());
    }

    /**
     * Setter of position X and Y
     *
     * @param posX type of double
     * @param posY type of double
     */
    private void setPositionXY(double posX, double posY) {
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

        if (p.getHero().getX() < LEFT_MAP_LIMIT) {
            p.getHero().setX(s1.getWidth() - s1.getWidth() + LEFT_MAP_LIMIT);
        }
        if (p.getHero().getX() > s1.getWidth() - RIGHT_MAP_LIMIT) {
            p.getHero().setX(s1.getWidth() - RIGHT_MAP_LIMIT);
        }

    }

    /**
     * Setter of the position Y of the character
     *
     * @param position type of double
     */
    public void setPosY(double position) {
        if (!(p.getHero().getY() + position > s1.getHeight() - VERTICAL_BOTTOM_LIMIT)) {
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
            setPositionXY(FIRSTCHARACTER_POS_X_AT_SPAWN, FIRSTCHARACTER_POS_Y_AT_SPAWN);

        } else {
            setPositionXY(SECONDCHARACTER_POS_X_AT_SPAWN, SECONDCHARACTER_POS_Y_AT_SPAWN);
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

    int getNbJump() {
        return nbJump;
    }

    void setNbJump(int nbJump) {
        this.nbJump = nbJump;
    }

    boolean isJumping() {
        return isJumping;
    }

    void setJumping(boolean jumping) {
        this.isJumping = jumping;
    }

    long getTimeInit() {
        return timeInit;
    }

    void setTimeInit(long timeInit) {
        this.timeInit = timeInit;
    }

    long getTi() {
        return ti;
    }

    void setTi(long ti) {
        this.ti = ti;
    }

    float getTiFloat() {
        return tiFloat;
    }

    void setTiFloat(float tiFloat) {
        this.tiFloat = tiFloat;
    }
}

