package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main187 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(), optional;
        StringTokenizer st;
        String line;
        boolean begin = true;
        HashMap<String, String> accounts = new HashMap<>();
        LinkedHashMap<String, ArrayList<AccountTransaction>> transactions = new LinkedHashMap<>();
        ArrayList<AccountTransaction> list;
        String id, transId, name;
        int value;

        // Accounts
        for (;;)
        {
            line = bf.readLine();
            id = line.substring(0, 3);
            name = line.substring(3, line.length());

            if (id.equals("000")) break;

            accounts.put(id, name);
        }

        // Transactions
        for(;;)
        {
            line = bf.readLine();
            transId = line.substring(0, 3);

            if (transId.equals("000")) break;

            id = line.substring(3, 6);
            value = Integer.parseInt(line.substring(6).replaceAll(" ", ""));

            if ((list = transactions.get(transId)) != null)
            {
                list.add(new AccountTransaction(id, value));
            }
            else
            {
                list = new ArrayList<>();
                list.add(new AccountTransaction(id, value));
                transactions.put(transId, list);
            }

        }

        for (Entry<String, ArrayList<AccountTransaction>> transaction : transactions.entrySet()) {
            list = transaction.getValue();
            int total = 0;


            for (AccountTransaction accountTransaction : list) {
                total -= accountTransaction.value;
            }

            if (total != 0)
            {
                sb.append("*** Transaction ")
                  .append(transaction.getKey())
                  .append(" is out of balance ***\n");

                for (AccountTransaction accountTransaction : list) {
                    sb.append(String.format("%s %-30s %10.2f\n",
                                            accountTransaction.id,
                                            accounts.get(accountTransaction.id),
                                            (accountTransaction.value) / 100.0));
                }

                sb.append(String.format("999 %-30s %10.2f\n\n",
                                        "Out of Balance",
                                        (total) / 100.0));
            }
        }



        System.out.write(sb.toString().getBytes());
    }


    static class AccountTransaction
    {
        String id;
        int value;

        public AccountTransaction(String id, int value) {
            this.id = id;
            this.value = value;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA187 {

    final static String packName = UVA187.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA187.class, chapter);
        Main187.main(args);
    }
}