import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Personnage {

    private static ImageView skin = new ImageView(new Image("img/skin1.png"));
    private Rectangle hero;
    private SkinPosition sp;
    private CharacterPosition characterPos;
    private Consommable cons;
    private int life;

    public Personnage(Scene sc1) {
        this.hero = new Rectangle(50, 50);
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
        return skin;
    }

    public SkinPosition getSp() {
        return sp;
    }

}
