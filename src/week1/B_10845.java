package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class B_10845
{
    public static void main(String[] args) throws IOException {
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        Queue queue;

        //처리할 명령어 수
        N = Integer.parseInt(br.readLine());

        //Queue 생성
        queue = new Queue();

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken())
            {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.pop() + "\n");
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    sb.append(queue.empty() + "\n");
                    break;
                case "front":
                    sb.append(queue.front() + "\n");
                    break;
                case "back":
                    sb.append(queue.back() + "\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}

class Queue
{
    private ArrayList<Integer> list;

    public Queue()
    {
        list = new ArrayList<>();
    }

    void push(int X)
    {
        list.add(X);
    }

    int pop()
    {
        int result;
        if(list.size() == 0)
        {
            return -1;
        }
        else
        {
            result = list.get(0);
            list.remove(0);
            return result;
        }
    }

    int size()
    {
        return list.size();
    }

    int empty()
    {
        if(list.size() == 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    int front()
    {
        if(list.size() == 0)
        {
            return -1;
        }
        else
        {
            return list.get(0);
        }
    }

    int back()
    {
        if(list.size() == 0)
        {
            return -1;
        }
        else
        {
            return list.get(list.size()-1);
        }
    }

}