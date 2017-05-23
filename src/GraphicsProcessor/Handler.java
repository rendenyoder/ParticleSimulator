package GraphicsProcessor;

import ImageGenerator.FrameModel;
import ImageGenerator.ImageSaver;
import ParticleModel.ID;
import ParticleModel.Metal;
import ParticleModel.Particle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private List<Particle> particles;

    public Handler(){
        this.particles = new ArrayList<>();
    }

    public void tick(){
        FrameModel.resetOffsets();

        for(int i = 0; i < particles.size(); i++){
            //Create a temp particle object
            Particle tempObject = particles.get(i);
            //Compare the temp particle object to all other particles to compute gravitational pull
            for(int j = i+1; j < particles.size(); j++){
                tempObject.getFormula().setAccelFromGravityInX(tempObject, particles.get(j));
                tempObject.getFormula().setAccelFromGravityInY(tempObject, particles.get(j));

                //Allow for metals to merge
                if (tempObject instanceof Metal && particles.get(j) instanceof Metal) {
                    if (tempObject.getX() - 5 <= particles.get(j).getX() && tempObject.getX() + 5 >= particles.get(j).getX()) {
                        if (tempObject.getY() - 5 <= particles.get(j).getY() && tempObject.getY() + 5 >= particles.get(j).getY()) {
                            tempObject.setMass(tempObject.getMass() + particles.get(j).getMass());
                            tempObject.setWidth(tempObject.getWidth() + particles.get(j).getWidth());
                            tempObject.setHeight(tempObject.getHeight() + particles.get(j).getHeight());
                            removeParticle(particles.get(j));
                        }
                    }
                }
            }
            //Draw the temp particle
            tempObject.tick();
            FrameModel.addToXOffset(tempObject.getApproxX());
            FrameModel.addToYOffset(tempObject.getApproxY());
        }
        FrameModel.calculateOffSets(particles.size());
    }

    public void render(){
        BufferedImage image = new BufferedImage(FrameModel.width, FrameModel.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();

        for(Particle particle : particles){
            particle.render(graphics2D);
        }

        ImageSaver.saveFrame(image);
    }

    public boolean addParticle(Particle particle){
        return this.particles.add(particle);
    }

    public boolean removeParticle(Particle particle){
        return this.particles.remove(particle);
    }
}
