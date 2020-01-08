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
    private long TimeInitOfJump;
    private long TimeOfTheJumpInstant_i;
    private float TimeOfTheJumpInstant_i_float;

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
        p.getHitbox().updateXY();

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
        p.getHitbox().updateXY();

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
    public Character getPersonnage() {
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
        p.getHitbox().updateXY();
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

    /**
     * Getter of number of jump
     *
     * @return the number of jump of the character
     */
    int getNbJump() {
        return nbJump;
    }

    /**
     * Set a new number of jump for a character
     *
     * @param nbJump int
     */
    void setNbJump(int nbJump) {
        this.nbJump = nbJump;
    }

    /**
     *
     * @return is the character is jumping or not
     */
    boolean isJumping() {
        return isJumping;
    }

    /**
     * Set if the character is jumping or not
     *
     * @param jumping boolean
     */
    void setJumping(boolean jumping) {
        this.isJumping = jumping;
    }

    /**
     *
     * @return the time when the character had started the jump (nanosecond)
     */
    long getTimeInitOfJump() {
        return TimeInitOfJump;
    }

    /**
     * Change the time initial when the character start his jump (nanosecond)
     *
     * @param timeInitOfJump long
     */
    void setTimeInitOfJump(long timeInitOfJump) {
        this.TimeInitOfJump = timeInitOfJump;
    }

    /**
     *
     * @return during how many time the character is on his jump (nanosecond)
     */
    long getTimeOfTheJumpInstant_i() {
        return TimeOfTheJumpInstant_i;
    }

    /**
     * Change during how many time the jump has started (nanosecond)
     *
     * @param timeOfTheJumpInstant_i long
     */
    void setTimeOfTheJumpInstant_i(long timeOfTheJumpInstant_i) {
        this.TimeOfTheJumpInstant_i = timeOfTheJumpInstant_i;
    }

    /**
     *Time used in the function of the jump
     * @return during how many time the character is on his jump (second)
     */
    float getTimeOfTheJumpInstant_i_float() {
        return TimeOfTheJumpInstant_i_float;
    }

    /**
     * Change during how many time the jump has started (second)
     * Time used in the function of the jump
     *
     * @param timeOfTheJumpInstant_i_float float
     */
    void setTimeOfTheJumpInstant_i_float(float timeOfTheJumpInstant_i_float) {
        this.TimeOfTheJumpInstant_i_float = timeOfTheJumpInstant_i_float;
    }
}

