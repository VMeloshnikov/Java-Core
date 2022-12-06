
import java.io.File;


public class Main {
    private static final int newWidth = 1024;


    public static void main(String[] args) {

        int i = Runtime.getRuntime().availableProcessors();
        String srcFolder = "C://Users/vproh/Pictures/scr";
        String dstFolder = "C://Users/vproh/Pictures/dst";
        long start = System.currentTimeMillis();
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();


        assert files != null;
        int mid = files.length / i;
        int startPos = 0;

        try {
            for (int j = 0; j < mid - 2; j++) {
                if ((mid * j + mid) < files.length) {
                    File[] nameMass = new File[mid];
                    int count = nameMass.length;
                    System.arraycopy(files, startPos, nameMass, 0, count);
                    BufferedImageResizer bufferedImageResizer = new BufferedImageResizer(nameMass, newWidth, dstFolder, start);
                    new Thread(bufferedImageResizer).start();
                }
                if (((mid * j + mid) > files.length) & (mid * j < files.length)) {
                    int count = files.length - (j * mid);
                    File[] nameMass = new File[count];
                    System.arraycopy(files, startPos, nameMass, 0, count);
                    BufferedImageResizer bufferedImageResizer = new BufferedImageResizer(nameMass, newWidth, dstFolder, start);
                    new Thread(bufferedImageResizer).start();
                }
                startPos += mid;

                ImageResizer resizer = new ImageResizer(files, newWidth, dstFolder, start);
                new Thread(resizer).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("num core: " + i);
        System.out.println(files.length);

    }

}
