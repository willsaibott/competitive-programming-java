package com.wip._1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA10919 {
    public static void main(String[] args) {
        defineInputMethod(UVA10919.class);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int nCourses = scanner.nextInt();
            if (nCourses == 0) break;
            int nCategories = scanner.nextInt();
            HashSet<String> courses = new HashSet<>();
            String output = "yes";


            for (int ii = 0; ii < nCourses; ii++) {
                courses.add(scanner.next());
            }

            for (int ii = 0; ii < nCategories; ii++) {
                int n = scanner.nextInt();
                int required = scanner.nextInt();
                int count = 0;

                for (int jj = 0; jj < n; jj ++) {
                    String course = scanner.next();
                    if (courses.contains(course))
                        count++;
                }
                if (count < required){
                    output = "no";
                }
            }

            System.out.println(output);
        }
    }


    public class Prerequisties_UVa10919{

        public void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();


            while(true)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                if(k==0)
                    break;
                int m = Integer.parseInt(st.nextToken());
                HashSet<String> h = new HashSet<String>();
                st = new StringTokenizer(br.readLine());
                for(int i = 0; i < k; i++)
                    h.add(st.nextToken());
                boolean possible = true;
                for(int i = 0; i < m; i++)
                {
                    st = new StringTokenizer(br.readLine());
                    int c = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    while(r!=0&&c>0)
                    {
                        String course = st.nextToken();
                        if(h.contains(course))
                            r--;
                        c--;
                    }
                    if(r!=0)
                        possible = false;
                }
                if(possible)
                    sb.append("yes\n");
                else
                    sb.append("no\n");

            }
            System.out.print(sb);


        }
    }
}
