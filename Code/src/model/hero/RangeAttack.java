package model.hero;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import model.entity.Fire;


class RangeAttack implements model.Interface.IAttack {

    private Pane root;

    RangeAttack(Character character, Pane root) {
        doAttack(character,root);
    }

    private void doAttack(Character character,Pane root) {
        new Fire(character,root);
    }
}
