package GalaxyCreator;

import GraphicsProcessor.Handler;
import ParticleModel.Gas;
import ParticleModel.ID;
import ParticleModel.Metal;

import java.util.Random;

public class EllipticalGalaxyCreator extends Galaxy{

    @Override
    public void create(Handler handler, int x, int y, int radius, int numOfParticles) {
        Random r = new Random();
        for(int i = 0; i < numOfParticles; i++) {
            int rad = r.nextInt(radius);
            int angle = r.nextInt(360);
            int xCoord = (int)(Math.cos(angle) * rad);
            int yCoord = (int)(Math.sin(angle) * rad);
            handler.addParticle(new Gas(x + (xCoord), y + (yCoord), 3, 3, ID.Gas));
        }
        handler.addParticle(new Metal(x, y, 10, 10, ID.Metal));
    }
}
