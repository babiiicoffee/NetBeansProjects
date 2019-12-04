/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageProcess;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author but-anonju_sd2082
 */
public class ImageProcessing {

    BufferedImage image;
    int width;
    int height;

    public ImageProcessing() {

        try {
            File input = new File("C:\\Users\\but-anonju_sd2082\\Documents\\NetBeansProjects\\images/flower.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            for (int i = 0; i < height; i++) {

                for (int j = 0; j < width; j++) {

                    Color c = new Color(image.getRGB(j, i));
                    Color w = new Color(255, 255, 255);
                    Color b = new Color(0, 0, 0);

                    if (c.getRGB() == b.getRGB() || c.getBlue() < 60 && c.getRed() < 60 && c.getGreen() < 50) {

                    } else {
                        image.setRGB(j, i, w.getRGB());
                    }
                }
            }

            File ouptut = new File("C:\\Users\\but-anonju_sd2082\\Documents\\NetBeansProjects\\images/processed.jpg"); // 
            ImageIO.write(image, "jpg", ouptut);
        } catch (IOException e) {
        }
    }

    static public void main(String args[]) throws Exception {
        ImageProcessing obj = new ImageProcessing();
    }
}


/* 
 try {
         
 File ouptut = new File("C:\\Users\\but-anonju_sd2082\\Documents\\NetBeansProjects\\images/processed.png");
 ImageIO.write(image, "png", ouptut);
 File input = new File("C:\\Users\\mariscalyu_SD2082\\Documents\\NetBeansProjects\\images/flower.png"); 
 image = ImageIO.read(input); // this will read the file that you take as a file input as an image
 width = image.getWidth(); // this will get the width the image
 height = image.getHeight(); // this will get the height of the image

 for (int i = 0; i < height; i++) { // 

 for (int j = 0; j < width; j++) { // 

 Color c = new Color(image.getRGB(j, i)); // 
 Color w = new Color(255,255,255);
 Color b = new Color(0,0,0);

 if (c.getRed() >= 70 || c.getGreen() >= 36 || c.getBlue() >= 236) { // 
 Color newColor = new Color(255, 255, 255); // 
 image.setRGB(j, i, newColor.getRGB()); //
 }
 else {
 image.setRGB(j, i, w.getRGB());
 }

 }
 }

 File ouptut = new File("C:\\Users\\but-anonju_sd2082\\Documents\\NetBeansProjects\\images/processed.png"); // 
 ImageIO.write(image, "jpg", ouptut); //

 */
