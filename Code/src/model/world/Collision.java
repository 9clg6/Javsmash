package model.world;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.hero.Character;

public class Collision {
    private Character one, two;

    public Collision(Character one, Character two) {
        this.one = one;
        this.two = two;
    }

    public void secondCheckCollision() {
        for (Circle circleA : one.getHitbox().getCircleArrayList()) {
            for (Circle circleB : two.getHitbox().getCircleArrayList()) {
                if (circleA.intersects(circleB.getBoundsInLocal())) {
                    circleA.setFill(Color.GREEN);
                    circleB.setFill(Color.GREEN);
                }
            }
        }
    }

}
