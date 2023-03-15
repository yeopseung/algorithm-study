package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_8983_V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M, N, L, low, mid, high, result;
        int[] place;
        int[][] animal;

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
            place[i] = Integer.parseInt(st.nextToken());

        // 사대의 위치를 오름차순으로 정렬
        Arrays.sort(place);

        // place[]: 동물의 위치
        animal = new int[N][2];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            // 동물의 위치 (a,b)
            animal[i][0] = Integer.parseInt(st.nextToken());
            animal[i][1] = Integer.parseInt(st.nextToken());
        }
        // 동물의 위치를 a값 기준으로 오름차순 정렬
        Arrays.sort(animal, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });

        result = 0;
        for(int i=0; i<N; i++)
        {
            // 적절한 사대의 위치를 이분 탐색
            low = 0;
            high = M-1;
            while(low <= high)
            {
                mid = (low + high)/2;

                // 사대와 동물의 거리가 사정거리 내 일 경우 -> 사냥 성공
                if((Math.abs(place[mid] - animal[i][0]) + animal[i][1]) <= L)
                {
                    result++;
                    break;
                }

                // 사정거리 밖일 경우 -> x 좌표를 비교하여 사대 변경
                if((place[mid] - animal[i][0]) < 0)
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
