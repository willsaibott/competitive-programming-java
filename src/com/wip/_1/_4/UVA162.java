package com.wip._1._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA162 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA162.class, "1.4");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        while ((line = bf.readLine()) != null && !line.equals("#")) {
            StringBuilder sb = new StringBuilder(line).append(" " + bf.readLine()).append(" " + bf.readLine()).append(" " + bf.readLine());
            String[] cards = sb.toString().split(" ");
            Stack<Character>[] heaps = new Stack[2];
            Stack<Character> temp = new Stack<Character>();
            int winner = -1;
            int p = 1;
            count = 0;

            heaps[0] = new Stack<>();
            heaps[1] = new Stack<>();

            for (int ii = 1; ii <= 52; ii++)
            {
                heaps[ii & 1].push(cards[ii - 1].charAt(1));
            }

            while (winner == -1)
            {
                int next = (p + 1) & 1;
                char card = pickCard(heaps[p]);
                if (card == '\0')
                {
                    winner = next;
                    break;
                }

                temp.push(card);
                int next2 = next, p2 = p;

                if (count > 0)
                {
                    do
                    {
                        card = pickCard(heaps[next2]);
                        if (card == '\0')
                        {
                            winner = p2;
                            break;
                        }
                        temp.push(card);

                        if (card - '0' > 9 && card != 'T')
                        {
                            next2 = (next2 + 1) & 1;
                            p2 = (p2 + 1) & 1;
                        }
                    } while (count > 0);

                    if ((winner == -1))
                    {
                        while (!temp.empty()){
                            heaps[p2].add(0, temp.remove(0));
                        }

                    }

                    temp.clear();
                    next = p2;
                }

                p = next;
            }

            String output = (winner + 1) + String.format("%3d", heaps[winner].size());
            System.out.println(output);
        }
    }

    public static char pickCard(Stack<Character> heap)
    {
        char card = (!heap.empty() ? heap.pop() : '\0');
        switch (card)
        {
            case 'A':
                count = 4;
                break;
            case 'J':
                count = 1;
                break;
            case 'Q':
                count = 2;
                break;
            case 'K':
                count = 3;
                break;
            default:
                count = Math.max(0, count - 1);
                break;
        }
        return card;
    }
}
