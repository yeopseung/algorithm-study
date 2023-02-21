package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2493
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Tower> stack = new Stack<>();
        int N;
        int[] result;
        N = Integer.parseInt(br.readLine());
        result = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
        {
            Tower cur = new Tower(Integer.parseInt(st.nextToken()),i);

            while(!stack.isEmpty())
            {
                Tower top = stack.peek();
                if(top.height >= cur.height)
                {
                    result[cur.index] = top.index;
                    break;
                }
                else
                    stack.pop();
            }

            stack.add(cur);
        }

        for(int i=1; i<=N; i++)
            sb.append(result[i]+" ");
        System.out.println(sb);
    }

    static class Tower
    {
        int height, index;

        Tower(int height, int index)
        {
            this.height = height;
            this.index = index;
        }
    }
}
