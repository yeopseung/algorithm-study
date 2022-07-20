package week1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class B_1158 {
    public static void main(String[] args) {
        int N, K, start, result, end;
        boolean[] isVisit;

        StringBuffer sb = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st;

        st = new StringTokenizer(scanner.nextLine());
        // N: 인원 K: 순서 입력
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        //초기값 설절
        isVisit = new boolean[N];
        sb.append("<");
        start = N-1;
        end = N;

        //요세푸스 순열 계산
        while(end >0)
        {

            for(int i=0; i<K ; i++)
            {

                if(isVisit[(start+1)%N])
                {

                    start++;
                    i--;
                }
                else
                {
                    start++;
                }
            }

            result = start % N;
            if(end ==1)
                sb.append(result+1);
            else
                sb.append(result+1 + ", ");
            isVisit[result] = true;
            start = result;
            end--;
        }

        sb.append(">");

        System.out.println(sb);


    }
}
