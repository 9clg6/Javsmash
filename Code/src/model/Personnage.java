import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Personnage {

    private Circle hero;
    private ImageView skin = new ImageView(new Image("img/skin1.png"));
    private SkinPosition sp;

    public Personnage() {
        this.hero = new Circle(25);
        hero.setOpacity(0);

        sp =new SkinPosition(skin);

        hero.setCenterX(100);
        hero.setCenterY(100);

        skin.setX(100-29);
        skin.setY(100-29);
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
