package model.manager;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Clement GUYON
 * CharacterSkinLoader manages images of skins
 */
public class SkinManager {
    private ImageView skinImage;
    private String repertory;

    /**
     * Constructor of the function which defines which skin to defines at the character
     *
     * @param entity types on int defines which character is selected
     */
    public SkinManager(String entity) {
        skinManager(entity);
    }

    /**
     * skinManager set the skin depending of the characterNumber and set the repertory of the character
     */
    private void skinManager(String entity) {
        if (entity.equals("Clement")) {
            skinImage = new ImageView(new Image("img/BombMan/Walk/1.png"));
            setRepertory("img/BombMan/");
        }
        if (entity.equals("Maxime")) {
            skinImage = new ImageView(new Image("img/Cucumber/Walk/1.png"));
            setRepertory("img/Cucumber/");
        }
        if (entity.equals("Fireball")) {
            skinImage = new ImageView(new Image("img/Fireball/1.png"));
            setRepertory("img/Fireball/");
        }
    }

    /**
     * Getter of the repertory
     *
     * @return repertory type of String
     */
    public String getRepertory() {
        return repertory;
    }

    /**
     * Defines the directory of the character
     *
     * @param repertory is the name of the repertory
     */
    private void setRepertory(String repertory) {
        this.repertory = repertory;
    }

    /**
     * Getter of skinImage
     *
     * @return skinImage type of ImageView
     */
    public ImageView getSkinImage() {
        return skinImage;
    }

    /**
     * setSkinImage is the setter of imageView skinImage
     *
     * @param image types of Image
     */
    public void setSkinImage(Image image) {
        skinImage.setImage(image);
    }

}
