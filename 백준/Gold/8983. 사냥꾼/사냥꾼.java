import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M, N, L, x, y, low, mid, high, result;
        int[] place;

        st = new StringTokenizer(br.readLine());
        // M: 사대의 개수
        M = Integer.parseInt(st.nextToken());
        // N: 동물의 수
        N = Integer.parseInt(st.nextToken());
        // L: 총의 사정거리
        L = Integer.parseInt(st.nextToken());

        // place[]: 사대의 위치
        place = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
        {
            place[i] = Integer.parseInt(st.nextToken());
        }

        // -L +bj +aj ≤ xi  ≤ L - bj +aj

        result = 0;
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            // 동물의 위치 (x,y)
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            low = 0;
            high = M-1;

            while(low <= high)
            {
                mid = (low + high) /2;

                if(place[mid] > (L + x - y))
                    high = mid-1;
                else if(place[mid] < (-L +x +y))
                    low = mid+1;
                else
                {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
