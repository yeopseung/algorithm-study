package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;

        // N 입력
        int N;
        N = Integer.parseInt(br.readLine());

        // A 배열 입력
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 배열 입력
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 A를 오름차순 정렬
        Arrays.sort(A);


        for(int i=0; i<N; i++)
        {
            int j = 0;
            int max = -1;
            int max_index = -1;

            while(j < N)
            {
                // B 배열에서 현재 최댓값을 탐색
                if(max < B[j])
                {
                    // 최댓값을 갱신하고 해당 인덱스 저장
                    max = B[j];
                    max_index = j;
                }
                j++;
            }

            // 최댓값을 찾았을 경우
            if(max != -1)
            {
                // A[i]의 값과 현재 최댓값을 곱하여 결과로 저장
                result += max * A[i];
                // 현재 최댓값 사용 표시
                B[max_index] = -1;
            }
        }

        // 결과 출력
        System.out.println(result);



    }
}
