package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15787
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> galaxy = new ArrayList<>();
        int N, M;
        int[] train;

        st = new StringTokenizer(br.readLine());
        // N: 기차의 개수
        N = Integer.parseInt(st.nextToken());
        // M: 수행할 명령어 개수
        M = Integer.parseInt(st.nextToken());

        // train[]: 기차 저장
        train = new int[N+1];

        // 명령어 수행
        int i,x;
        for(int m=1; m<=M; m++)
        {
            st = new StringTokenizer(br.readLine());

            switch (Integer.parseInt(st.nextToken()))
            {
                case 1:
                    // 1 i x : i번째 기차에 x번째 좌석에 사람을 태움
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    train[i] = train[i] | (1<<x);
                    break;

                case 2:
                    // 2 i x : i번째 기차에 x번째 좌석에 앉은 사람 하차
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    train[i] = train[i] & ~(1<<x);
                    break;

                case 3:
                    // 2 i : i번째 기차에 있는 승객들 한칸씩 뒤로
                    i = Integer.parseInt(st.nextToken());
                    train[i] = train[i] << 1;
                    // 20번째 자리에 사람이 있었을 경우 하차 (21번)
                    train[i] = train[i] & ~(1<<21);
                    break;

                case 4:
                    // 2 i : i번째 기차에 있는 승객들 한칸씩 앞으로
                    i = Integer.parseInt(st.nextToken());
                    train[i] = train[i] >> 1;
                    // 1번째 자리에 사람이 있었을 경우 하차 (0번)
                    train[i] = train[i] & ~1;
                    break;
            }
        }

        // 은하 통과
        int result = 0;
        for(int n=1; n<=N; n++)
        {
            if(!galaxy.contains(train[n]))
            {
                galaxy.add(train[n]);
                result++;
            }
        }

        System.out.println(result);

    }
}
