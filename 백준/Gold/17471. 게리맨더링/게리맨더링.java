import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int result = Integer.MAX_VALUE;
    static int[] section;
    static int[] sectionNum;
    static ArrayList<Integer>[] adjacent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N;
        boolean[] visited;

        // 구역 수 입력
        N = Integer.parseInt(br.readLine());

        // 구역 번호 초기화
        section = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            section[i] = i;
        }

        // 인구수 입력
        st = new StringTokenizer(br.readLine());
        sectionNum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sectionNum[i] = Integer.parseInt(st.nextToken());
        }

        // x 구역과 인접한 구역 입력
        adjacent = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            adjacent[i] = new ArrayList<>();

            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                adjacent[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // N/2 만큼 조합 생성 (구역을 두개로 나눔)
        visited = new boolean[N];
        for (int r = 1; r <= N / 2; r++) {
            seperateSection(visited, 0, N, r);
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

        br.close();
    }

    // 조합을 통해 구역을 두개로 나눔
    private static void seperateSection(boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            ArrayList<Integer> sectionA = new ArrayList<>();
            ArrayList<Integer> sectionB = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sectionA.add(i + 1);
                } else {
                    sectionB.add(i + 1);
                }
            }

            if (bfs(sectionA, n) && bfs(sectionB, n)) {
                calcMin(sectionA, sectionB);
            }

            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        seperateSection(visited, depth + 1, n, r - 1);

        visited[depth] = false;
        seperateSection(visited, depth + 1, n, r);
    }

    // BFS 를 통해 인접해 있는지 확인
    private static boolean bfs(ArrayList<Integer> sections, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[n + 1];
        queue.add(sections.get(0));
        check[sections.get(0)] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adjacent[cur]) {
                if (sections.contains(next) && !check[next]) {
                    queue.add(next);
                    check[next] = true;
                    cnt++;
                }
            }
        }

        if (cnt == sections.size()) {
            return true;
        }

        return false;
    }

    private static void calcMin(ArrayList<Integer> sectionA, ArrayList<Integer> sectionB) {
        int sumA = 0;
        int sumB = 0;

        for (int num : sectionA) {
            sumA += sectionNum[num];
        }

        for (int num : sectionB) {
            sumB += sectionNum[num];
        }

        result = Math.min(result, Math.abs(sumA - sumB));
    }
}