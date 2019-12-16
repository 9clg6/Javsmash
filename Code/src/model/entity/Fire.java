package model.entity;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.hero.Character;

public class Fire {
    private Circle fireBall;
    private Character character;

    public Fire(Character character) {
        this.character = character;
        fireBall = new Circle();
        fireBall.setRadius(150);
        fireBall.setFill(Color.RED);
        fireBall.setOpacity(50);
        fireBall.setCenterX(character.getHero().getX());
        fireBall.setCenterY(character.getHero().getY());
    }

}
