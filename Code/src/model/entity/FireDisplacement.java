package model.entity;

import model.animation.Sprite;

public class FireDisplacement {
    public static final int FIREBALL_MOVEMENT_ITERATOR = 10;
    public static final int MAX_RANGE_FIREBALL_VALUE = 600;
    private static final long ONE_MICRO_SECOND = 1000000;

    private long timeDisplacementFireball;
    private long time;

    private Fire fire;
    private Sprite sprite;

    /***
     * Instantiates the fireball
     *
     * @param fire current fireball
     */
    public FireDisplacement(Fire fire) {
        this.fire = fire;
        this.sprite = new Sprite(fire.getSkinManager(), "Entity");
    }

    /***
     * Methods that permits to the firewall to go forward
     *
     * @param characterScale the scale of the skin
     */
    public void goForward(double characterScale) {
        fire.getSkinManager().getSkinImage().setScaleX(characterScale);
        sprite.spriteAnimation("Forward");

        System.out.println(characterScale);

        fire.getFireballPosition().setPosXY(fire.getFireballPosition().getPosX() + FIREBALL_MOVEMENT_ITERATOR * characterScale, fire.getFireballPosition().getPosY());
    }

    /**
     * Check if an fireball is casted, if not throw new Fireball at the position of the character who attacked )
     *
     * @throws NullPointerException is thrown if any fireBall is casted
     */
    public void hasAttacked() {
        try {
            if (fire != null) {
                if (!(fire.getFireballPosition().getPosX() > fire.getCharacter().getHero().getX() + MAX_RANGE_FIREBALL_VALUE)) {
                    if (time - timeDisplacementFireball > ONE_MICRO_SECOND) {
                        goForward(fire.getCharacter().getSkin().getScaleX());
                        timeDisplacementFireball = time;
                    }
                } else {
                    isFireballNull();
                    System.gc();
                }
            }
        } catch (NullPointerException ignored) {
        }
    }

    public void setTime(long time) {
        this.time = time;
    }

    private void isFireballNull() {
        if (fire != null) {
            fire.destruction();
        }

    }
}
