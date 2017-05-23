package ParticleModel;
import ImageGenerator.FrameModel;
import Physics.Formula;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Particle {
    //Formula object
    protected Formula formula = new Formula();
    //Protect object variables
    protected int pId = new Random().nextInt(1000000);
    protected double x, y;
    protected double velX, velY;

    protected int approxX, approxY;
    protected int mass;
    protected ID id;
    //Object image variables
    protected int width, height;
    protected BufferedImage characterImage;

    //Constructor
    public Particle(double x, double y, int width, int height, ID id){
        //Set variables
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
    }

    //Tick and render functions
    public abstract void tick();
    public abstract void render(Graphics graphics);

    //Getters

    public Formula getFormula() { return formula; }
    public double getX() {return x;}
    public double getY() {return y;}
    public double getVelX() {return velX;}
    public double getVelY() {return velY;}
    public int getApproxX() { return approxX; }
    public int getApproxY() { return approxY; }
    public int getMass() { return mass; }
    public ID getId() {return id;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public BufferedImage getCharacterImage() {return characterImage;}

    //Setters

    public void setFormula(Formula formula) { this.formula = formula; }
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setVelX(double velX) {this.velX = velX;}
    public void setVelY(double velY) {this.velY = velY;}
    public void setMass(int mass) { this.mass = mass; }
    public void setId(ID id) {this.id = id;}
    public void setWidth(int width) {this.width = width;}
    public void setHeight(int height) {this.height = height;}
    public void setCharacterImage(BufferedImage characterImage) {this.characterImage = characterImage;}


    public void addToVelX(double addition) { this.velX += addition; }
    public void addToVelY(double addition) { this.velY += addition; }


    //Keeps particle within given bounds
    public void clamp(){
        if(FrameModel.width-width <= getX() || getX() <= 0) {
            if(FrameModel.width-width <= getX()){
                setX(FrameModel.width-width);
            } else {
                setX(1);
            }
            if(this.getId() != ID.Metal) {
                setVelX(getVelX() * -1);
            }
        }

        if(FrameModel.height-(height+20) <= getY() || getY() <= 0) {
            if(FrameModel.height-(height+20) <= getY()){
                setY(FrameModel.height-(height+20));
            } else {
                setY(1);
            }
            if(this.getId() != ID.Metal) {
                setVelY(getVelY() * -1);
            }
        }
    }


    @Override
    public boolean equals(Object obj) {
        if(this.getClass() == obj.getClass()){
            Particle other = (Particle) obj;
            return this.getX() == other.getX() && this.getY() == other.getY() && this.pId == other.pId;
        }
        return false;
    }
}
