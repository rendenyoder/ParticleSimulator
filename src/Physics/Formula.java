package Physics;

import ParticleModel.Particle;

public class Formula {
    private static double G = 0.0000000000667;
    private static double FAKE_G = 0.000067;

    public void setAccelFromGravityInX(Particle a, Particle b){
        double distance = b.getX() - a.getX();
        if(distance >= 1 || distance <= -1) {
            double force = (FAKE_G * a.getMass() * b.getMass()) / distance;
            a.addToVelX(force / a.getMass());
            b.addToVelX(force / b.getMass() * -1);
        }
    }


    public void setAccelFromGravityInY(Particle a, Particle b){
        double distance = b.getY() - a.getY();
        if(distance >= 1 || distance <= -1) {
            double force = (FAKE_G * a.getMass() * b.getMass()) / distance;
            a.addToVelY(force / a.getMass());
            b.addToVelY(force / b.getMass() * -1);
        }
    }

}
