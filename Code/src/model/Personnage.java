import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Personnage {

    private Circle hero;
    private ImageView skin = new ImageView(new Image("img/skin1.png"));


    public Personnage() {
        this.hero = new Circle(100);
        hero.setFill(Color.PINK);
        hero.setCenterX(150);
        hero.setCenterY(150);

        skin.setY(hero.getCenterY());
        skin.setX(hero.getCenterX());
    }

    public double getPosX() {
        return hero.getCenterX();
    }

    public void setPosX(double position) {
        hero.setCenterX(position);
        skin.setX(getPosX() - (skin.getFitHeight()) / 2);
    }

    public double getPosY() {
        return hero.getCenterY();
    }

    public void setPosY(double position) {
        hero.setCenterY(position);
        skin.setY(getPosY());

    }

    public Circle getHero() {
        return hero;
    }

    public ImageView getSkin() {
        return skin;
    }
}
