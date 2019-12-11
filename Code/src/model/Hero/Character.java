package Hero;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Character {

    private Rectangle hero;
    private CharacterSkinPosition sp;
    private CharacterPosition characterPos;
    private CharacterSkinLoader skin;
    private int life;

    public Character(Scene sc1) {
        this.hero = new Rectangle(50, 50);
        skin = new CharacterSkinLoader(1);
        sp = new CharacterSkinPosition(skin);

        sp.setPosX(hero.getX());
        sp.setPosY(hero.getY());

        hero.setOpacity(0);
        characterPos = new CharacterPosition(this, sc1);
        characterPos.spawnHeroPosition();
        life = 100;

    }

    public Rectangle getHero() {
        return hero;
    }

    public ImageView getSkin() {
        return skin.getSkinImage();
    }

    public CharacterSkinLoader getSkinLoader() {
        return skin;
    }


    public CharacterSkinPosition getSp() {
        return sp;
    }

}
