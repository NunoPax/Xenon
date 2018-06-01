package org.academiadecodigo.xenon.world.interfaces;

import org.academiadecodigo.xenon.world.Direction;

public interface Controllable {
    void setDirection(Direction direction);
    void setShooting(boolean shooting);
    boolean isControllable();
}
