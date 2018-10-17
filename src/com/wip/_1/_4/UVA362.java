package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main362 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        int totalBytes, k = 0, remainingBytes, bytes, time, temp;

        totalBytes = Integer.parseInt(bf.readLine());
        while (totalBytes > 0)
        {
            time = temp = 0;
            remainingBytes = totalBytes;

            sb.append("Output for data set ")
               .append(++k)
               .append(", ")
               .append(totalBytes)
               .append(" bytes:\n");

            do
            {
                line = bf.readLine();
                bytes = Integer.parseInt(line);
                time++;

                temp += bytes;
                remainingBytes -= bytes;

                if (time % 5 == 0)
                {

                    sb.append("   ");

                    if (temp == 0)
                    {
                        sb.append("Time remaining: stalled\n");
                    }
                    else
                    {
                        sb.append("Time remaining: ")
                          .append((int)Math.ceil(remainingBytes*5.0 / temp))
                          .append(" seconds\n");
                    }

                    temp = 0;
                }

                if (remainingBytes <= 0)
                {
                    sb.append("Total time: ")
                            .append(time)
                            .append(" seconds\n\n");
                    break;
                }

            } while (true);

            totalBytes = Integer.parseInt(bf.readLine());
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA362 {

    final static String packName = UVA362.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA362.class, chapter);
        Main362.main(args);
    }
}