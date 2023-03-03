package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2805
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M, low, mid, high;
        int[] tree;

        st = new StringTokenizer(br.readLine());
        // N: 나무의 개수
        N = Integer.parseInt(st.nextToken());
        // M: 가져가려하는 나무의 길이
        M = Integer.parseInt(st.nextToken());

        // tree[]: 나무의 길이 저장 배열
        st = new StringTokenizer(br.readLine());
        tree = new int[N];
        low = 0;
        high = 0;
        for(int i=0; i<N; i++)
        {
            tree[i] = Integer.parseInt(st.nextToken());

            high = Math.max(high,tree[i]);
        }

        while(low < high)
        {
            long sum = 0;
            mid = (low + high)/2;

            for(int i=0; i<N; i++)
            {
                if((tree[i] - mid) > 0)
                    sum += tree[i] - mid;
            }

            if(sum < M)
                high = mid;
            else
                low = mid +1;
        }

        System.out.println(low-1);
    }
}
