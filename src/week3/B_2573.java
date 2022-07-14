package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2573 {
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
                    if(!marked[i][j] && list[i][j] > 0)
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
            for(int i=0; i<N-1; i++)
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
        }

    }

    static void melt(int i, int j)
    {
        int count=0;
        marked[i][j] = true;

        //상
        if(0<= i-1 && i-1 < N)
        {
            if(!marked[i-1][j])
            {
                if(list[i-1][j]>0)
                    melt(i-1,j);
                else
                    count++;
            }
        }

        //하
        if(i+1 < N)
        {
            if(!marked[i+1][j])
            {
                if(list[i+1][j]>0)
                    melt(i+1,j);
                else
                    count++;
            }
        }


        //좌
        if(0<= j-1 && j-1 <M)
        {
            if(!marked[i][j-1])
            {
                if(list[i][j-1]>0)
                    melt(i,j-1);
                else
                    count++;
            }
        }

        //우
        if(j+1 < M)
        {
            if(!marked[i][j+1])
            {
                if(list[i][j+1]>0)
                    melt(i,j+1);
                else
                    count++;
            }
        }




        list[i][j] -= count;
        if(list[i][j] <0)
            list[i][j] =0;

    }
    static void dfs(int i, int j)
    {
        marked[i][j] = true;

        //상
        if(i+1 < N)
        {
            if(!marked[i+1][j] && list[i+1][j] != 0)
                dfs(i+1,j);
        }
        //하
        if(0<= i-1 && i-1 < N)
        {
            if(!marked[i-1][j] && list[i-1][j]  != 0)
                dfs(i-1,j);
        }
        //좌
        if(0<= j-1 && j-1 <M)
        {
            if(!marked[i][j-1] && list[i][j-1]  != 0)
                dfs(i,j-1);
        }
        //우
        if(j+1 < M)
        {
            if(!marked[i][j+1] && list[i][j+1]  != 0)
                dfs(i,j+1);
        }
    }
}

