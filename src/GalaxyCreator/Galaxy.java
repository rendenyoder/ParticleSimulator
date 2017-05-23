package GalaxyCreator;

import GraphicsProcessor.Handler;

public abstract class Galaxy {
    public abstract void create(Handler handler, int x, int y, int radius, int numOfParticles);
}
