import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, maxValue, maxLength;
        int[] num, left, right, dp;

        // N: 숫자 개수, 입력
        N = Integer.parseInt(br.readLine());

        // num[] : 수열 저장하는 배열, 입력
        num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
        {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // left[] : 왼쪽에서 오른쪽으로 증가하는 수열의 최대 길이를 저장하는 배열
        left = new int[N+1];
        // right[] :오른쪽에서 왼쪽으로 증가하는 수열의 최대 길이를 저장하는 배열
        right = new int[N+1];
        // dp[] : 바이토닉 수열의 최대 길이를 저장하는 배열
        dp = new int[N+1];

        left[1] = 1;
        for(int i=2; i<=N; i++)
        {
            maxValue = -1;
            for(int j=i-1; j>=1; j--)
            {
                if(num[j] < num[i])
                {
                    maxValue = Math.max(left[j], maxValue);
                }
            }

            if(maxValue != -1)
                left[i] = maxValue + 1;
            else
                left[i] = 1;
        }
//        for(int i=1; i<=N; i++)
//        {
//            System.out.print(left[i]+" ");
//        }
//        System.out.println();


        right[N] = 1;
        for(int i=N-1; i>=1; i--)
        {
            maxValue = -1;
            for(int j=i+1; j<=N; j++)
            {
                if(num[j] < num[i])
                {
                    maxValue = Math.max(right[j], maxValue);
                }
            }
            if(maxValue != -1)
                right[i] = maxValue + 1;
            else
                right[i] = 1;
        }

//        for(int i=1; i<=N; i++)
//        {
//            System.out.print(right[i]+" ");
//        }
//        System.out.println();

        maxLength = -1;
        for(int i=1; i<=N; i++)
        {
            maxLength = Math.max((left[i]+right[i]-1),maxLength);
        }
        System.out.println(maxLength);
    }
}
