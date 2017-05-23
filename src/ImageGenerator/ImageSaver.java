package ImageGenerator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageSaver{
    public static int NUM_OF_FRAMES = 0;
    public static File folder = new File("./img");

    public static void saveFrame(BufferedImage image){
        try {
            ImageIO.write(image, "jpg", new File(folder.getName() + "/" + NUM_OF_FRAMES + ".jpg"));
            NUM_OF_FRAMES++;
        }catch (Exception e){
            System.out.println("cant save image");
        }
    }

}
