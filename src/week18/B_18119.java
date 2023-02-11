package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_18119
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N, M, alphabet, cnt;
        int[] str;

        st = new StringTokenizer(br.readLine());
        // N : 문자열 개수
        N = Integer.parseInt(st.nextToken());
        // M : 쿼리 개수
        M = Integer.parseInt(st.nextToken());

        alphabet = Integer.MAX_VALUE;

        str = new int[N];
        for(int i=0; i<N; i++)
        {
            String s = br.readLine();
            for(int j=0; j<s.length(); j++)
            {
                str[i] = str[i] | (1 << (s.charAt(j)-'a'));
            }
        }

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken())
            {
                case "1":
                    alphabet = alphabet & ~(1 << (st.nextToken().charAt(0) - 'a'));
                    break;

                case "2":
                    alphabet = alphabet | (1 << (st.nextToken().charAt(0) - 'a'));
                    break;
            }

            cnt = 0;
            for(int j=0; j<N; j++)
            {
                if((str[j] & alphabet) == str[j])
                    cnt++;
            }

            sb.append(cnt+"\n");
        }

        System.out.println(sb);



    }
}
