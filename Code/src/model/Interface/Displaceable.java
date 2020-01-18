package model.Interface;

import model.hero.CharacterPosition;

public interface Displaceable {

    boolean movingLR(CharacterPosition positionable, boolean isMovingL, boolean isMovingR, long TimeSinceLastDisplacement);

    void moving(long l);

    void swapScale(CharacterPosition characterPosition);
}
