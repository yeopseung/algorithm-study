import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_10828 {
    public static void main(String[] args) {
        int N, num, x;

        Stack stack;
        Scanner scanner = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        N = scanner.nextInt();
        stack = new Stack(N);

        for (int i = 0; i < N; i++)
        {
            String str = scanner.next();


            switch (str)
            {
                case "push":
                    stack.push(scanner.nextInt());
                    break;

                case "pop":
                    num = stack.pop();
                    sb.append(num + "\n");
                    break;

                case "size":
                    num = stack.size();
                    sb.append(num + "\n");
                    break;

                case "empty":
                    num = stack.empty();
                    sb.append(num + "\n");
                    break;

                case "top":
                    num = stack.top();
                    sb.append(num + "\n");
                    break;
            }

        }
        System.out.println(sb);

    }
}

class Stack {
    private int size;
    private int top;
    private int[] list;

    public Stack(int N) {
        size = 0;
        list = new int[N];
    }

    void push(int x) {
        list[size] = x;
        size++;
    }

    int pop() {
        if (size == 0)
        {
            return -1;
        }
        else {
            top = list[size-1];
            list[size-1] = 0;
            size--;
            return top;
        }
    }

    int size()
    {
            return size;
    }

    int empty() {
        if (size == 0) {
            return 1;
        } else
            return 0;
    }

    int top()
    {
        if(size ==0)
        {
            return -1;
        }
        else
        {
            top = list[size-1];
            return top;
        }
    }


}