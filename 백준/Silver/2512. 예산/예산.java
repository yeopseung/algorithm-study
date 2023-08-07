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

        int N, M, low, mid, high;
        int[] budget;

        // N: 지방의 개수
        N = Integer.parseInt(br.readLine());

        // budget: 각 지방의 예산 요청
        budget = new int[N];
        low = 0;
        high = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            budget[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high,budget[i]);
        }
        
        
        // M: 총 예산
        M = Integer.parseInt(br.readLine());

        while(low <= high)
        {
            int sum = 0;
            mid = (low + high) / 2;
            
            for(int b: budget)
            {
                if(mid > b)
                    sum += b;
                else
                    sum += mid;
            }

            if(sum <= M)
                low = mid +1;
            else
                high = mid -1;
        }

        System.out.println(low - 1);
    }
}
