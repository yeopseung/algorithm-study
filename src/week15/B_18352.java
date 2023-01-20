package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_18352
{
    static ArrayList<ArrayList<Node>> graph;
    static int N, M, K, X;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // N: 도시의 개수
        N = Integer.parseInt(st.nextToken());
        // M: 도로의 개수
        M = Integer.parseInt(st.nextToken());
        // K: 거리 정보
        K = Integer.parseInt(st.nextToken());
        // X: 출발 도시의 번호
        X = Integer.parseInt(st.nextToken());

        // 도시의 개수 N개 만큼, 각 노드의 간선 정보(Node)를 저장할 ArrayList 생성
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++)
        {
            graph.add(new ArrayList<>());
        }

        // 도로 정보 입력
        int start,end;
        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            // 단방향이므로 하나만
            graph.get(start).add(new Node(end,1));
            // 양방향일 경우 반대의 경우도 추가
            //graph.get(end).add(new Node(start,1));
        }

        // 다익스트라 알고리즘 초기화
        int[] dist = new int[N+1]; // 최소 비용을 저장할 배열
        Arrays.fill(dist,Integer.MAX_VALUE);

        // 우선순위 큐 : 다음으로 방문할 노드를 골라주는 역할, 간선 이동 비용이 작은 순으로 추출
        // 우선 순위큐에 들어가는 노드의 수 = 갱신해야하는 주변 노드의 수 = 갱신해야하는 주변 노드로의 간선의 수
        // 우선 순위 큐에 삽입하는 최대 횟수 = 간선의 개수 -> 최대 O(ElogE)
        // 각 노드들을 우선순위큐에 추출해주는 연산에대해서는 최대 V개의 노드에 대하여 우선순위큐에서 추출할 것 -> 최대 O(VlogV)
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        // 시작점부터 비용 0으로 시작
        pq.add(new Node(X,0));
        // 시작점 방문 표시
        dist[X] = 0;


        while(!pq.isEmpty())
        {
            // 현재 노드
            Node curNode = pq.poll();

            // 꺼낸 노드 = 현재 최소 비용을 갖는 노드.
            // 꺼낸 노드의 비용이 최소 비용을 기록하는 dist 배열의 내용보다 크다면 고려할 필요가 없으므로 스킵
            if (dist[curNode.index] < curNode.cost)
                continue;

            // 꺼낸 노드와 간선이 연결되어 있는 노드들의 최소비용을 계산하고 갱신 및 큐에 추가
            for (int i = 0; i < graph.get(curNode.index).size(); i++)
            {
                // 다음으로 방문하려는 노드
                Node nextNode = graph.get(curNode.index).get(i);

                // dist 배열에 저장된 비용보다 현재 노드에서 다음 노드를 방문하는 비용이 더 작은 경우 갱신 및 큐에 추가
               if(dist[nextNode.index] > nextNode.cost + curNode.cost)
                {
                    dist[nextNode.index] = nextNode.cost + curNode.cost;
                    pq.add(new Node(nextNode.index, dist[nextNode.index]));
                }
            }
        }

        for(int i=0; i<=N; i++)
        {
            if(dist[i] == K)
            {
                sb.append(i+"\n");
            }
        }

        if(sb.length() == 0)
            System.out.println(-1);
        else
            System.out.println(sb);

    }

    // index 로 이동하는데 드는 cost 를 저장
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
