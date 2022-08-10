package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1941 {
    static int[] rangeX = {0,0,1,-1};
    static int[] rangeY = {-1,1,0,0};

    static final int N = 5;
    static int result=0;
    static boolean[][] visit;
    static String[][] classroom;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        //입력
        classroom = new String[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; i++)
        {
            str = br.readLine();
            classroom[i] = str.split("");
        }


        //dfs 탐색색
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                visit = new boolean[N][N];
                if(classroom[i][j].equals("S"))
                    dfs(i,j,1,1);
                else
                    dfs(i,j,1,0);
            }
        }

        System.out.println(result);
    }


    // classroom[i][j] 에서 탐색 시작
    // seven: 7명인지 카운트
    // count: 이다솜파 명 수
    static void dfs(int x, int y, int seven, int count)
    {
        visit[x][y] = true;
        //System.out.println("xy "+ x +""+y + " seven "+seven+" count "+count);
        //7명을 만들었을 경우 -> 종료
        if(seven == 7)
        {
            //이다솜파가 4명 이상인 경우 -> result +1
            if(count >= 4)
            {
                result++;
            }
            //종료
            return;
        }

        //상하좌우 탐색
        for(int i=0; i<4; i++)
        {

            int dx = x + rangeX[i];
            int dy = y + rangeY[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                continue;
            }

            if(!visit[dx][dy])
            {
                //이다솜파일 경우 -> seven, count + 1
                if(classroom[dx][dy].equals("S"))
                {
                    dfs(dx,dy,seven+1,count+1);
                }
                //아닐 경우 -> seven +1
                else
                {
                    dfs(dx,dy,seven+1,count);
                }

            }

        }
    }

}
