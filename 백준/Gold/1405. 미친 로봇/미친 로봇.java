import java.util.Scanner;

public class Main {
    static int[] rangeX = {0,0,1,-1};
    static int[] rangeY = {-1,1,0,0};

    static int n;
    static double E,W,S,N;
    static double result=0;
    static boolean[][] visit;



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        E = sc.nextInt() / 100.0;
        W = sc.nextInt() / 100.0;
        S = sc.nextInt() / 100.0;
        N = sc.nextInt() / 100.0;

        visit = new boolean[31][31];
        visit[15][15] =true;
        dfs(15, 15,1,0);

        System.out.println(result);

    }

    static void dfs(int x, int y, double tem, int depth)
    {


        //이동거리를 충족했을 경우
        if(depth == n)
        {
            result += tem;
            return;
        }


        for(int i=0; i<4; i++)
        {
            int dx = x + rangeX[i];
            int dy = y + rangeY[i];

            if(dx<0 || dy<0 || dx>=30 || dy>=30)
                continue;


            if(!visit[dx][dy])
            {
                visit[dx][dy] = true;
                switch (i)
                {
                    //W
                    case 0:
                        dfs(dx,dy,tem * W,depth+1);
                        visit[dx][dy] = false;
                        break;
                    //E
                    case 1:
                        dfs(dx,dy,tem * E,depth+1);
                        visit[dx][dy] = false;
                        break;
                    //N
                    case 2:

                        dfs(dx,dy,tem * N,depth+1);
                        visit[dx][dy] = false;
                        break;
                    //S
                    case 3:
                        dfs(dx,dy,tem * S,depth+1);
                        visit[dx][dy] = false;
                        break;
                }

            }

        }


    }


}
