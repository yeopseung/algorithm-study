package week17;

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

        X = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());



        k = 0;
        Y = 1;
        while(true)
        {
            if((X&Y) == 0)
                k++;

            if(k == K)
                break;

            Y++;
        }

        System.out.println(Y);
    }
}
