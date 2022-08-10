package week7;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_1941_V3 {
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
    //0~24 숫자들 중 7개를 뽑음
    public static void combination(int[] comb, int index, int count, int left){

        //25개에서 7개를 골랐을 경우
        if(left== 0){
            //그룹 내 dfs 탐색 시작
            dfs(comb);
            return;
        }

        if(count == 25) return;

        comb[index] = count;
        combination(comb,index+1, count+1, left-1);
        combination(comb,index,count+1,left);
    }

    //그룹 내 탐색
    static void dfs(int[] comb)
    {
        // seven : 칠공주 명 수
        // count : 칠공주 내 이다솜파 명 수
        // visit : dfs 방문 체크
        // stack : dfs 탐색을 위한 stack

        int seven =1, count = 0;
        boolean[] visit = new boolean[7];
        Stack<Integer> stack = new Stack<>();

        //DFS
        stack.push(comb[0]);
        while(!stack.isEmpty())
        {
            //comb[]의 숫자를 classroom[x][y] 로 활용하기 위해 치환
            int xy = stack.pop();
            int x = xy / 5;
            int y = xy % 5;


            //이다솜파일 경우 count +1
            if(classroom[x][y].equals("S"))
                count++;


            //classroom[x][y]를 대상으로
            //그룹내 classroom[x][y]를 인접하고 있는것을 찾음
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
                            //stack 에 추가
                            //seven +1
                            visit[j] = true;
                            stack.add(comb[j]);
                            seven++;
                        }

                    }
                }
            }
        }

        //그룹이 모두 인접했기 때문에 seven 이 7일 경우
        if(seven == 7)
        {
            //이다솜파가 4명이상일 경우
            if(count >= 4){
                //결과 +1
                result++;
            }
        }

    }
}


