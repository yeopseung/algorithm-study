import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, H, num;
        int[] up_cnt;
        int[] down_cnt;
        int[] result;

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


        for(int i=H; i>=2; i--)
        {
            up_cnt[i-1] += up_cnt[i];
            down_cnt[i-1] += down_cnt[i];
        }


        int j=H;
        for(int i=1; i<=H; i++)
        {
            result[i] = down_cnt[i] + up_cnt[j];
            j--;
        }


        int end, cnt=0;
        Arrays.sort(result);
        end = result[1];
        for(int i=1; i<=H; i++)
        {
            if(end==result[i])
                cnt++;
            else
                break;
        }

        System.out.println(end +" "+cnt);


    }
}
