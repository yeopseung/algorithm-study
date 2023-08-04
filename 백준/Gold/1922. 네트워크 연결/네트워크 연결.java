

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M, result;

        // N: 컴퓨터의 수 (정점)
        N = Integer.parseInt(br.readLine());
        // M: 연결할 수 있는 선의 수 (간선)
        M = Integer.parseInt(br.readLine());

        // parent[]: 초기값은 본인을 가리킴
        parent = new int[N+1];
        for(int i=1; i<=N; i++)
            parent[i] = i;

        // network: 연결할 수 있는 선들을 비용 작은 순으로 정렬해놓은 Priority Queue
        PriorityQueue<Computer> network = new PriorityQueue<>(new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                return o1.weight - o2.weight;
            }
        });

        // 연결할 수 있는 선들의 정보 입력
        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());
            network.add(new Computer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        result = 0;
        while(!network.isEmpty())
        {
            Computer computer = network.poll();

            // 사이클이 없을 경우 추가
            if(!findParent(computer.x, computer.y))
            {
                unionParent(computer.x, computer.y);
                result += computer.weight;
            }
        }

        System.out.println(result);
    }

    private static int getParent(int x)
    {
        if(x == parent[x])
            return x;
        else
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
        else
            return false;
    }

    static class Computer
    {
        int x, y, weight;

        Computer(int x, int y, int weight)
        {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
