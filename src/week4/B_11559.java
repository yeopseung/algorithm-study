package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class B_11559 {
    public static void main(String[] args) throws IOException {
        char[][] arr = new char[12][6];
        boolean[][] marked = new boolean[12][6];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Character> queue = new LinkedList<>();
        String str;


        //입력
        for(int i=0; i<12; i++)
        {
            str = br.readLine();
            for(int j=0; j<6; j++)
            {
                arr[i][j] = str.charAt(j);
            }
        }



        for(int i=0; i<12; i++)
        {
            for(int j=0; j<6; j++)
            {

            }
        }
        //BFS



    }
}
