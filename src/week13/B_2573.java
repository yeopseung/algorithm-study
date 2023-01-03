package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2573
{
    static int N, M, year;
    static int[] rangeX = {-1,1,0,0};
    static int[] rangeY = {0,0,1,-1};
    static int[][] map;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N,M : 맵의 크기 NXM
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // map[][] : 빙하의 정보를 저장하는 지도
        map = new int[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 빙하를 녹인다
        // 2. 빙하의 개수를 센다
        // 3-1. 빙하의 개수가 2개 이상이면 종료하고 년도를 출력한다
        // 3-2. 빙하가 전부 녹아도 빙하의 개수가 2개 이하면 0을 출력한다.

        year = 0;
        int count_res;

        while(true)
        {
            melt();
            year++;

            count_res = count();

            if(count_res == 0)
            {
                year = 0;
                break;
            }

            if(count_res >=2)
            {
                break;
            }



        }

        System.out.println(year);


    }

    // 빙하를 녹이는 함수
    private static void melt()
    {
        int[][] copy_map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int cnt;

        // 지도를 순회하며 빙하 타일을 탐색
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(map[i][j] != 0 && !visited[i][j])
                {
                    cnt = 0;
                    visited[i][j] = true;
                    for(int k=0; k<4; k++)
                    {
                        int dx = i + rangeX[k];
                        int dy = j + rangeY[k];

                        if(map[dx][dy] == 0)
                        {
                            cnt++;
                        }

                    }
                    if((map[i][j] - cnt) < 0)
                    {
                        copy_map[i][j] =0;
                    }
                    else
                        copy_map[i][j] = map[i][j] - cnt;
                }
            }
        }

        for(int i=0; i<N; i++)
            map[i] = copy_map[i].clone();
    }

    private static int count()
    {
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(map[i][j] != 0 && !visited[i][j])
                {
                    cnt++;

                    Queue<Location> queue = new LinkedList<>();
                    queue.add(new Location(i,j));

                    while(!queue.isEmpty())
                    {
                        Location curLocation = queue.remove();
                        visited[curLocation.x][curLocation.y] = true;

                        for(int k=0; k<4; k++)
                        {
                            int dx = curLocation.x + rangeX[k];
                            int dy = curLocation.y + rangeY[k];

                            if(dx<0 || dy<0 || dx>=N || dy>=M)
                                continue;

                            if(map[dx][dy] != 0 && !visited[dx][dy])
                            {
                                visited[dx][dy] = true;
                                queue.add(new Location(dx,dy));
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }

    static class Location
    {
        int x, y;

        Location(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}

