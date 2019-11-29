import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class Personnage {

    private Circle hero;
    private ImageView skin = new ImageView(new Image("img/skin1.png"));
    private SkinPosition sp;

    public Personnage(Scene sc1) {
        this.hero = new Circle(25);
        hero.setOpacity(0);

        sp =new SkinPosition(skin);

        hero.setCenterX(200);
        hero.setCenterY(sc1.getHeight() - 75);


        skin.setX(hero.getCenterX() - 29);
        skin.setY(hero.getCenterY() - 29);
    }

    public Circle getHero() {
        return hero;
    }

    public ImageView getSkin() {
        return skin;
    }

    public SkinPosition getSp() {
        return sp;
    }
}
