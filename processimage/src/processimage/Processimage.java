/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processimage;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author but-anonju_sd2082
 */
public class Processimage {

   BufferedImage  image;
   int width;
   int height;
   
    public  Processimage() {

        try {
            File input = new File("flower.jpg"); 
            image = ImageIO.read(input); // this will read the file that you take as a file input as an image
            width = image.getWidth(); // this will get the width the image
            height = image.getHeight(); // this will get the height of the image

            for (int i = 0; i < height; i++) { // 

                for (int j = 0; j < width; j++) { // 

                    Color c = new Color(image.getRGB(j, i)); // 

                    if (c.getRed() >= 70 || c.getGreen() >= 36 || c.getBlue() >= 236) { // 
                        Color newColor = new Color(255, 255, 255); // 
                        image.setRGB(j, i, newColor.getRGB()); //
                    }

                }
            }

            File ouptut = new File("processed"); // 
            ImageIO.write(image, "jpg", ouptut); //

        } catch (IOException e) {
        }
    }

    static public void main(String args[]) throws Exception {
        Processimage obj = new Processimage();
    }
}
