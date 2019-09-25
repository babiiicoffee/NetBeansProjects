/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package but.anon;

import java.util.Scanner;

/**
 *
 * @author but-anonju_sd2022
 */
public class CountWords {

    Scanner scan = new Scanner(System.in);
    String inputWords = scan.nextLine();

    public static int count_words(String inputWords) {
        int counts = 0;
        if (!(" ".equals(inputWords.substring(0, 1))) || !(" ".equals(inputWords.substring(inputWords.length() - 1)))) {
            for (int i = 0; i < inputWords.length(); i++) {
                if(inputWords.charAt(i)== ' '){
                    
                }
            }

        }

        return counts;
    }
}
