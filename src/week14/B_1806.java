package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1806
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, S, x, y, min,resX, resY;
        int[] num, p_sum;

        st = new StringTokenizer(br.readLine());
        // N : 길이 N짜리 수열
        N = Integer.parseInt(st.nextToken());
        // S : 부분합이 넘어야할 기준 값
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // num[] : 숫자 저장 배열
        num = new int[N+1];
        // p_sum[] : prefix sum
        p_sum = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            num[i] = Integer.parseInt(st.nextToken());
            p_sum[i] = p_sum[i-1] + num[i];
        }


        x = 0;
        y = 1;
        min = Integer.MAX_VALUE;

        while(y<=N)
        {
            int tmp = p_sum[y] - p_sum[x];

            if(tmp>=S)
            {
                min = Math.min(min, y-x);
                x++;
            }
            else
            {
                y++;
            }
        }

        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }

        System.out.println(min);

    }
}
