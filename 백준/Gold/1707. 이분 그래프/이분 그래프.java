import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int K, V, E, u,v;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        Graph graph;

        K = Integer.parseInt(br.readLine());


        for(int i=0; i<K; i++)
        {
            //V,E 입력
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            //초기화
            graph = new Graph(V);

            //Edge 입력
            for(int j=0; j<E; j++)
            {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());

                graph.addEdge(u,v);
            }

            //dfs
            for(int j=1; j<=V; j++)
            {
                if(!graph.nodes[j].marked)
                    graph.dfs(j);
            }

            if(graph.result)
                System.out.println("YES");
            else
                System.out.println("NO");


        }

    }
}

class Graph
{
    class Node
    {
        int data;
        int num;
        boolean marked;
        LinkedList<Integer> adjacent;

        Node(int data)
        {
            this.data = data;
            marked = false;
            num =0;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;
    static boolean result;
    static boolean R,B;

    Graph(int size)
    {
        nodes = new Node[size+1];
        result = true;

        for(int i=1; i<=size; i++)
        {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2)
    {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];


        n1.adjacent.add(i2);
        n2.adjacent.add(i1);

    }

    void dfs(Node r)
    {
        if(r==null)
            return;
        r.marked = true;
        //visit(r);


        for(int index: r.adjacent)
        {
            Node n = nodes[index];
            if(r.num == n.num)
            {
                result = false;
                return;
            }


            if(!n.marked && n.num ==0)
            {
                if(r.num ==1)
                    n.num = 2;
                else if(r.num == 2)
                    n.num = 1;
                dfs(n);
            }
        }
    }

    void dfs(int index)
    {
        Node r = nodes[index];
        r.num = 1;
        dfs(r);
    }

    void visit(Node n)
    {
        System.out.print(n.data+" ");
    }

}
