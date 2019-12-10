import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Character {

    private Rectangle hero;
    private SkinPosition sp;
    private CharacterPosition characterPos;
    private Consommable cons;
    private SkinLoader skin;
    private int life;

    public Character(Scene sc1) {
        this.hero = new Rectangle(50, 50);
        skin = new SkinLoader(1);
        sp = new SkinPosition(skin);

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

    public SkinLoader getSkinLoader() {
        return skin;
    }


    public SkinPosition getSp() {
        return sp;
    }

}
