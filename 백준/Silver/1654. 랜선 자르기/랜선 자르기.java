

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K, N;
        long low, mid, high;
        long[] wire;

        st = new StringTokenizer(br.readLine());
        // K: 가지고있는 전선의 개수
        K = Integer.parseInt(st.nextToken());
        // N: 만들고싶은 전선의 개수
        N = Integer.parseInt(st.nextToken());

        // wire[]: 각 전선의 길이 저장 배열
        wire = new long[(int) K];
        low = 0;
        high = 0;
        for(int i=0; i<K; i++)
        {
            wire[i] = Long.parseLong(br.readLine());
            high = Math.max(high,wire[i]);
        }

        high++;
        while (low < high)
        {
            long sum = 0;
            mid = (low + high)/2;

            for(long length: wire)
                sum += length / mid;

            if(sum < N)
                high = mid;
            else
                low = mid +1;
        }

        System.out.println(low - 1);
    }
}
