package model.world;

import javafx.scene.shape.Circle;
import model.entity.Fire;
import model.hero.Character;
import model.hitbox.Hitbox;

import java.util.ArrayList;

public class Collision {
    private Character one, two;

    public Collision(Character one, Character two) {
        this.one = one;
        this.two = two;

    }

    public void checkCollision() {
        checkingCollision(one,two);
        checkingCollision(two,one);
        checkingCollisionEntity(one,two);
    }

    private void checkingCollision(Character one,Character two){
        if (one.getListFireBall() != null) {
            for (Fire fireball : one.getListFireBall()) {
                for (Circle circle : two.getHitbox().getCircleArrayList()) {
                    if (circle.intersects(fireball.getFireBallCircle().getBoundsInLocal())) {
                        two.setLife(-Fire.getDAMAGE());
                    }
                }
            }
        }
    }

    private void checkingCollisionEntity(Character one, Character two){
        for(Fire fire1 : one.getListFireBall()){
            for(Fire fire2 : two.getListFireBall()){
                if(fire1.getFireBallCircle().intersects(fire2.getFireBallCircle().getBoundsInLocal())){

                    one.getListFireBall().remove(fire1);
                    fire1.destruction();

                    two.getListFireBall().remove(fire2);
                    fire2.destruction();
                }
            }
        }
    }
}


