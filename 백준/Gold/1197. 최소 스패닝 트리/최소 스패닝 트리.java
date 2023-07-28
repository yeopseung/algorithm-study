

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    static int V, E, result;
    static int[] parent;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        result = 0;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i=1; i<=V; i++)
            parent[i] = i;


        PriorityQueue<Node> graph = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        for(int i=0; i<E; i++)
        {
            st = new StringTokenizer(br.readLine());
            graph.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while(!graph.isEmpty())
        {
            Node cur = graph.poll();

            if(!findParent(cur.x,cur.y))
            {
                unionParent(cur.x, cur.y);
                result += cur.weight;
            }
        }

        System.out.println(result);
    }

    private static void unionParent(int x, int y)
    {
        x = getParent(x);
        y = getParent(y);

        if(x<y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    private static int getParent(int x)
    {
        if(x == parent[x])
            return x;
        else
            return parent[x] = getParent(parent[x]);
    }

    private static boolean findParent(int x, int y)
    {
        if(getParent(x) == getParent(y))
            return true;
        else
            return false;
    }

    static class Node
    {
        int x, y, weight;

        Node(int x, int y, int weight)
        {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
