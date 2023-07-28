import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, good;
        int[] num;

        // N: 수의 개수
        N = Integer.parseInt(br.readLine());

        // num[]: 숫자 저장 배열
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 정렬
        Arrays.sort(num);

        // 좋은 수 탐색 시작
        good = 0;
        for (int i = 0; i < N; i++)
        {
            // target: 탐색하는 숫자
            int target = num[i];

            int x = 0;
            int y = N-1;

            while(x<y) {
                int sum = num[x] + num[y];

                // 탐색하는 숫자는 제외
                if(y == i)
                {
                    y--;
                    continue;
                }
                // 탐색하는 숫자는 제외
                if(x == i)
                {
                    x++;
                    continue;
                }

                // 좋은 수를 찾았을 경우
                if (sum == target) {
                    good++;
                    break;
                }

                // 두 숫자의 합이 찾는 수 보다 클 경우
                if (sum > target)
                {
                    y--;


                }

                // 두 숫자의 합이 찾는 수 보다 작을 경우
                if(sum < target)
                {
                    x++;
                }

            }
        }

        System.out.println(good);
    }
}
