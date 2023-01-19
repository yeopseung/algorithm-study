package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16562
{
    static int N, M, K;
    static int[] parent, cost;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // N: 학생 수
        N = Integer.parseInt(st.nextToken());
        // M: 친구관계 수
        M = Integer.parseInt(st.nextToken());
        // K: 가지고 있는 돈
        K = Integer.parseInt(st.nextToken());

        // cost[i]: i 학생을 사귀는데 필요한 친구비
        st = new StringTokenizer(br.readLine());
        cost = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        // parent[i]: i 학생의 연결 관계 배열 (부모 관계)
        parent = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            parent[i] = i;
        }

        // 친구 관계 입력
        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());

        }

        // 친구로 묶고
        // 그 묶음에서 최소 비용 더해줌

    }

    // x 학생의 최상위 부모를 찾아서 리턴
    private static int find(int x)
    {
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }


    // 두가지를 하나의 부모 인덱스로 합침
    private static void union(int x, int y)
    {
        x = find(x);
        y = find(y);

        // if x = 2, y = 3
        // parent[3] = 2;
        if(x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }
}
