package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int num;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            num = Integer.parseInt(st.nextToken());
            boolean check = true;

            for(int j=2; j<num; j++)
            {

                if((num % j == 0))
                {
                    check = false;
                    break;
                }
            }

            if(check && num != 1)
            {

                result++;
            }

        }

        System.out.println(result);



    }
}
