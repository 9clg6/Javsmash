package model.hero;

import javafx.scene.image.Image;

public class Sprite {
    private CharacterPosition cp;
    private int count=1, i=1;

    public Sprite(CharacterPosition cp) {
        this.cp=cp;
    }

    public void SpriteAnimation(String typeOfMovement){
        count++;
        if (count % 20 == 0) {
            if (typeOfMovement.equals("Walk")){
                if (i+1 > 14){
                    i=1;
                }
                i++;
                Image imgChange = new Image(cp.getPersonnage().getSkinLoader().getRepertory()+"Walk/"+i+".png");
                cp.getPersonnage().getSkinLoader().setSkinImage(imgChange);
            }
        }
    }

    public void SpriteReset(){
        cp.getPersonnage().getSkinLoader().setSkinImage(new Image(cp.getPersonnage().getSkinLoader().getRepertory()+"Walk/"+"1.png"));
    }
}
