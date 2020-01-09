package model.entity;

import animation.Sprite;

public class FireDisplacement {
    public static final int FIREBALL_MOVEMENT_ITERATOR = 10;

    private Fire fire;
    private Sprite sprite;


    public FireDisplacement(Fire fire) {
        this.fire = fire;
        this.sprite = new Sprite(fire.getSkinManager(), "Entity");
    }

    public void goForward() {
        sprite.spriteAnimation("Forward");
        fire.getFireballPosition().setPosXY(fire.getFireballPosition().getPosX() + FIREBALL_MOVEMENT_ITERATOR, fire.getFireballPosition().getPosY());
    }
}
