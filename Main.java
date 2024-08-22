import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static int newWidth = 3000;

    public static void main(String[] args) {
        String srcFolder = "/Users/a1/Desktop/src";
        String dstFolder = "/Users/a1/Desktop/dst";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        if (files == null) {
            System.out.println("Source directory is empty or does not exist.");
            return;
        }

        long start = System.currentTimeMillis();
        int numThreads = 8;
        int filesPerThread = files.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * filesPerThread;
            int endIndex = (i == numThreads - 1) ? files.length : startIndex + filesPerThread;
            File[] filesSubset = new File[endIndex - startIndex];
            System.arraycopy(files, startIndex, filesSubset, 0, filesSubset.length);

            ImageResizer resizer = new ImageResizer(filesSubset, newWidth, dstFolder, start);
            new Thread(resizer).start();
        }
    }
}


//    public static int newWidth = 3000;
//    public static void main(String[] args) {
//        String srcFolder = "//Users/a1/Desktop/src";
//        String dstFolder = "/Users/a1/Desktop/dst";
//
//        File srcDir = new File(srcFolder);
//
//        long start = System.currentTimeMillis();
//
//        File[] files = srcDir.listFiles();
//        int middle = files.length / 8;
//
//       File[] files1 = new File[middle];
//        System.arraycopy (files,  0, files1, 0, files1.length);
//        ImageResizer resizer1 = new ImageResizer(files1,newWidth, dstFolder, start);
//        new Thread(resizer1).start();
//
//
//       File[] files2 = new File[files.length-middle];
//        System.arraycopy (files,  0, files2, 0, files2.length);
//        ImageResizer resizer2 = new ImageResizer(files2,newWidth, dstFolder, start);
//        new Thread(resizer2).start();
//
//
//
//        File[] files3 = new File[files2.length-middle];
//        System.arraycopy (files,  0, files3, 0, files3.length);
//        ImageResizer resizer3 = new ImageResizer(files3,newWidth, dstFolder, start);
//        new Thread(resizer3).start();
//
//
//        File[] files4 = new File[files3.length-middle];
//        System.arraycopy (files,  0, files4, 0, files4.length);
//        ImageResizer resizer4 = new ImageResizer(files4,newWidth, dstFolder, start);
//        new Thread(resizer4).start();
//
//
//        File[] files5 = new File[files4.length-middle];
//        System.arraycopy (files,  0, files5, 0, files5.length);
//        ImageResizer resizer5 = new ImageResizer(files5,newWidth, dstFolder, start);
//        new Thread(resizer5).start();
//
//
//        File[] files6 = new File[files5.length - middle];
//        System.arraycopy (files,  0, files6, 0, files6.length);
//        ImageResizer resizer6 = new ImageResizer(files6,newWidth, dstFolder, start);
//        new Thread(resizer6).start();
//
//
//        File[] files7 = new File[files6.length - middle];
//        System.arraycopy (files,  0, files7, 0, files7.length);
//        ImageResizer resizer7 = new ImageResizer(files7,newWidth, dstFolder, start);
//        new Thread(resizer7).start();
//
//
//        File[] files8 = new File[files7.length - middle];
//        System.arraycopy (files,  0, files8, 0, files8.length);
//        ImageResizer resizer8 = new ImageResizer(files8,newWidth, dstFolder, start);
//        new Thread(resizer8).start();
//
//    }
//}
