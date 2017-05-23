package GraphicsProcessor;

import GalaxyCreator.EllipticalGalaxyCreator;
import ImageGenerator.FrameModel;
import ParticleModel.Gas;
import ParticleModel.ID;
import VideoWriter.JpegImagesToMovie;

public class ParticleDrawer {
    private Handler handler;
    private FrameModel frame;

    public ParticleDrawer(int width, int height){
        this.handler = new Handler();
        this.frame = new FrameModel(width, height);

        EllipticalGalaxyCreator ellipticalGalaxyCreator = new EllipticalGalaxyCreator();
        ellipticalGalaxyCreator.create(handler, 300, 300, 75, 300);
        ellipticalGalaxyCreator.create(handler, width-300, height-300, 75, 300);
    }


    public void runSimulation(int x){
        //Run simulation for specified amount of times
        for(int i = 0; i < x; i++) {
            handler.tick();
            handler.render();
        }
    }


    public static void main(String[] args){
        ParticleDrawer particleDrawer = new ParticleDrawer(800, 800);
        particleDrawer.runSimulation(2000);
        JpegImagesToMovie.renderMovie(FrameModel.width, FrameModel.height, 60);
    }
}
