package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_20437
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String W;
        int T, K;
        ArrayList<ArrayList<Integer>> alphabet;

        // T: 게임 횟수
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++)
        {
            alphabet = new ArrayList<>();
            for(int i=0; i<26; i++)
            {
                alphabet.add(new ArrayList<>());
            }

            // W: 게임할 문자열
            W = br.readLine();
            for(int w = 0; w<W.length(); w++)
            {
                alphabet.get(W.charAt(w)-'a').add(w);
            }

            // K: 동일 문자 개수 (만족해야할 조건)
            K = Integer.parseInt(br.readLine());

            int minLength = Integer.MAX_VALUE, maxLength = Integer.MIN_VALUE;
            for(ArrayList<Integer> arrayList : alphabet)
            {
                if(arrayList.size() < K)
                    continue;

                int start = 0, end = K-1;
                int x, y;
                while(end < arrayList.size())
                {
                    x = arrayList.get(start);
                    y = arrayList.get(end);

                    minLength = Math.min(minLength, y-x+1);
                    maxLength = Math.max(maxLength, y-x+1);

                    start++;
                    end++;
                }
            }

            if(minLength == Integer.MAX_VALUE && maxLength == Integer.MIN_VALUE)
                System.out.println(-1);
            else
                System.out.println(minLength+" "+maxLength);

        }



    }
}
