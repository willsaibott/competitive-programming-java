package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main584 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = bf.readLine()) != null && !line.equals("Game Over")) {
            char[] scores = line.replace(" ", "").toCharArray();
            int points = 0, framePoint, frame;

            frame = 0;

            for (int ii = 0; ii < scores.length; ii++) {
                char score = scores[ii];

                if (score == 'X')
                {
                    framePoint = 10 + evaluateNextFrame(scores, ii + 1);
                }
                else
                {
                    framePoint = evaluateNextFrame(scores, ii);
                    ii++;
                    if (framePoint>= 10)
                    {
                        framePoint = 10 + evaluateNext(scores, ii + 1);
                    }
                }

                if (frame < 10)
                {
                    frame++;
                    points += framePoint;
                }
            }
            sb.append(points).append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }

    public static int evaluateNext(char[] scores, int ii)
    {
        if (ii >= scores.length) return 0;
        return (scores[ii] >= '0' && scores[ii] <= '9' ? scores[ii] - '0' : 10 );
    }

    public static int evaluateNextFrame(char[] scores, int ii)
    {
        int first  = evaluateNext(scores, ii);
        int second = evaluateNext(scores, ii + 1);

        return first < 10 ? Math.min(10, first + second) : first + second;
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA584 {

    final static String packName = UVA584.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA584.class, chapter);
        Main584.main(args);
    }
}