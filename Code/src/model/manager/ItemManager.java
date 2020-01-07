package model.manager;

import javafx.scene.layout.Pane;
import model.items.Apple;
import model.items.Consumable;

public class ItemManager {
    private Pane root;
    private long time, oneSecond = 1000000000;


    public ItemManager(Pane root) {
        this.root=root;

    }

    public void spawnItem(long l) {

        if(time-l > oneSecond*5){
            Appears();
        }



    }

    public void Appears(){

        Apple app = new Apple();
        //app.setPos(Math.random()*100%500,Math.random()*100%400);
        //root.getChildren().addAll(app);
    }
}
