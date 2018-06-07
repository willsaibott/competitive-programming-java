package com.wip._1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11956 {
    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11956.class);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((line = bf.readLine()) != null)  {
            char[] program = line.toCharArray();
            byte[] memory = new byte[100];
            int pointer = 0;

            for (char inst : program)
            {
                switch (inst)
                {
                    case '+':
                        memory[pointer]++;
                        break;
                    case '-':
                        memory[pointer]--;
                        break;
                    case '>':
                        pointer = (pointer + 1) % 100;
                        break;
                    case '<':
                        pointer--;
                        if (pointer < 0)
                            pointer = 99;
                        break;
                    default:
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (byte b : memory)
            {
                sb.append(String.format("%02X ", b));
            }

            System.out.printf("Case %d: %s\n", ++k, sb.toString().trim());
        }
    }
}
