package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11811
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N, num;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            num = 0;
            for(int j=0; j<N; j++)
            {
                num = num | Integer.parseInt(st.nextToken());
            }

            sb.append(num+" ");
        }

        System.out.println(sb);
    }
}
