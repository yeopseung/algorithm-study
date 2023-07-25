
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb;

        ArrayList<ArrayList<Node>> graph;
        ArrayList<Integer> result;
        int T, N, M;
        int[] dist;

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

                graph.get(start).add(new Node(end, cost, new ArrayList<>()));
                graph.get(end).add(new Node(start, cost, new ArrayList<>()));
            }

            dist = new int[M+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.cost - o2.cost;
                }
            });

            ArrayList<Integer> s = new ArrayList<>();
            s.add(0);
            result = new ArrayList<>();
            pq.add(new Node(0,0,s));
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
                        ArrayList<Integer> n = (ArrayList<Integer>) curNode.path.clone();
                        dist[nextNode.index] = nextNode.cost + curNode.cost;
                        n.add(nextNode.index);
                        pq.add(new Node(nextNode.index, dist[nextNode.index], n));

                        if(nextNode.index == M-1)
                        {
                            result = (ArrayList<Integer>) n.clone();
                        }
                    }
                }
            }

            sb.append("Case #"+t+": ");
            if(result.size() > 0)
            {
                for(int k: result)
                {
                    sb.append(k+" ");
                }
                sb.setLength(sb.length()-1);
            }
            else
            {
                sb.append("-1");
            }
            sb.append("\n");

            System.out.println(sb);
        }
    }


    static class Node
    {
        ArrayList<Integer> path;
        int index, cost;

        Node(int index, int cost, ArrayList<Integer> path)
        {
            this.index = index;
            this.cost = cost;
            this.path = path;
        }
    }
}
