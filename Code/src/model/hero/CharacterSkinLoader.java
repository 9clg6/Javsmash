package model.hero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Clement GUYON
 * CharacterSkinLoader manages images of skins
 */
class CharacterSkinLoader {
    private ImageView skinImage;
    private int characterNumber;
    private String repertory;

    /**
     * Constructor of the function which defines which skin to defines at the character
     *
     * @param characterNumber types on int defines which character is selected
     */
    CharacterSkinLoader(int characterNumber) {
        this.characterNumber = characterNumber;
        skinManager();
    }

    /**
     * skinManager set the skin depending of the characterNumber and set the repertory of the character
     */
    void skinManager() {
        if (characterNumber == 1) {
            skinImage = new ImageView(new Image("img/BombMan/Walk/1.png"));
            setRepertory("img/BombMan/");
        }
    }

    /**
     * Getter of the repertory
     *
     * @return repertory type of String
     */
    String getRepertory() {
        return repertory;
    }

    /**
     * Defines the directory of the character
     *
     * @param repertory
     */
    private void setRepertory(String repertory) {
        this.repertory = repertory;
    }

    /**
     * Getter of skinImage
     *
     * @return skinImage type of ImageView
     */
    ImageView getSkinImage() {
        return skinImage;
    }

    /**
     * setSkinImage is the setter of imageView skinImage
     *
     * @param image types of Image
     */
    void setSkinImage(Image image) {
        skinImage.setImage(image);
    }

}