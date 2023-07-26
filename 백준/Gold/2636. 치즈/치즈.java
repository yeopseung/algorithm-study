import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int M, N;
    private static final int[] rangeX = {-1,1,0,0};
    private static final int[] rangeY = {0,0,1,-1};
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        // 세로
        N = Integer.parseInt(st.nextToken());
        // 가로
        M = Integer.parseInt(st.nextToken());

        // 맵
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 소요된 시간
        int hour = 0;
        int cnt =0;
        while (true) {
            Queue<Location> queue = new LinkedList<>();
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0 && !visited[i][j]) {
                        if(checkOpenHole(i,j)){
                            queue.add(new Location(i,j));
                        }
                    }
                }
            }

            // 치즈 개수
            int temp = 0;
            visited = new boolean[N][M];
            while(!queue.isEmpty()){
                Location cur = queue.poll();
                visited[cur.x][cur.y] = true;

                for(int i=0; i<4; i++){

                    int dx = cur.x + rangeX[i];
                    int dy = cur.y + rangeY[i];

                    if(dx < 0 || dy < 0 || dx >= N || dy >= M){
                        continue;
                    }

                    // 치즈 녹임
                    if(map[dx][dy] == 1 && !visited[dx][dy]){
                        visited[dx][dy] = true;
                        map[dx][dy] = 0;
                        temp++;
                        continue;
                    }

                    // 치즈가 아니면 add
                    if(map[dx][dy] == 0 && !visited[dx][dy]){
                        visited[dx][dy] = true;
                        queue.add(new Location(dx,dy));
                    }
                }
            }

            if(temp == 0){
                System.out.println(hour);
                System.out.println(cnt);
                return;
            }

            hour++;
            cnt = temp;

        }
    }

    private static boolean checkOpenHole(int x, int y){
        Queue<Location> queue = new LinkedList<>();
        boolean result = false;

        queue.add(new Location(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Location cur = queue.poll();

            for(int i=0; i<4; i++){
                int dx = cur.x + rangeX[i];
                int dy = cur.y + rangeY[i];

                if(dx < 0 || dy < 0 || dx >= N || dy >= M){
                    result = true;
                    continue;
                }

                if(map[dx][dy] == 0 && !visited[dx][dy]){
                    visited[dx][dy] = true;
                    queue.add(new Location(dx,dy));
                }
            }
        }

        return result;
    }
}

class Location{
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}