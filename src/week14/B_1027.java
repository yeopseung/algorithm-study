package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1027
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, result;
        int[] height;
        boolean[] visit;

        // N: 빌딩의 수
        N = Integer.parseInt(br.readLine());

        // height[]: 각 빌딩의 높이
        height = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
        {
            height[i] = Integer.parseInt(st.nextToken());
        }




    }
}
