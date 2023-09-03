import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        int[] num;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int head = 0;
        int tail = N-1;
        int result = Integer.MAX_VALUE;
        int h= 0,t = N-1;

        while(head < tail)
        {

            int sum = num[head] +num[tail];

            if(Math.abs(sum)<Math.abs(result))
            {
                h = head;
                t = tail;


               result = sum;
               
            }


            if(sum < 0)
            {
                head++;
            }
            else if(sum>0)
            {
                tail--;
            }
            else if(sum==0)
            {
                break;
            }



        }

        System.out.println(num[h]+" "+num[t]);
    }
}
