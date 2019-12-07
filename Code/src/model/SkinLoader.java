import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SkinLoader {
    private ImageView skinImage;
    private int characterNumber;
    private boolean isPressing = true;


    public SkinLoader(int characterNumber) {
        this.characterNumber = characterNumber;
        skinManager();
    }

    public void skinManager() {
        if (characterNumber == 1) {
            skinImage = new ImageView(new Image("img/1.png"));
        }
    }

    public ImageView getSkinImage() {
        return skinImage;
    }
}
