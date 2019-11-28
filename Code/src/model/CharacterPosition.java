import javafx.scene.Scene;

public class CharacterPosition implements PositionAbstract {
    private Personnage p;
    private Scene s1;


    public CharacterPosition(Personnage p, Scene s1) {
        this.p=p;
        this.s1 = s1;
    }

    public void setPosX(double position) {
        p.getHero().setCenterX(position);
        p.getSp().updatePosSkinX(this);
    }

    public void setPosY(double position) {
        p.getHero().setCenterY(position);
        p.getSp().updatePosSkinY(this);
    }

    protected double getHeroPosY() {
        return p.getHero().getCenterY();
    }

    protected double getHeroPosX() {
        return p.getHero().getCenterX();
    }
}
