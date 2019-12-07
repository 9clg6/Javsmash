import javafx.scene.Scene;

public class CharacterPosition implements PositionAbstract {
    private Personnage p;
    private Scene s1;


    public CharacterPosition(Personnage p, Scene s1) {
        this.p = p;
        this.s1 = s1;
    }

    public void setPositionXY(double posX, double posY) {
        setPosX(posX);
        setPosY(posY);
    }

    public void setPosX(double position) {
        if (p.getHero().getX() < 32) {
            p.getHero().setX(s1.getWidth() - s1.getWidth() + 32);
        }
        p.getHero().setX(p.getHero().getX() + position);
        p.getSp().updatePosSkinX(this);
    }

    public void setPosY(double position) {
        if (!(p.getHero().getY() + position > s1.getHeight() - 52)) {
            p.getHero().setY(p.getHero().getY() + position);
            p.getSp().updatePosSkinY(this);
        }
    }

    public Personnage getPersonnage() {
        return p;
    }

    public void spawnHeroPosition() {
        setPositionXY(32, 540.5);
    }

    protected double getHeroPosY() {
        return p.getHero().getY();
    }

    protected double getHeroPosX() {
        return p.getHero().getX();
    }
}
