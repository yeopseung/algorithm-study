package week_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_9093 {
    public static void main(String[] args) {
        int T;

        StringBuffer result = new StringBuffer();
        StringBuffer word = new StringBuffer();
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);

        T = Integer.parseInt(sc.nextLine());

        for(int i=0; i<T ; i++)
        {
            st = new StringTokenizer(sc.nextLine(), " ");
            while(st.hasMoreTokens())
            {
                word.delete(0,word.length());
                word.append(st.nextToken());
                result.append(word.reverse()+ " ");
            }
            if(i-1 != T)
                result.append("\n");
        }
        System.out.println(result);

    }
}
