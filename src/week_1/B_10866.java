package week_1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_10866 {
    public static void main(String[] args) throws IOException {
        int N, tem;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        Deque deque = new Deque();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken())
            {
                case "push_front":
                    deque.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    tem = deque.pop_front();
                    sb.append(tem+"\n");
                    break;
                case "pop_back":
                    tem = deque.pop_back();
                    sb.append(tem+"\n");
                    break;
                case "size":
                    tem = deque.size();
                    sb.append(tem+"\n");
                    break;
                case "empty":
                    tem = deque.empty();
                    sb.append(tem+"\n");
                    break;
                case "front":
                    tem = deque.front();
                    sb.append(tem+"\n");
                    break;
                case "back":
                    tem = deque.back();
                    sb.append(tem+"\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);

    }
}

class Deque
{
    private ArrayList<Integer> list;

    public Deque()
    {
        list = new ArrayList<>();
    }

    void push_front(int X)
    {
        list.add(0,X);
    }

    void push_back(int X)
    {
        list.add(X);
    }

    int pop_front()
    {
        int num;

        if(list.size() == 0)
        {
            return -1;
        }
        else
        {
            num = list.get(0);
            list.remove(0);
            return num;
        }
    }

    int pop_back()
    {
        int num;

        if(list.size() == 0)
        {
            return -1;
        }
        else
        {
            num = list.get(list.size()-1);
            list.remove(list.size()-1);
            return num;
        }
    }

    int front()
    {
        int num;

        if(list.size() == 0)
        {
            return -1;
        }
        else
        {
            num = list.get(0);
            return num;
        }
    }

    int back()
    {
        int num;

        if(list.size() == 0)
        {
            return -1;
        }
        else
        {
            num = list.get(list.size()-1);
            return num;
        }
    }


    int size()
    {
        return list.size();
    }

    int empty()
    {
        if(list.size() ==0)
            return 1;
        else
            return 0;
    }



}