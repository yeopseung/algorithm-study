package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_1260 {
    public static void main(String[] args) {
        int N,M,V;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Graph_1260 graph;

        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            graph = new Graph_1260(N);
            for(int i=0; i<M; i++)
            {
                st = new StringTokenizer(br.readLine());
                graph.addEdge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }

            graph.dfsR(V);

            // graph.bfs(V);
            // graph.dfs(V);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Graph_1260
{
    class Node
    {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data)
        {
            this.data = data;
            marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;
    Graph_1260(int size)
    {
        nodes = new Node[size+1];
        for(int i=1; i<=size; i++)
        {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2)
    {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if(!n1.adjacent.contains(n2))
            n1.adjacent.add(n2);

        if(!n2.adjacent.contains(n1))
            n2.adjacent.add(n1);
    }

    void dfs()
    {
        dfs(0);
    }

    void dfs(int index)
    {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while(!stack.isEmpty())
        {
            Node r = stack.pop();

            for(Node n: r.adjacent)
            {
                if(n.marked == false)
                {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void visit(Node n)
    {
        System.out.print(n.data+" ");
    }

    void bfs()
    {
        bfs(0);
    }

    void bfs(int index)
    {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.marked = true;

        while(!queue.isEmpty())
        {
            Node r = queue.poll();

            for(Node n: r.adjacent)
            {
                if(n.marked == false)
                {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
    }


    void dfsR(Node r)
    {
        if(r==null)
            return;
        r.marked = true;
        visit(r);

        for(Node n: r.adjacent)
        {
            if(n.marked == false)
            {
                dfsR(n);
            }
        }
    }

    void dfsR()
    {
        dfsR(0);
    }

    void dfsR(int index)
    {
        Node r = nodes[index];
        dfsR(r);
    }

}
