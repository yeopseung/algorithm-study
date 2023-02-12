package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B_11559
{
    private static final int N = 12;
    private static final int M = 6;
    private static final int[] rangeX = {-1,1,0,0};
    private static final int[] rangeY = {0,0,1,-1};
    private static char[][] map;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int step = 0;

        map = new char[N][M];
        for(int i=0; i<N; i++)
        {
            map[i] = br.readLine().toCharArray();
        }

        while(true)
        {
            // 1. 연결된 뿌요들 제거
            if(!pop_puyo())
                break;

            // 2. 아래로 떨어지는 뿌요들
            drop_puyo();

            step++;
        }

        System.out.println(step);
    }

    private static boolean pop_puyo()
    {
        Queue<Puyo> queue = new LinkedList<>();
        Stack<Puyo> stack = new Stack<>();
        boolean isPop = false;
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                stack.clear();

                if(map[i][j] != '.' && !visited[i][j])
                {
                    queue.add(new Puyo(i,j));
                    stack.add(new Puyo(i,j));
                    visited[i][j] = true;
                }

                while(!queue.isEmpty())
                {
                    Puyo puyo = queue.poll();

                    for(int k=0; k<4; k++)
                    {
                        int dx = puyo.x + rangeX[k];
                        int dy = puyo.y + rangeY[k];

                        if(dx < 0 || dx>= N || dy < 0 || dy >= M)
                            continue;

                        if(map[puyo.x][puyo.y] == map[dx][dy] && !visited[dx][dy])
                        {
                            visited[dx][dy] = true;
                            queue.add(new Puyo(dx,dy));
                            stack.push(new Puyo(dx,dy));
                        }
                    }
                }

                if(stack.size() >= 4)
                {
                    for(Puyo puyo: stack)
                    {
                        map[puyo.x][puyo.y] = '.';
                        isPop = true;
                    }
                }
            }
        }

        return isPop;
    }

    private static void drop_puyo()
    {
        for(int j=0; j<M; j++)
        {
            int cnt = 0;

            for(int i=N-1; i>=0; i--)
            {
                if(map[i][j] == '.')
                    cnt++;
                else if(map[i][j] != '.' && cnt >0)
                {
                    map[i+cnt][j] = map[i][j];
                    map[i][j] = '.';
                }
            }
        }
    }

    static class Puyo
    {
        int x, y;

        Puyo(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
