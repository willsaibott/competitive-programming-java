package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main647 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String line;
        byte[] diceRows = new byte[1000];

        for (int ii = 0; ii < 1000; ii++) {
            diceRows[ii] = Byte.parseByte(st.nextToken());

            if (diceRows[ii] == 0) break;

            if (!st.hasMoreTokens())
            {
                st = new StringTokenizer(bf.readLine());
            }
        }

        while ((line = bf.readLine()) != null && !line.equals("0"))
        {
            int players = Integer.parseInt(line);
            HashMap<Integer, Integer> chutesLatters = new HashMap();
            HashSet<Integer> loseExtraTurns = new HashSet();

            while ((line = bf.readLine()) != null && !line.equals("0 0"))
            {
                st = new StringTokenizer(line);
                chutesLatters.put(Integer.parseInt(st.nextToken()),
                                  Integer.parseInt(st.nextToken()));
            }

            while ((line = bf.readLine()) != null && !line.equals("0"))
            {
                st = new StringTokenizer(line);
                loseExtraTurns.add(Integer.parseInt(st.nextToken()));
            }

            int winner = play(players, chutesLatters, loseExtraTurns, diceRows);
            System.out.println(winner);
        }
    }

    private static int play(int players,
                            HashMap<Integer,Integer> chutesLatters,
                            HashSet<Integer> loseExtraTurns,
                            byte[] diceRows)
    {
        int[] pos = new int[players];
        int winner = -1;
        int player = 0;
        int row = 0;
        Integer jump;
        HashSet<Integer> blocked = new HashSet<>();

        while (winner < 0)
        {
            if (pos[player] + diceRows[row] == 100)
            {
                winner = player + 1;
                break;
            } else if (pos[player] + diceRows[row] < 100)
            {
                pos[player] += diceRows[row++];

                if (loseExtraTurns.contains(pos[player]))
                {
                    continue;
                }
                else if (loseExtraTurns.contains(-pos[player]))
                {
                    blocked.add(player);
                }
                else if ((jump = chutesLatters.get(pos[player])) != null)
                {
                    pos[player] = jump;
                }
            }


            do {
                player = (player + 1) % players;

                if(blocked.contains(player))
                {
                    blocked.remove(player);
                }
                else
                {
                    break;
                }
            } while (true);
        }

        return winner;
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA647 {

    final static String packName = UVA647.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA647.class, chapter);
        Main647.main(args);
    }
}