
import java.awt.image.BufferedImage;
import java.io.File;
import org.imgscalr.Scalr;
import javax.imageio.ImageIO;

import static org.imgscalr.Scalr.Method.SPEED;
public class BufferedImageResizer implements Runnable {
    private File[] files;
    private int newWidth;
    private String dstFolder;
    long start;

    public BufferedImageResizer(File[] files, int newWidth, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {

        try
        {
            for(File file : files)
            {
                BufferedImage image = ImageIO.read(file);
                if(image == null) {
                    continue;
                }

                int newWidth = 1024;
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage scaledImage = Scalr.resize(image, SPEED, newWidth, newHeight);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(scaledImage, "jpg", newFile);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
