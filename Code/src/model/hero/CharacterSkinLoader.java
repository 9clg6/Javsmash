package model.hero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharacterSkinLoader {
    private ImageView skinImage;
    private int characterNumber;
    private String repertory;

    public CharacterSkinLoader(int characterNumber) {
        this.characterNumber = characterNumber;
        skinManager();
    }

    public void skinManager() {
        if (characterNumber == 1) {
            skinImage = new ImageView(new Image("img/BombMan/Walk/1.png"));
            setRepertory("img/BombMan/");
        }
    }

    public void setSkinImage(Image image) {
        skinImage.setImage(image);
    }

    private void setRepertory(String repertory) {
        this.repertory = repertory;
    }

    public String getRepertory() {
        return repertory;
    }

    public ImageView getSkinImage() {
        return skinImage;
    }

}
