package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3020_V2 {
    public static void main(String[] args) throws IOException {
        int N, H, num;
        int[] up_cnt;
        int[] down_cnt;
        int[] result;
        int end, cnt=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        up_cnt = new int[H+1];
        down_cnt = new int[H+1];
        result = new int[H+1];

        for(int i=1; i<=N; i++)
        {
            num = Integer.parseInt(br.readLine());

            //짝수일 경우 종유석
            if(i%2 == 0)
            {
                up_cnt[num]++;
            }
            //홀수일 경우 석순
            else
            {
                down_cnt[num]++;
            }
        }


        //종유석 & 석순 길이만큼 누적 합
        for(int i=H; i>=2; i--)
        {
            up_cnt[i-1] += up_cnt[i];
            down_cnt[i-1] += down_cnt[i];
        }


        //종유석 과 석순을 교차하여 저장
        int j=H;
        for(int i=1; i<=H; i++)
        {
            result[i] = down_cnt[i] + up_cnt[j];
            j--;
        }

        //결과값 정렬
        Arrays.sort(result);
        //정렬결과 1번 인덱스는 무조건 최솟값
        end = result[1];
        //최솟값과 같은 것 count +1
        for(int i=1; i<=H; i++)
        {
            if(end==result[i])
                cnt++;
            else
                break;
        }

        //결과 출력
        System.out.println(end +" "+cnt);


    }
}
