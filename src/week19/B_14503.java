package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14503
{
    private static final int[] rangeX = {-1,0,1,0};
    private static final int[] rangeY = {0,1,0,-1};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M, x, y, d, result=0;
        boolean isClear;
        int[][] map;
        boolean[][] visited;

        st = new StringTokenizer(br.readLine());
        // NxM: 방 크기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // (x,y): 시작 지점
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        // d: 시작 방향
        d = Integer.parseInt(st.nextToken());

        // map[][]: NxM 방
        map = new int[N][M];
        // visited[][]: 청소한 방 표시
        visited = new boolean[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<Robot> queue = new LinkedList<>();
        // 초기값
        queue.add(new Robot(x,y,d,0));

        while (!queue.isEmpty())
        {
            // 현재 로봇의 정보
            Robot cur = queue.poll();
            // 주변 4칸이 모두 청소되어 있을 경우 true
            isClear = true;

            // 1. 현재 칸이 청소되지 않은 경우, 현재 칸을 청소
            if(!visited[cur.x][cur.y])
            {
                visited[cur.x][cur.y] = true;
                cur.cnt = cur.cnt + 1;
            }

            // 주변 4칸을 확인
            for(int i=0; i<4; i++)
            {
                int dx = cur.x + rangeX[i];
                int dy = cur.y + rangeY[i];

                if(dx < 0 || dx > N || dy < 0 || dy > M)
                    continue;

                // 현재 칸의 주변 4칸 중 청소되지 않은 칸이 있을 경우 false
                if(!visited[dx][dy] && map[dx][dy] == 0)
                    isClear  = false;
            }

            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if(isClear)
            {
                int dx=-1, dy=-1;

                // 2-1. 바라보는 방향을 유지한 채로 한 칸 후진
                switch (cur.d)
                {
                    case 0:
                        dx = cur.x + rangeX[2];
                        dy = cur.y + rangeY[2];
                        break;

                    case 1:
                        dx = cur.x + rangeX[3];
                        dy = cur.y + rangeY[3];
                        break;

                    case 2:
                        dx = cur.x + rangeX[0];
                        dy = cur.y + rangeY[0];
                        break;

                    case 3:
                        dx = cur.x + rangeX[1];
                        dy = cur.y + rangeY[1];
                        break;
                }

                // 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춤
                if(map[dx][dy] == 1)
                {
                    result = cur.cnt;
                    break;
                }

                queue.add(new Robot(dx,dy,cur.d,cur.cnt));
            }
            // 3. 현재 칸의 주변 4 칸 중 청소되지 않은 빈 칸이 있는 경우
            else
            {
                for(int i=0; i<4; i++)
                {
                    if(cur.d == 0)
                        cur.d = 3;
                    else
                        cur.d--;

                    int dx = cur.x + rangeX[cur.d];
                    int dy = cur.y + rangeY[cur.d];

                    if(!visited[dx][dy] && map[dx][dy] == 0)
                    {
                        visited[dx][dy] = true;
                        queue.add(new Robot(dx,dy,cur.d,cur.cnt+1));
                        break;
                    }
                }

            }
        }

        System.out.println(result);

    }

    static class Robot
    {
        int x, y, d, cnt;

        Robot(int x, int y, int d, int cnt)
        {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = cnt;
        }
    }
}
