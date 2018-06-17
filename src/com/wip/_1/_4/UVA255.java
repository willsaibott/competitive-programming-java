package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimzations balanced the most I can.
 */
class Main255 {

    enum State
    {
        Undefined,
        IllegalState,
        IllegalMove,
        MoveNotAllowed,
        Continue,
        Stops
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("0")) {
            State state = State.Undefined;
            int queen0, queen1;
            int king;

            st = new StringTokenizer(line);
            king = Integer.parseInt(st.nextToken());
            queen0 = Integer.parseInt(st.nextToken());
            queen1 = Integer.parseInt(st.nextToken());

            if (queen0 != king)
            {
                if (isMoveLegal(queen0, queen1, king))
                {
                    if (isMoveAllowed(king, queen1)) {
                        if (isFree(king, queen1)) {
                            state = State.Continue;
                        } else {
                            state = State.Stops;
                        }
                    }
                    else
                    {
                        state = State.MoveNotAllowed;
                    }
                }
                else
                {
                    state = State.IllegalMove;
                }
            }
            else
            {
                state = State.IllegalState;
            }

            String output;

            switch (state)
            {
                case IllegalState:
                    output = "Illegal state";
                    break;
                case IllegalMove:
                    output = "Illegal move";
                    break;
                case MoveNotAllowed:
                    output = "Move not allowed";
                    break;
                case Continue:
                    output = "Continue";
                    break;
                case Stops:
                    output = "Stop";
                    break;
                default:
                    output = "Undefined";
                    break;
            }

            System.out.println(output);
        }
    }

    static boolean isMoveLegal(int q0, int q1, int king)
    {

        return (q1 != q0) &&
                ((isSameColumn(q0, q1) && !(isSameColumn(q1, king) && isBetween(q0, q1, king))) ||
                 (isSameRow(q0, q1) && !(isSameRow(king, q1) && isBetween(q0, q1, king))));
    }

    static boolean isSameColumn(int p0, int p1)
    {
        return p0 / 8 == p1 / 8;
    }

    static boolean isSameRow(int p0, int p1)
    {
        return p1 % 8 == p0 % 8;
    }

    static boolean isBetween(int q0, int q1, int king)
    {
        return ((king >= q0 && king <= q1 ) || (king >= q1 && king <= q0 ));
    }

    static boolean isMoveAllowed(int king, int queen)
    {
        return !(king / 8 != 7 && (king + 8) == queen) &&
               !(king / 8 != 0 && (king - 8) == queen) &&
               !(king % 8 != 7 && (king + 1) == queen) &&
               !(king % 8 != 0 && (king - 1) == queen);
    }

    static boolean isFree(int king, int queen)
    {
        return (king / 8 != 7 && (!isSameColumn(king + 8, queen))) ||
               (king / 8 != 0 && (!isSameColumn(king - 8, queen))) ||
               (king % 8 != 7 && (!isSameRow(king + 1, queen))) ||
               (king % 8 != 0 && (!isSameRow(king - 1, queen)));
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA255 {

    final static String packName = UVA255.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA255.class, chapter);
        Main255.main(args);
    }
}