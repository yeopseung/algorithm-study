package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /**
         * N : 수열 A의 크기
         * maxValue : i번째 숫자를 기준으로 그 전의 숫자(0~i-1)들 중 가장 긴 길이
         * maxLength : 결과값. 가장 긴 수열의 길이
         * arr : 수열 저장 배열
         * num : 각 숫자로 만들 수 있는 최대 길이를 저장하는 배열
         *
         * 키포인트:
         * 1. i 번째 숫자를 기준으로 그 전의 숫자 (0~i-1)들 중 가장 긴 길의 수열을 가진 값을 탐색
         * 2. 탐색한 값에 i 번째 숫자를 추가하여 num 배열에 저장
         */
        int N, maxValue, maxLength;
        int[] arr, num;

        //입력
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        num = new int[1001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //초기값은 수열의 첫 숫자의 길이 -> 1
        maxLength = 1;
        num[arr[0]] = 1;

        for(int i=1; i<N; i++)
        {
            int maxIndex = -1;
            maxValue = 0;
            // i번째 숫자를 기준으로 그 전의 숫자들을 탐색
            for(int j= i-1 ; j>=0 ; j--)
            {
                // i번째 숫자보다 크기가 작은 숫자들 중
                if(arr[j] < arr[i])
                {
                    // 가장 긴 길이를 가지고 있는 숫자의 인덱스를 저장
                   if(maxValue < num[arr[j]])
                   {
                       maxValue = num[arr[j]];
                       maxIndex = j;
                   }
                }
            }

            // 위의 반복문에서 구한 인덱스가 존재할 경우
            if(maxIndex != -1)
            {
                // 그 전의 가장 긴 길이를 가지고 있는 숫자의 길이에서 +1
                num[arr[i]] = num[arr[maxIndex]] +1;
                // 최대 길이 갱신
                if(maxLength < num[arr[i]])
                    maxLength = num[arr[i]];
            }
            else
            {
                num[arr[i]] = 1;
            }
        }

        System.out.println(maxLength);
    }
}
