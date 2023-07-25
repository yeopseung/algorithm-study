import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, u, v;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Graph graph;

        //입력
        N = Integer.parseInt(br.readLine());
        graph = new Graph(N);
        for(int i=0; i<N-1; i++)
        {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.addEdge(u,v);
        }

        //탐색 시작
        graph.dfs(graph.nodes[1]);

        //결과 출력
        System.out.println(Math.min(graph.dp[1][0],graph.dp[1][1]));
    }




}

class Graph
{
    class Node
    {
        int data;
        boolean marked;
        LinkedList<Node> adjacent;

        Node(int data)
        {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;
    int[][] dp;


    Graph(int N)
    {
        dp = new int[N+1][2];
        nodes = new Node[N+1];
        for(int i=1; i<=N; i++)
        {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int u, int v)
    {
        Node n1 = nodes[u];
        Node n2 = nodes[v];

        n1.adjacent.add(n2);
        n2.adjacent.add(n1);
    }

    void dfs(Node parent)
    {
        //부모 방문체크
        parent.marked = true;

        //초기값
        //부모가 얼리어답터가 아닌 경우 -> 얼리어답터 개수 0
        dp[parent.data][0] = 0;
        //부모가 얼리어답터인 경우 -> 얼리어답터 개수 1
        dp[parent.data][1] = 1;


        //자식노드 탐색
        for(Node node : parent.adjacent)
        {

            //방문하지 않은 자식노드이며
            if(!node.marked)
            {
                //자식 노드들을 재귀로 방문하여 먼저 계산
                dfs(node);
                //부모가 얼리어답터가 아닌 경우 -> 자식은 무조건 얼리어답터여야함
                dp[parent.data][0] += dp[node.data][1];
                //부모가 얼리어답터인 경우 -> 자식은 얼리어답터 O or X -> 최솟값을 저장하여야함
                dp[parent.data][1] += Math.min(dp[node.data][0],dp[node.data][1]);
            }
        }

    }
}