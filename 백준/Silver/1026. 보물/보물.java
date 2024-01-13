import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;

        // N 입력
        int N;
        N = Integer.parseInt(br.readLine());

        // A 배열 입력
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 배열 입력
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 A를 오름차순 정렬
        Arrays.sort(A);


        for(int i=0; i<N; i++)
        {
            int j = 0;
            int max = -1;
            int max_index = -1;

            while(j < N)
            {
                if(max < B[j])
                {
                    max = B[j];
                    max_index = j;
                }
                j++;
            }

            if(max != -1)
            {
                result += max * A[i];
                B[max_index] = -1;
            }
        }

        System.out.println(result);



    }
}
