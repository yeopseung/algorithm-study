import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, Q;
        long K;
        int[] arr;
        long[] factorial;
        boolean[] visited;

        // 1! , 2!, 3!, ..., 20! 각각의 가짓수를 구해 놓음
        // factorial[1] = 1!
        factorial = new long[21];
        factorial[0] = 1;
        for (int i = 1; i <= 20; i++) {
            factorial[i] = i * factorial[i - 1];
        }


        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(arr, 0);
        Arrays.fill(visited, false);

        st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());


        // 1번 문제
        if (Q == 1) {
            ArrayList<Integer> answer = new ArrayList<>();
            K = Long.parseLong(st.nextToken());

            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (K - factorial[N - 1 - i] > 0) {
                        K -= factorial[N - 1 - i];
                    } else {
                        answer.add(j);
                        visited[j] = true;
                        break;
                    }
                }
            }

            for (int num : answer) {
                System.out.print(num + " ");
            }
        }
        // 2번 문제
        else if (Q == 2) {
            long answer = 1;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if (!visited[j]) {
                        answer += factorial[N - 1 - i];
                    }
                }
                visited[arr[i]] = true;
            }
            
            System.out.println(answer);
        }

        br.close();
    }
}