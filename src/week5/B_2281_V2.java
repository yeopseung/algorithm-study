package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2281_V2 {
    static int N, M;
    static int[] name;
    static int[][] list;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // name 입력
        name = new int[N];
        list = new int[1002][1002];
        for(int i=0; i<N; i++)
        {
            name[i] = Integer.parseInt(br.readLine());
        }

        //DP
        for (int[] ints : list) {
            Arrays.fill(ints, -1);
        }
        System.out.println(dp(1,name[0] + 1));

    }

    // 다음줄에 쓰는 경우
    // 이어쓰는 경우
    // index : 번호
    // length :  글자 수
    static int dp(int index, int length)
    {
        int left, result;

        // 탈출 조건 : 단어를 다 썼을 경우
        if(index == N)
            return 0;

        // 계산했던 값은 기억하여 전달
        if((result = list[index][length]) != -1)
            return result;

        // 남은 칸 수 계산
        left = M - length + 1;

        // 다음줄에 써야하는 경우
        // 남은 칸수의 제곱이 result
        result = (left * left) + dp(index+1, name[index]+1);

        // 현재줄에 이어서 쓸 수 있는경우
        if(length + name[index] <= M)
            // 다음줄에 쓰는 경우와 현재줄에 이어쓰는 경우 중 최솟값
            result = Math.min(dp(index+1, length + name[index] + 1), result);


        // 계산 결과 저장 및 리턴
        list[index][length] = result;
        return result;

    }
}
