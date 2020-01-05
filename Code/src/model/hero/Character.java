package model.hero;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import model.manager.SkinManager;


/**
 * @author Clement GUYON
 * Character is the most used class because it defines the composition of an Character
 */
public class Character {

    private static final int HERO_WIDTH = 50;
    private static final int HERO_HEIGHT = 50;
    private static final int OPACITY = 0;
    private Rectangle hero;
    private CharacterSkinPosition sp;
    private SkinManager skin;
    private HealPoints life;

    /**
     * Constructor which defines the circle which represents the Character, his skin and his position, his position at the spawn,
     * opacity and number of Life Points
     *
     * @param sc1 type of Scene, is the Scene where the Character will moves
     */
    public Character(Scene sc1, String characterSelected, boolean isFirstCharacterSelected) {
        this.hero = new Rectangle(HERO_WIDTH, HERO_HEIGHT);
        skin            = new SkinManager(characterSelected);
        sp              = new CharacterSkinPosition(skin);
        life = new HealPoints();

        sp.setPosX(hero.getX());
        sp.setPosY(hero.getY());
        hero.setOpacity(OPACITY);

        CharacterPosition characterPos = new CharacterPosition(this, sc1);
        characterPos.spawnHeroPosition(isFirstCharacterSelected);
    }
    /**
     * Getter of the Hero
     *
     * @return hero type of Rectangle
     */
    public Rectangle getHero() {
        return hero;
    }

    /**
     * Getter of the skin image
     *
     * @return skin type of ImageView
     */
    public ImageView getSkin() {
        return skin.getSkinImage();
    }

    /**
     * Getter of the skin manager
     *
     * @return skin type of CharacterSkinLoader
     */
    SkinManager getSkinLoader() {
        return skin;
    }

    /**
     * Getter of the CharacterSkinIPosition which defines the position of the skin
     *
     * @return sp type of skin position
     */

    CharacterSkinPosition getSp() {
        return sp;
    }

    public HealPoints getLifeStatus() {
        return life;
    }

    public void setLife(double life) {
        getLifeStatus().setHP(life);
    }
}
