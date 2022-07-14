package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2606 {
    public static void main(String[] args) throws IOException {
        int N,M;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        NetWork netWork;


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        netWork = new NetWork(N);
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            netWork.addEdge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        netWork.dfs(1);
        System.out.println(netWork.count);

    }
}

class NetWork
{
    class Computer
    {
        int data;
        boolean marked;
        LinkedList<Computer> adjacent;

        Computer(int data)
        {
            this.data = data;
            marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Computer[] computers;
    int count;

    NetWork(int size)
    {
        computers = new Computer[size+1];
        count = 0;
        for(int i=1; i<=size; i++)
        {
            computers[i] = new Computer(i+1);
        }
    }

    void addEdge(int i1, int i2)
    {
        Computer c1 = computers[i1];
        Computer c2 = computers[i2];

        if(!c1.adjacent.contains(c2))
            c1.adjacent.add(c2);

        if(!c2.adjacent.contains(c1))
            c2.adjacent.add(c1);
    }

    void dfs()
    {
        dfs(0);
    }

    void dfs(int index)
    {
        Computer root = computers[index];
        Stack<Computer> stack = new Stack<>();
        root.marked = true;
        stack.push(root);

        while(!stack.isEmpty())
        {
            Computer r = stack.pop();

            for(Computer n : r.adjacent)
            {
                if(!n.marked)
                {
                    n.marked = true;
                    stack.push(n);
                    count++;
                }
            }

        }
    }
}
