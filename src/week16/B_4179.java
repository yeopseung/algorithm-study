package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4179
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;

        int R, C, x=0, y=0, f_x=0, f_y=0;
        int[] rangeX = {-1,1,0,0}, rangeY = {0,0,1,-1};
        int[][] f_map;
        char[][] map;
        boolean[][] visited;

        st = new StringTokenizer(br.readLine());
        // R: 행
        R = Integer.parseInt(st.nextToken());
        // C: 열
        C = Integer.parseInt(st.nextToken());

        // 지도 상태 입력
        map = new char[R][C];

        // f_map[][]: 불이 번지는 경로를 저장할 배열
        f_map = new int[R][C];
        for(int i=0; i<R; i++)
            Arrays.fill(f_map[i],Integer.MAX_VALUE);

        // visited[][]: 방문체크 배열
        visited = new boolean[R][C];

        Queue<Position> queue = new LinkedList<>();
        for(int i=0; i<R; i++)
        {
            str = br.readLine();
            for(int j=0; j<C; j++)
            {
                map[i][j] = str.charAt(j);

                // 지훈이의 초기 위치
                if(map[i][j] == 'J')
                {
                    x = i;
                    y = j;
                }

                // 불의 초기 위치
                if(map[i][j] == 'F')
                {
                   queue.add(new Position(i,j,0));
                   f_map[i][j] = 0;
                   visited[i][j] = true;
                }
            }
        }

        // 불의 경로 BFS
        while(!queue.isEmpty())
        {
            Position cur = queue.poll();

            for(int i=0; i<4; i++)
            {
                int f_dx = cur.x + rangeX[i];
                int f_dy = cur.y + rangeY[i];

                if(f_dx<0 || f_dx>=R || f_dy<0 || f_dy>=C)
                    continue;

                if(!visited[f_dx][f_dy])
                {
                    if(map[f_dx][f_dy] != '#' && map[f_dx][f_dy] != 'J')
                    {
                        f_map[f_dx][f_dy] = cur.cnt +1;
                        visited[f_dx][f_dy] = true;

                        queue.add(new Position(f_dx,f_dy,cur.cnt+1));
                    }
                }
            }
        }

        // visited[][]: 방문체크 배열
        visited = new boolean[R][C];


        // 불의 경로 BFS 초기값 설정
        queue.clear();
        queue.add(new Position(x, y,0));
        visited[x][y] = true;

        while(!queue.isEmpty())
        {
            Position cur = queue.poll();

            if(cur.x == 0 || cur.x == R-1 || cur.y == 0 || cur.y == C-1)
            {
                System.out.println(cur.cnt+1);
                return;
            }

            for(int i=0; i<4; i++)
            {
                int dx = cur.x + rangeX[i];
                int dy = cur.y + rangeY[i];

                if(dx<0 || dx>=R || dy<0 || dy>=C)
                    continue;

                if(!visited[dx][dy])
                {
                    if(map[dx][dy] != '#' && map[dx][dy] != 'F')
                    {
                        if((cur.cnt+1) < f_map[dx][dy])
                        {
                            queue.add(new Position(dx,dy,cur.cnt+1));
                            visited[dx][dy] = true;
                        }
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");

    }

    static class Position
    {
        int x, y, cnt;

        Position(int x, int y, int cnt)
        {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
