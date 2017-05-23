package ImageGenerator;

public class FrameModel {
    public static int width;
    public static int height;
    public static int xOffset = 0;
    public static int yOffset = 0;

    public FrameModel(int width, int height){
        this.width = width;
        this.height = height;
    }


    public static void addToXOffset(int x){
        xOffset += x;
    }

    public static void addToYOffset(int y){
        yOffset += y;
    }

    public static void calculateOffSets(int totalParticles){
        xOffset = width/2 - (xOffset / totalParticles);
        yOffset = height/2 - (yOffset / totalParticles);
    }

    public static void resetOffsets(){
        xOffset = 0;
        yOffset = 0;
    }
}
