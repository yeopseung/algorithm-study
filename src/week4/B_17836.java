package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17836 {
    public static void main(String[] args) throws IOException {
        int N, M, T;
        int[][] map;
        boolean[][][] visit;
        boolean sword = false;
        int[] rangeX = { -1, 0, 1, 0 };
        int[] rangeY = { 0, 1, 0, -1 };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][2];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //BFS
        Queue<Block> queue = new LinkedList<>();
        Block root;
        int count = -1;

        queue.add(new Block(0,0,0,false));
        visit[0][0][0] = true;
        while(!queue.isEmpty())
        {
            root = queue.poll();

            //(N, M) 에 도착하거나  count 가 T 를 초과했을 때 종료
            if(root.x == N-1 && root.y == M-1)
            {
                count = root.count;
                break;
            }
            if(root.count > T)
            {
                count = -1;
                break;
            }


            //System.out.println(root.x +" "+ root.y +  " "+ root.count);

            int dx, dy;
            for (int i = 0; i < 4; i++) {
                dx = root.x  + rangeX[i];
                dy = root.y + rangeY[i];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }

                //그람을 줍지 않은 상태일 때
                //방문표시 visit [][][0] 사용
                if (!root.sword)
                {
                    // 방문하지 않은 블록이며
                    if(!visit[dx][dy][0])
                    {
                        switch (map[dx][dy])
                        {
                            //빈칸일 경우
                            case 0:
                                //queue 에 dx, dy, 깊이 +1, 그람을 줍지않은 상태 전달
                                queue.add(new Block(dx,dy,root.count+1, false));
                                visit[dx][dy][0] = true;
                                break;
                            //벽일 경우
                            case 1:
                                break;
                            //그람일 경우
                            case 2:
                                //queue 에 dx, dy, 깊이 +1, 그람을 주운 상태 전달
                                queue.add(new Block(dx,dy,root.count+1,true));
                                visit[dx][dy][0] = true;
                                break;
                        }
                    }
                }
                //그람을 주운 상태일 때
                //방문표시 visit [][][1] 사용
                else
                {
                    // 빈공간, 벽, 그람 모든 블록을 지나갈 수 있음
                    if(!visit[dx][dy][1])
                    {
                        //queue 에 dx, dy, 깊이 +1, 그람을 주운 상태 전달
                        queue.add(new Block(dx,dy,root.count+1, true));
                        visit[dx][dy][1] = true;
                    }
                }

            }

        }

        // ( N, M )으로 갈 수 없거나 T를 초과했을 경우 실패
        if(count == -1)
            System.out.println("Fail");
        // 결과 출력
        else
            System.out.println(count);

    }
}

class Block
{
    int x,y;
    int count;
    boolean sword;

    Block(int x, int y, int count, boolean sword)
    {
        this.x = x;
        this.y = y;
        this.count = count;
        this.sword = sword;
    }
}