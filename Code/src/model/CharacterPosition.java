public class CharacterPosition implements PositionAbstract {
    private Personnage p;

    public CharacterPosition(Personnage p) {
        this.p=p;
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
