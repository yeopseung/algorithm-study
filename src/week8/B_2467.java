package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B_2467 {
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

        int head = 0;
        int tail = N-1;
        int result = Integer.MAX_VALUE;
        int h= 0,t = N-1;


        while(head < tail)
        {

            int sum = num[head] +num[tail];

            if(Math.abs(sum)<Math.abs(result))
            {
                //최솟값 갱신 및 그때의 인덱스 저장
                h = head;
                t = tail;


                result = sum;

            }

            // 합이 0보다 작을 경우 head+1
            if(sum < 0)
            {
                head++;
            }
            // 합이 0보다 클 경우 tail-1
            else if(sum>0)
            {
                tail--;
            }
            //  합이 0일 경우 종료
            else if(sum==0)
            {
                break;
            }



        }

        System.out.println(num[h]+" "+num[t]);
    }
}
