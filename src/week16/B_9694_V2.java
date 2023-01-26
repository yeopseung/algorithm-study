package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_9694_V2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb;

        ArrayList<ArrayList<Node>> graph;
        Stack<Integer> path;
        int T, N, M;
        int[] dist, parent;

        // T: 테스트 케이스 개수
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++)
        {
            sb = new StringBuffer();

            st = new StringTokenizer(br.readLine());
            // N: 관계(간선)의 개수
            N = Integer.parseInt(st.nextToken());
            // M: 정치인(정점)의 수
            M = Integer.parseInt(st.nextToken());

            // 각 정치인의 관계를 저장할 ArrayList 선언
            graph = new ArrayList<>();
            for(int i=0; i<=M; i++)
            {
                graph.add(new ArrayList<>());
            }

            // 관계 입력
            int start, end, cost;
            for(int i=0; i<N; i++)
            {
                st = new StringTokenizer(br.readLine());

                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Node(end, cost));
                graph.get(end).add(new Node(start, cost));
            }

            dist = new int[M+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            path = new Stack<>();
            parent = new int[M+1];
            Arrays.fill(parent,-1);

            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.cost - o2.cost;
                }
            });

            pq.add(new Node(0,0));
            dist[0] = 0;

            Node curNode, nextNode;
            while(!pq.isEmpty())
            {
                curNode = pq.poll();

                if(dist[curNode.index] < curNode.cost)
                    continue;

                for(int i=0; i<graph.get(curNode.index).size(); i++)
                {
                    nextNode = graph.get(curNode.index).get(i);

                    if(dist[nextNode.index] > nextNode.cost + curNode.cost)
                    {
                        dist[nextNode.index] = nextNode.cost + curNode.cost;
                        pq.add(new Node(nextNode.index, dist[nextNode.index]));

                        parent[nextNode.index] = curNode.index;
                    }
                }
            }

            if (dist[M-1] == Integer.MAX_VALUE)
                System.out.println("Case #"+t+": -1");
            else {
                Stack<Integer> stack = new Stack<>();

                for (int i = (M-1); i > 0;) {
                    stack.push(i = parent[i]);
                }

                System.out.println("Case #"+t+": ");

                while(!stack.empty()) {
                    System.out.printf(" %d",stack.pop());
                }

                System.out.printf(" %d\n",M-1);
            }

        }
    }


    static class Node
    {
        int index, cost;

        Node(int index, int cost)
        {
            this.index = index;
            this.cost = cost;
        }
    }
}
