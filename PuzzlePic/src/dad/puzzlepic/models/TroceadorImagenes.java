package dad.puzzlepic.models;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TroceadorImagenes {
	
	

	public File[] trocearFoto(File file, int nivel) throws IOException {       
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis); //reading the image file

        int rows = nivel; //You should decide the values for rows and cols variables
        int cols = nivel;
        int chunks = rows * cols;

        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                //Initialize the image array with image chunks
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                // draws the image chunk
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
        System.out.println("Splitting done");
        File[] fotos = new File[rows*cols];
        //writing mini images into image files
        for (int i = 0; i < imgs.length; i++) {
        	fotos[i] = new File("PuzzlePic/src/dad/puzzlepic/resources/troceadas/" + i + file.getName());
            ImageIO.write(imgs[i], "jpg", fotos[i]);
        }
        System.out.println("Mini images created");
        
        return fotos;
	}
}
