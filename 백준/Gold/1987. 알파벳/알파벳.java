import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };
    static int R, C, count=0, total;
    static char[][] list;
    static boolean[][] marked;
    static boolean[] alphabet;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;


        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new boolean[26];
        list = new char[R][C];
        marked = new boolean[R][C];
        for(int i=0; i<R; i++)
        {
            str = br.readLine();
            for(int j=0; j<C; j++)
            {
                list[i][j] = str.charAt(j);
            }
        }



        dfs(0,0);
        System.out.println(total);


    }


    static void dfs(int x, int y)
    {
        marked[x][y] = true;
        alphabet[list[x][y]-'A'] = true;
        count++;

        total = Math.max(count,total);
        //System.out.println(list[x][y]);

        int dx, dy;
        for (int i = 0; i < 4; i++) {
            dx = x + rangeX[i];
            dy = y + rangeY[i];

            if (dx < 0 || dy < 0 || dx >= R || dy >= C) {
                continue;
            }

            if (!alphabet[list[dx][dy]-'A']) {
                dfs(dx, dy);
            }
        }
        count--;
        marked[x][y] = false;
        alphabet[list[x][y]-'A'] = false;

    }
}
