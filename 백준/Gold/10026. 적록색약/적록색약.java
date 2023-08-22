import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, count=0, count2=0;
    static char[][] list, list2;
    static boolean[][] marked;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;



        //입력부
        N = Integer.parseInt(br.readLine());
        list = new char[N][N];
        list2 = new char[N][N];
        marked = new boolean[N][N];

        for(int i=0; i<N; i++)
        {
            str = br.readLine();
            for(int j=0; j<N; j++)
            {

                list[i][j] = str.charAt(j);
                list2[i][j] = list[i][j];
            }
        }



        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(!marked[i][j])
                {
                    dfs(i,j,list[i][j]);
                    count++;
                }

            }
        }

        marked = new boolean[N][N];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(!marked[i][j])
                {
                    dfs2(i,j,list[i][j]);
                    count2++;
                }

            }
        }
        System.out.print(count+" "+count2);


    }

    static void dfs(int i, int j, char color)
    {
        marked[i][j] = true;


        if(0<= i-1)
        {
            if(!marked[i-1][j] && color == list[i-1][j])
                dfs(i-1,j,list[i-1][j]);
        }

        if(i+1 < N)
        {
            if(!marked[i+1][j] && color == list[i+1][j])
                dfs(i+1,j,list[i+1][j]);
        }

        if(0<= j-1)
        {
            if(!marked[i][j-1] && color == list[i][j-1])
                dfs(i,j-1,list[i][j-1]);
        }

        if(j+1<N)
        {
            if(!marked[i][j+1] && color == list[i][j+1])
                dfs(i,j+1,list[i][j+1]);
        }
    }

    static void dfs2(int i, int j, char color)
    {
        marked[i][j] = true;


        if(0<= i-1)
        {
            if(!marked[i-1][j])
            {
                switch (color)
                {
                    case 'R':
                    case 'G':
                        if(list[i-1][j] == 'R' || list[i-1][j] =='G')
                            dfs2(i-1,j,list[i-1][j]);
                        break;

                    case 'B':
                        if(color == list[i-1][j])
                            dfs2(i-1,j,list[i-1][j]);
                        break;
                }
            }
        }

        if(i+1 < N)
        {
            if(!marked[i+1][j])
            {
                switch (color)
                {
                    case 'R':
                    case 'G':
                        if(list[i+1][j] == 'R' || list[i+1][j] =='G')
                            dfs2(i+1,j,list[i+1][j]);
                        break;

                    case 'B':
                        if(color == list[i+1][j])
                            dfs2(i+1,j,list[i+1][j]);
                        break;
                }
            }
        }

        if(0<= j-1)
        {
            if(!marked[i][j-1])
            {
                switch (color)
                {
                    case 'R':
                    case 'G':
                        if(list[i][j-1] == 'R' || list[i][j-1] =='G')
                            dfs2(i,j-1,list[i][j-1]);
                        break;

                    case 'B':
                        if(color == list[i][j-1])
                            dfs2(i,j-1,list[i][j-1]);
                        break;
                }
            }
        }

        if(j+1<N)
        {
            if(!marked[i][j+1])
            {
                switch (color)
                {
                    case 'R':
                    case 'G':
                        if(list[i][j+1] == 'R' || list[i][j+1] =='G')
                            dfs2(i,j+1,list[i][j+1]);
                        break;

                    case 'B':
                        if(color == list[i][j+1])
                            dfs2(i,j+1,list[i][j+1]);
                        break;
                }
            }
        }
    }
}
