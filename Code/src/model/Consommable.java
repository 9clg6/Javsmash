import javafx.scene.Scene;
import javafx.scene.shape.Circle;

public class Consommable extends Objet {
    private static Circle circle;
    private int addlife;



    public Consommable(Scene sc1){
        addlife = 30;
        this.circle = new Circle(25);
        circle.setCenterX(300);
        circle.setCenterY(sc1.getHeight()-30);
    }

    public static Circle getCircle(){
        return circle;
    }

}
