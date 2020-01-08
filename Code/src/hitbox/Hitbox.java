package hitbox;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Hitbox {

    private static final int RADIUS = 20;
    private Pane root;
    private Rectangle hero;
    private ArrayList<Circle> circleArrayList;
    private Circle topRightHandCorner, topLeftHandCorner, bottomRightHandCorner, bottomLeftHandCorner, middleRight, middleLeft, middleTop, middleBottom;

    public Hitbox(Rectangle hero) {
        this.hero = hero;
        initializeHitbox();
        addToParentGroup();
        setPosition();
    }

    private void addToParentGroup() {
        root.getChildren().addAll(circleArrayList);
    }

    private void setPosition() {
        topLeftHandCorner.setCenterX(hero.getX());
        topLeftHandCorner.setCenterY(hero.getY());
    }

    private void initializeHitbox() {
        circleArrayList = new ArrayList<>();

        initializeCircle();
        initializeArrayList();
    }

    private void initializeCircle() {
        topLeftHandCorner = new Circle(RADIUS, Color.RED);
        topRightHandCorner = new Circle(RADIUS, Color.RED);
        bottomLeftHandCorner = new Circle(RADIUS, Color.RED);
        bottomRightHandCorner = new Circle(RADIUS, Color.RED);
        middleRight = new Circle(RADIUS, Color.RED);
        middleLeft = new Circle(RADIUS, Color.RED);
        middleTop = new Circle(RADIUS, Color.RED);
        middleBottom = new Circle(RADIUS, Color.RED);
    }

    private void initializeArrayList() {
        circleArrayList.add(topLeftHandCorner);
        circleArrayList.add(topRightHandCorner);
        circleArrayList.add(bottomLeftHandCorner);
        circleArrayList.add(bottomRightHandCorner);
        circleArrayList.add(middleLeft);
        circleArrayList.add(middleRight);
        circleArrayList.add(middleBottom);
        circleArrayList.add(middleTop);
    }

    public ArrayList<Circle> getCircleArrayList() {
        return circleArrayList;
    }


}
