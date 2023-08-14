
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int[][] map;
    static boolean[][] marked;
    static int N;
    static int num=0;      //아파트 단지 개수
    static int[] apart;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings;
        String str;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        marked = new boolean[N][N];
        apart = new int[N*N+1];

        for(int i=0; i<N; i++)
        {
            str = br.readLine();
            strings = str.split("");
            for(int j=0; j<N; j++)
            {
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {

                if(map[i][j] == 1 && !marked[i][j])
                {
                    num++;
                    dfs(i,j);
                }
            }

        }


        System.out.println(num);
        Arrays.sort(apart);
        for(int i=0; i<apart.length ;i++)
        {
            if(apart[i] != 0)
                System.out.println(apart[i]+" ");
        }

    }

    static void dfs(int i, int j)
    {
        marked[i][j] = true;
        apart[num]++;

        //상
        if(0<= i+1 && i+1 < N)
        {
            if(!marked[i+1][j] && map[i+1][j] ==1)
                dfs(i+1,j);
        }
        //하
        if(0<= i-1 && i-1 < N)
        {
            if(!marked[i-1][j] && map[i-1][j] ==1)
                dfs(i-1,j);
        }
        //좌
        if(0<= j-1 && j-1 <N)
        {
            if(!marked[i][j-1] && map[i][j-1] ==1)
                dfs(i,j-1);
        }
        //우
        if(0<= j+1 && j+1 < N)
        {
            if(!marked[i][j+1] && map[i][j+1] ==1)
                dfs(i,j+1);
        }

    }
}
