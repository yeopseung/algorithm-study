package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1520 {
    static int M, N;
    static int[][] map;
    static boolean[][] visit;
    static int[][] path;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //입력
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        path = new int[M][N];
        visit = new boolean[M][N];
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //초기값 설정
        for(int i=0; i<M; i++)
        {
            Arrays.fill(path[i],0);
        }
        dp(0,0);
        System.out.println(path[0][0]);

        for(int i=0; i<M; i++)
        {

            for(int j=0; j<N; j++)
            {
                System.out.print(path[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int dp(int x, int y) {

        int[] rangeX = {0, 0, 1,-1};
        int[] rangeY = {-1, 1, 0,0};


        if (x == M - 1 && y == N - 1)
        {
            path[x][y] = 1;
            visit = new boolean[M][N];
            return 1;
        }


        for (int m = 0; m < 4; m++) {
            int dx = x + rangeX[m];
            int dy = y + rangeY[m];

            if (dx < 0 || dy < 0 || dx >= M || dy >= N)
                continue;



            if (map[dx][dy] < map[x][y] && !visit[dx][dy]) {
                System.out.println(map[x][y] +"->"+ map[dx][dy]);
                visit[dx][dy] = true;
                if(path[dx][dy] != 0)
                    return path[dx][dy];
                path[x][y] += dp(dx,dy);
                System.out.println("path[x][y]: "+ path[x][y] + "| xy : "+x +" "+y);
            }
        }

        return path[x][y];
    }
}
