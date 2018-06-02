package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.World;

public class Explosion extends GameObject {
    private World world;
    private int counter;

    public Explosion(World world) {
        super(64, 64, "/res/firecloud.png");
        this.counter = 6;
        this.world = world;
    }

    @Override
    public void tick() {
        if (counter <= 0) {
            this.dispose();
        }

        counter--;
        super.tick();
    }

    @Override
    public void reset(int x, int y) {
        super.reset(x, y);
        this.counter = 3;
        this.world.add(this);
        this.show();
    }

    @Override
    public void dispose() {
        super.dispose();
        this.world.remove(this);
    }
}
