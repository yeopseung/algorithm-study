package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20040
{
    private static int N, M;
    private static int[] parent;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // N: 점의 개수
        N = Integer.parseInt(st.nextToken());
        // M: 테스트 횟수
        M = Integer.parseInt(st.nextToken());

        // 초기값 설정
        parent = new int[N];
        for(int i=0; i<N; i++)
            parent[i] = i;

        for(int m=1; m<=M; m++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(findParent(x,y))
            {
                System.out.println(m);
                return;
            }
            else
                unionParent(x,y);

        }

        System.out.println(0);
    }

    // 두 정점의 부모를 합침
    private static void unionParent(int x, int y)
    {
        x = getParent(x);
        y = getParent(y);

        if(x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    // 최상위 부모를 return
    private static int getParent(int x)
    {
        if(parent[x] == x)
            return x;
        else
            return parent[x] = getParent(parent[x]);
    }

    // 두 정점의 최상위 부모를 찾아 같으면 true
    private static boolean findParent(int x, int y)
    {
        if(getParent(x) == getParent(y))
            return true;
        else
            return false;
    }
}
