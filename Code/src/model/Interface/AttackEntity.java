package model.Interface;

import javafx.scene.layout.Pane;
import model.hero.Character;
import model.manager.SkinManager;

public interface AttackEntity {
    SkinManager skin = null;
    Character character = null;
    Pane root = null;

    void initialize();

    void destruction();
}
