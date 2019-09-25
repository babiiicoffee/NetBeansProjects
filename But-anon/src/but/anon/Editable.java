/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package but.anon;
 
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
/**
 *
 * @author but-anonju_sd2022
 */
public class Editable {
    
    public static void countWords(){
       
        
        
        String html = "<html>";
        String html2 = "<html ";
        String head = "<head>";
        String head2 = "<head ";
        String header = "<header>";
        String header2 = "<header ";
        String title = "<title>";
        String title2 = "<title ";
        String h1 = "<h1>";
        String h11 = "<h1 ";
        String h2 = "<h2>";
        String h22 = "<h2 ";
        String h3 = "<h3>";
        String h33 = "<h3 ";
        String h4 = "<h4>";
        String h44 = "<h4 ";
        String h5 = "<h5>";
        String h55 = "<h5 ";
        String h6 = "<h6>";
        String h66 = "<h6 ";
        String p = "<p>";
        String p2 = "<p ";
        String hr= "<hr>";
        String hr2= "<hr ";
        String a = "<a>";
        String a2 = "<a ";
        String ul = "<ul>";
        String  ul2 = "<ul ";
        String ol = "<ol>";
        String ol2 = "<ol ";
        String li = "<li>";
        String li2 = "<li ";
        String img = "<img>";
        String img2 = "<img ";
        String divTag = "<div>";
        String divTag2 = "<div ";
        String span = "<span>";
        String span2 = "<span ";
        String link = "<link>";
        String link2 = "<link ";
        String meta = "<meta>";
        String meta2 = "<meta ";
        String script = "<script>";
        String script2 = "<script ";
        String body = "<body>";
        String body2 = "<body ";

 
    File file = new File("Z:\\MyFile.txt");
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
 
    try {
      fis = new FileInputStream(file);
 
      // Here BufferedInputStream is added for fast reading.
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);
 
      // dis.available() returns 0 if the file does not have more lines.
      while (dis.available() != 0) {
 
      // this statement reads the line from the file and print it to
        // the console.
        System.out.println(dis.readLine());
      }
 
      // dispose all the resources after using them.
      fis.close();
      bis.close();
      dis.close();
 
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
    

