package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2839
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;

        // N 입력 (N은 배달할 설탕의 무게)
        N = Integer.parseInt(br.readLine());


        // 5kg 봉지의 개수 범위: 0~(N/5)
        for(int i=0; i<N/5; i++)
        {
            // 3kg 봉지의 개수 범위: 0~(N/3)
            for(int j=0; j<N/3; j++)
            {
                // Nkg 을 만족할 경우 출력 후 종료
                if((i*5) + (j*3) == N)
                {
                    System.out.println(i+j);
                    return;
                }
            }
        }
        // 만족하는 값이 없을 경우 -1
        System.out.println(-1);

    }
}
