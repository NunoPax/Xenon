package org.academiadecodigo.xenon.world;

public interface Controllable {
    void setDirection(Direction direction);
    void setShooting(boolean shooting);
    boolean isControllable();
}
