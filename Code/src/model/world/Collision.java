package model.world;

import javafx.scene.shape.Circle;
import model.entity.Fire;
import model.hero.Character;

public class Collision {
    private Character one, two;

    public Collision(Character one, Character two) {
        this.one = one;
        this.two = two;
    }

    public void checkCollision(Fire fireball, Character characterWhoAttack) {

        for (Circle circleA : one.getHitbox().getCircleArrayList()) {
            for (Circle circleB : two.getHitbox().getCircleArrayList()) {
                try {
                    if (characterWhoAttack == one) {
                        if (circleB.intersects(fireball.getFireBallCircle().getBoundsInLocal())) {
                            two.setLife(-Fire.getDAMAGE());
                        }
                    } else {
                        if (characterWhoAttack == two) {
                            if (circleA.intersects(fireball.getFireBallCircle().getBoundsInLocal())) {
                                one.setLife(-Fire.getDAMAGE());
                            }
                        }
                    }
                } catch (NullPointerException ignored) {
                }

            }
        }
    }
}


