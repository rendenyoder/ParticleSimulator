package ParticleModel;

import ImageGenerator.FrameModel;

import java.awt.*;
import java.util.Random;

public class Metal extends Particle {

    //Gas constructor
    public Metal(double x, double y, int width, int height, ID id){
        //Call particle constructor
        super(x,y,width,height,id);
        //Assign mass
        this.mass = 7000;
        //Give random velocity at creation
        Random r = new Random();


    }

    //Changes to player overtime
    public void tick(){
        x += velX;
        y += velY;
        approxX = (int)(x > 0 ? Math.floor(x) : Math.ceil(x));
        approxY = (int)(y > 0 ? Math.floor(y) : Math.ceil(y));
        //clamp();
    }

    //Render player graphics
    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillOval(approxX + FrameModel.xOffset, approxY + FrameModel.yOffset, width, height);
    }

}