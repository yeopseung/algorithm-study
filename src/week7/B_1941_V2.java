package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1941_V2 {
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

        //25C7 테스트
        combination(new int[7],0,0,7);


        System.out.println(result);
    }


    //25C7
    //0~24 의 숫자들 중 7개를 뽑음
    public static void combination(int[] comb, int index, int count, int left){
        int x,y;

        if(left== 0){
            for(int i=0; i<7; i++)
            {
                System.out.print(comb[i] +" ");

                x= comb[i] / 5;
                y = comb[i] % 5;
                System.out.print(x + "" + y +" ");
            }
            System.out.println();

            //초기값 설정
            visit = new boolean[N][N];
            x = comb[0] / N;
            y = comb[0] % N;
            visit[x][y] = true;
            if(classroom[x][y].equals("S"))
                dfs(x,y,1,1,comb);
            else
                dfs(x,y,1,0,comb);
            return;
        }

        if(count == 25) return;

        comb[index] = count;
        combination(comb,index+1, count+1, left-1);
        combination(comb,index,count+1,left);
    }

    // classroom[i][j] 에서 탐색 시작
    // seven: 7명인지 카운트
    // count: 이다솜파 명 수
    static void dfs(int x, int y, int seven, int count,int[] comb)
    {

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

            for(int j=0; j<7; j++)
            {
                int com_x, com_y;
                com_x = comb[j] / N;
                com_y = comb[j] % N;

                //방문하지 않았으며
                if(!visit[dx][dy] && dx == com_x && dy == com_y )
                {
                    //이다솜파일 경우 -> seven, count + 1
                    if(classroom[dx][dy].equals("S"))
                    {
                        visit[dx][dy] = true;
                        dfs(dx,dy,seven+1,count+1,comb);
                    }
                    //아닐 경우 -> seven +1
                    else
                    {
                        visit[dx][dy] = true;
                        dfs(dx,dy,seven+1,count,comb);
                    }
                }
            }


        }
    }

}
