package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_8983
{
    public static void main(String[] args) throws IOException
    {
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

        // 사대의 위치를 기준으로 이분탐색

        result = 0;
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            // 동물의 위치 (x,y)
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // 적절한 사대의 위치를 이분 탐색
            low = 0;
            high = M-1;
            while(low <= high)
            {
                mid = (low + high)/2;

                // 사대와 동물의 거리가 사정거리 내 일 경우 -> 사냥 성공
                if((Math.abs(place[mid] - x) + y) <= L)
                {
                    result++;
                    break;
                }

                // 사정거리 밖일 경우 -> x 좌표를 비교하여 사대 변경
                if((place[mid] - x) < 0)
                    // 값이 음수일 경우 -> 사대 기준 동물이 오른쪽에 있다는 뜻
                    low = mid +1;
                else
                    // 값이 양수일 경우 -> 사대 기준 동물이 왼쪽에 있다는 뜻
                    high = mid -1;
            }
        }

        System.out.println(result);
    }

}
