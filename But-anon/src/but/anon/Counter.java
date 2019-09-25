package but.anon;

import java.util.Scanner;

/**
 *
 * @author but-anonju_sd2022
 */
public class Counter {

    public static void countWords() {

        String html = "<html>";
        String html2 = "<html";
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
        String hr = "<hr>";
        String hr2 = "<hr ";
        String a = "<a>";
        String a2 = "<a ";
        String ul = "<ul>";
        String ul2 = "<ul ";
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

        Scanner reader = new Scanner(System.in);
        System.out.println("Please Enter HTML File Below : ");
        String n = reader.nextLine();
        String[] tags = n.split(" ");
        int countHtml = 0;
        int countHead = 0;
        int countHeader = 0;
        int countTitle = 0;
        int countH1 = 0;
        int countH2 = 0;
        int countH3 = 0;
        int countH4 = 0;
        int countH5 = 0;
        int countH6 = 0;
        int countP = 0;
        int countHr = 0;
        int countA = 0;
        int countUl = 0;
        int countOl = 0;
        int countLi = 0;
        int countImg = 0;
        int countDiv = 0;
        int countSpan = 0;
        int countLink = 0;
        int countMeta = 0;
        int countScript = 0;
        int countBody = 0;

        for (String tag : tags) {
            switch (tag) {
                case "<html>":
            }
            if ((tag.equals(html)) || (tag.equals(html2))) {
                countHtml++;
//            }
            }
            System.out.println(countHtml);
        }

    }
}
//  <html> <html> <html> <html> <html> <li> <html> <li> <li> <html> <li> <html <html <html
