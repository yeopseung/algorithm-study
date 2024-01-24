import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] rangeX = {0, 1, 0, -1};
    private static int[] rangeY = {1, 0, -1, 0};

    private static int N, M;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Location> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int result = 0;

        queue.add(new Location(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Location cur = queue.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                result = cur.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dx = cur.x + rangeX[i];
                int dy = cur.y + rangeY[i];

                if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
                    continue;
                }

                if (!visited[dx][dy] && map[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    queue.add(new Location(dx,dy,cur.cnt+1));
                }
            }


        }

        return result;
    }

    static class Location {
        int x, y, cnt;

        Location(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}