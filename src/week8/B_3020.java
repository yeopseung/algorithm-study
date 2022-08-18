package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3020 {
    public static void main(String[] args) throws IOException {
        int N, H, num;
        int[] cnt;
        boolean isDown = true;

        int result;
        int result_num=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        cnt = new int[H+1];
        for(int i=0; i<N; i++)
        {
            num = Integer.parseInt(br.readLine());
            if(isDown)
            {
                for(int j=num; j>=1; j--)
                {
                    cnt[j]++;
                }

                isDown = false;
            }
            else
            {
               for(int j=H-num+1; j<=H; j++)
               {
                   cnt[j]++;
               }

               isDown = true;
            }
        }

        Arrays.sort(cnt);

        result = cnt[1];
        for(int i=1; i<=H; i++)
        {
            if(result==cnt[i])
                result_num++;
            else
                break;
        }

        System.out.println(result +" "+result_num);

    }
}
