package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1647 {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M, result, cut;


        st = new StringTokenizer(br.readLine());
        // N: 집의 개수
        N = Integer.parseInt(st.nextToken());
        // M: 길의 개수
        M = Integer.parseInt(st.nextToken());

        // parent: 초기값은 자기 자신
        parent = new int[N+1];
        for(int i=1; i<=N; i++)
            parent[i] = i;

        // graph: 길 들을 비용기준 오름차순으로 정령
        PriorityQueue<Road> pq = new PriorityQueue<>(new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                return o1.cost - o2.cost;
            }
        });

        // 길의 정보 입력
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            pq.add(new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        cut = Integer.MIN_VALUE;
        result = 0;
        while (!pq.isEmpty())
        {
            // 비용이 가장 적은 길부터 연결함
            Road cur = pq.poll();

            // 단 사이클이 없어야함
            if(!findParent(cur.x, cur.y))
            {
                unionParent(cur.x,cur.y);
                // 남아있는 길 중 가장 비용이 큰 길을 끊어서 마을을 두개로 분
                cut = Math.max(cut, cur.cost);
                result += cur.cost;
            }
        }

        System.out.println(result - cut);

    }

    private static int getParent(int x)
    {
        if(x == parent[x])
            return x;

        return parent[x] = getParent(parent[x]);
    }

    private static void unionParent(int x, int y)
    {
        x = getParent(x);
        y = getParent(y);

        if(x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    private static boolean findParent(int x, int y)
    {
        if(getParent(x) == getParent(y))
            return true;

        return false;
    }

    static class Road
    {
        int x, y, cost;

        Road(int x, int y, int cost)
        {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
