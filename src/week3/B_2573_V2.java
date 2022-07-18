package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2573_V2 {
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };
    static int N,M,year=0,split=0;
    static int[][] list;
    static boolean[][] marked;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(true)
        {
            marked = new boolean[N][M];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    if(list[i][j] > 0)
                    {
                        melt(i,j);
                    }
                    //System.out.print(list[i][j] + " ");
                }
                //System.out.println();
            }
            year++;


            marked = new boolean[N][M];
            split =0;
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    if(!marked[i][j] && list[i][j] != 0)
                    {
                        split++;

                        if(split>=2)
                        {
                            System.out.println(year);
                            return;
                        }
                        dfs(i,j);
                    }

                }
            }
            if(split==0)
            {
                System.out.println(0);
                return;
            }
        }

    }

    static void melt(int x, int y)
    {
        int dx, dy;
        int count=0;
        marked[x][y] = true;

        for (int i = 0; i < 4; i++) {
            dx = x + rangeX[i];
            dy = y + rangeY[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                continue;
            }

            if (!marked[dx][dy] && list[dx][dy] == 0) {
                count++;
            }

        }



        if (list[x][y] - count < 0) {
            list[x][y] = 0;
        } else {
            list[x][y] -= count;
        }

    }
    static void dfs(int x, int y)
    {
        marked[x][y] = true;

        int dx, dy;
        for (int i = 0; i < 4; i++) {
            dx = x + rangeX[i];
            dy = y + rangeY[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                continue;
            }

            if (list[dx][dy] != 0 && !marked[dx][dy]) {
                dfs(dx, dy);
            }
        }
    }
}

