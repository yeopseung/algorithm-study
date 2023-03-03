package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13460
{
    private static final int[] rangeX = {-1,1,0,0};
    private static final int[] rangeY = {0,0,1,-1};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;

        int N, M, RX=0, RY=0, BX=0, BY=0, OX=0, OY=0;
        boolean r_isEnd, b_isEnd;
        char[][] map;
        Queue<Location> queue;

        st = new StringTokenizer(br.readLine());
        // NxM의 맵 크기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0; i<N; i++)
        {
            str = br.readLine();
            for(int j=0; j<M; j++)
            {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'R')
                {
                    RX = i;
                    RY = j;
                }
                if(map[i][j] == 'B')
                {
                    BX = i;
                    BY = j;
                }
                if(map[i][j] == 'O')
                {
                    OX = i;
                    OY = j;
                }
            }
        }

        queue = new LinkedList<>();
        queue.add(new Location(RX,RY,BX,BY,0));

        while (!queue.isEmpty())
        {
            Location cur = queue.poll();

            // 10번 이상 움직였을 경우 -> pass
            if(cur.cnt >= 10)
                continue;

            for(int i=0; i<4; i++)
            {
                int cur_rx = cur.rx;
                int cur_ry = cur.ry;
                int r_length = 0;
                int cur_bx = cur.bx;
                int cur_by = cur.by;
                int b_length = 0;

                r_isEnd = false;
                b_isEnd = false;

                // 빨간 공의 움직임
                while(true)
                {
                    // 구멍에 도착했을 경우
                    if(cur_rx == OX && cur_ry == OY)
                    {
                        r_isEnd = true;
                        break;
                    }

                    // 벽을 만났을 경우 -> 이동 중지
                    if(map[cur_rx + rangeX[i]][cur_ry+rangeY[i]] == '#')
                        break;

                    cur_rx += rangeX[i];
                    cur_ry += rangeY[i];
                    r_length++;
                }

                // 파란 공의 움직임
                while(true)
                {
                    // 구멍에 도착했을 경우
                    if(cur_bx == OX && cur_by == OY)
                    {
                        b_isEnd = true;
                        break;
                    }

                    // 벽을 만났을 경우 -> 이동 중지
                    if(map[cur_bx + rangeX[i]][cur_by+rangeY[i]] == '#')
                        break;

                    cur_bx += rangeX[i];
                    cur_by += rangeY[i];
                    b_length++;
                }

                // 빨간 공과 파란 공의 위치가 겹치지 않게 처리
                if(cur_rx == cur_bx && cur_ry == cur_by)
                {
                    if(r_length < b_length)
                    {
                        // 빨간 공이 앞에 있었을 경우 파란 공을 뒤로 한칸
                        cur_bx -= rangeX[i];
                        cur_by -= rangeY[i];
                    }
                    else
                    {
                        // 파란 공이 앞에 있었을 경우 빨간 공을 뒤로 한칸
                        cur_rx -= rangeX[i];
                        cur_ry -= rangeY[i];
                    }
                }

                // 빨간 공은 구멍에 들어갔지만 파란 공은 들어가지 않았을 경우 -> 종료
                if(r_isEnd && !b_isEnd)
                {
                    System.out.println(cur.cnt+1);
                    return;
                }
                // 빨간 공은 들어가지 않았지만 파란 공은 들어간 경우 -> pass
                else if (!r_isEnd && b_isEnd)
                    continue;
                    // 둘 다 들어간 경우 -> pass
                else if(r_isEnd && b_isEnd)
                    continue;

                // 둘 다 안들어간 경우 -> 다음
                queue.add(new Location(cur_rx,cur_ry,cur_bx,cur_by,cur.cnt+1));

            }
        }

        System.out.println(-1);

    }

    static class Location
    {
        int rx, ry, bx, by, cnt;

        Location(int rx, int ry, int bx, int by, int cnt)
        {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
}
