package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1740
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N, result;
        int cnt;

        // N: N번째 로 작은 수
        N = Long.parseLong(br.readLine());

        result = 0;
        cnt = 0;
        while(N>0)
        {
            if((N&1) ==1)
            {
                // Math.pow 는 double 형 실수 연산이므로 큰 수 일수록 오차 발생 확률 증가
                // 따라서 곱셈 연산을 이용
                long tem=1;
                for(int i=0; i<cnt; i++)
                    tem *= 3;

                result += tem;
            }

            cnt++;
            N = (N >> 1);
        }

        System.out.println(result);
    }
}
