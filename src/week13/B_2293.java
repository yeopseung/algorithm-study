package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2293
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, K;
        int[] coin;

        st = new StringTokenizer(br.readLine());
        // N: 동전의 종류 개수
        N = Integer.parseInt(st.nextToken());
        // K: 만들고 싶은 가치의 합
        K = Integer.parseInt(st.nextToken());

        // coin[]: 동전의 가치 저장 배열
        coin = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            coin[i] = Integer.parseInt(br.readLine());
        }



    }
}
