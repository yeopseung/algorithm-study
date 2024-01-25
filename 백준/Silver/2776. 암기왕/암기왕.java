import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] note;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트케이스 입력
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T ; t++) {
            // 수첩1 입력
            int N = Integer.parseInt(br.readLine());
            note = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                note[n] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note);

            // 수첩2 입력
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int target = Integer.parseInt(st.nextToken());
                int result = binarySearch(0, N-1, target);

                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int binarySearch(int start, int end, int target) {
        // 찾지 못한 경우: 0
        if (start > end) {
            return 0;
        }

        int mid = (start + end) / 2;

        // 찾은 경우: 1
        if (note[mid] == target) {
            return 1;
        }
        // 큰 경우: 오른쪽
        else if (note[mid] < target) {
            return binarySearch(mid+1, end, target);
        }
        // 작은 경우: 왼쪽
        else {
            return binarySearch(start, mid-1, target);
        }
    }
}