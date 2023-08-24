import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int M, N, result=-1;
        int[] rangeX = {0,0,1,-1};
        int[] rangeY = {-1,1,0,0};
        int[][] list;
        boolean[][] visit;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Tomato> queue = new LinkedList<>();
        StringTokenizer st;
        Tomato tomato;



        //입력
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        list = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                if((list[i][j] = Integer.parseInt(st.nextToken())) == 1)
                {
                    queue.add(new Tomato(i,j,0));
                    visit[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty())
        {
            tomato = queue.poll();
            if(queue.isEmpty())
                result = tomato.day;


            for(int i=0; i<4; i++)
            {
                int dx = tomato.x + rangeX[i];
                int dy = tomato.y + rangeY[i];

                if(dx <0 || dy <0 || dx>=N || dy >= M)
                    continue;

                if(!visit[dx][dy])
                {
                    switch (list[dx][dy])
                    {
                        case -1:
                        case 1:
                            visit[dx][dy] = true;
                            break;

                        case 0:
                            list[dx][dy] = 1;
                            visit[dx][dy] = true;
                            queue.add(new Tomato(dx,dy, tomato.day+1));
                    }
                }
            }

        }


        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(list[i][j] == 0)
                {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result);

    }
}

class Tomato
{
    int x,y;
    int day;

    Tomato(int x, int y, int day)
    {
        this.x = x;
        this.y = y;
        this.day = day;
    }

}
