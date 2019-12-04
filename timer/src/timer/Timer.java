/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author but-anonju_sd2082
 */
public class Timer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        boolean x = true;
        long displayMinutes = 0;
        long starttime = System.currentTimeMillis();
        System.out.println("Timer:");
        while (x) {
            TimeUnit.SECONDS.sleep(1);
            long timepassed = System.currentTimeMillis() - starttime;
            long secondspassed = timepassed / 1000;
            if (secondspassed == 60) {
                secondspassed = 0;
                starttime = System.currentTimeMillis();
            }
            if ((secondspassed % 60) == 0) {
                displayMinutes++;
            }

            System.out.println(displayMinutes + "::" + secondspassed);
        }

    }

}
