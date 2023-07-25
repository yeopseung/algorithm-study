import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int[] rangeX = {0,0,1,-1};
    static int[] rangeY = {-1,1,0,0};

    static final int N = 5;
    static int result=0;
    static String[][] classroom;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        //입력
        classroom = new String[N][N];
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
    public static void combination(int[] comb, int index, int count, int left){

        if(left== 0){

            //초기값 설정
            dfs(comb);
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
    static void dfs(int[] comb)
    {
        int seven =1, count = 0;
        boolean[] visit = new boolean[7];
        Stack<Integer> stack = new Stack<>();
        stack.push(comb[0]);


        while(!stack.isEmpty())
        {
            int xy = stack.pop();

            int x = xy / 5;
            int y = xy % 5;


            if(classroom[x][y].equals("S"))
                count++;

            for(int i=0; i<4; i++) {
                for (int j = 1; j < 7; j++)
                {
                    int dx = (comb[j] / 5) + rangeX[i];
                    int dy = (comb[j] % 5) + rangeY[i];

                    if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                        continue;
                    }
                    //방문하지 않았으며
                    if (!visit[j])
                    {
                        //인접하면
                        if(dx == x && dy == y)
                        {
                            visit[j] = true;
                            stack.add(comb[j]);
                            seven++;
                        }

                    }
                }
            }
        }

        if(seven == 7)
        {
            if(count >= 4){
                result++;
            }
        }

    }
}


