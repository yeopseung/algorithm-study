import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[N];
        int left = 0, right = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());

            right = Math.max(right, num[i]);
        }

        while(left < right){
            int mid = (left + right) / 2;

            if(countSection(mid) <= M)
                right = mid;
            else
                left = mid +1;
        }

        System.out.println(right);
    }

    private static int countSection(int mid){
        int cnt = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);

            if((max - min) > mid){
                cnt++;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                i--;
            }
        }

        return cnt;
    }
}
