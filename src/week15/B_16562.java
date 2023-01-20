package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_16562
{
    static int N, M, K, sum;
    static int[] parent, cost, result;

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
            // 초기값은 자기 자신
            parent[i] = i;
        }

        // 친구 관계 입력
        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());
            // 두 친구 관계를 부모 인덱스로 합침 Union
            unionParent(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        // 순서가 정렬되어있지 않은 union find 의 경우 갱신 과정 필요
        for(int i=1; i<=N; i++)
        {
            // 친구 관계 갱신
            getParent(i);
        }

        // 그 묶음에서 최소 비용 더해줌
        result = new int[N+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        for(int i=1; i<=N; i++)
        {
            if(result[parent[i]] >= cost[i])
                result[parent[i]] = cost[i];

        }

        sum = 0;
        for(int i=1; i<=N; i++)
        {
            if(result[i] != Integer.MAX_VALUE)
                sum += result[i];
        }

        if(K < sum)
            System.out.println("Oh no");
        else
            System.out.println(sum);

    }

    // x 학생의 최상위 부모를 찾아서 리턴
    private static int getParent(int x)
    {
        if(parent[x] == x)
            return x;
        else
            return parent[x] = getParent(parent[x]);
    }


    // 두가지를 하나의 부모 인덱스로 합침
    private static void unionParent(int x, int y)
    {
        x = getParent(x);
        y = getParent(y);

        // if x = 2, y = 3
        // parent[3] = 2;
        if(x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    // 두 개의 노드가 같은 부모인지 확인하는 함수
    private static boolean findParent(int x, int y){
        int t1 = getParent(x);
        int t2 = getParent(y);

        if(t1 != t2)
            return true;
        else
            return false;
    }

}
