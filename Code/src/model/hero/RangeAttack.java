package model.hero;

import model.entity.Fire;

class RangeAttack implements model.Interface.IAttack {
    RangeAttack(Character character) {
        doAttack(character);
    }

    private void doAttack(Character character) {
        new Fire(character);
    }
}
