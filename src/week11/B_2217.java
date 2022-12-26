package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2217 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, result, max;
        int[] rope;

        // N 입력
        N = Integer.parseInt(br.readLine());

        // 각 로프의 최대 중량 입력
        rope = new int[N];
        for(int i=0; i<N; i++)
        {
            rope[i] = Integer.parseInt(br.readLine());
        }

        // 초기값 설정
        result = 0;
        max = -1;

        // 로프 배열 정렬 후 최대 중량 탐색
        Arrays.sort(rope);
        for(int i=0; i<N; i++)
        {
            max = Math.max(max, rope[i] * (N-i));
        }

        result = max;
        System.out.println(result);


    }
}
