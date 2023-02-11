package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1322
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        long X, Y, K, k;


        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Y = 0;
        k = 0;
        for(int i=0; i< 65;i++)
        {
            if(((X >> i) & 1L) == 1)
                continue;

            if(((K >> k) & 1L) == 1)
            {
                Y = Y | (1L << i);
            }

            k++;
        }

        System.out.println(Y);
    }
}
