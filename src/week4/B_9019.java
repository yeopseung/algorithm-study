package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_9019
{
    public static void main(String[] args) throws IOException
    {
        // T:테스트 개수 / A: 시작 숫자 / B: 종료 숫자
        int T, A, B;
        boolean[] marked;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = new String();
        Queue<Number> queue = new LinkedList<>();;
        Number root;
        Number d,s,l,r;

        // T 입력
        T = Integer.parseInt(br.readLine());


        int count =0;
        // 테스트 개수만큼 진행
        for(int i=0; i<T; i++)
        {
            // A,B 입력
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 시작 숫자 A queue 에 add
            marked = new boolean[10000];
            queue.clear();
            queue.add(new Number(A,str));

            //bfs 탐색
            while(!queue.isEmpty())
            {
                root = queue.poll();

                // 명령어 D or S or L or  R 한 값이 B 일 경우 탐색 완료
                // B가 아니며 방문하지 않은 숫자일 경우 큐에 저장

                // 명령어 D
                d = new Number(command_d(root.num),root.str+"D");
                if(d.num == B)
                {
                    System.out.println(d.str);
                    break;
                }
                else if(!marked[d.num])
                {
                    queue.add(d);
                    marked[d.num] = true;
                }

                // 명령어 S
                s = new Number(command_s(root.num),root.str+"S");
                if(s.num == B)
                {
                    System.out.println(s.str);
                    break;
                }
                else if(!marked[s.num])
                {
                    marked[s.num] = true;
                    queue.add(s);
                }

                // 명령어 L
                l = new Number(command_l(root.num),root.str+"L");
                if(l.num == B)
                {
                    System.out.println(l.str);
                    break;
                }
                else if(!marked[l.num])
                {
                    marked[l.num] = true;
                    queue.add(l);
                }

                // 명령어 R
                r = new Number(command_r(root.num),root.str+"R");
                if(r.num == B)
                {
                    System.out.println(r.str);
                    break;
                }
                else if(!marked[r.num])
                {
                    marked[r.num] = true;
                    queue.add(r);
                }
            }
        }
    }


    // D 명령어  n -> 2n
    static int command_d(int num)
    {
        int result;

        if((result = num * 2) > 9999)
        {
            return result % 10000;
        }
        else
            return result;
    }

    // S 명령어 n -> n-1
    static int command_s(int num)
    {
        if(num == 0)
        {
            return 9999;
        }
        else
        {
            return num-1;
        }
    }

    // L 명령어 shift left
    // 1234 -> 2341
    static  int command_l(int num)
    {
        int tem, first;
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack  = new Stack<>();

        // num 0~9999
        for(int i=0; i<4; i++)
        {
            // num 을 각 자릿수로 분리
            tem = num % 10;
            num = num / 10;
            stack.add(tem);
        }

        // 맨 앞의 숫자를 pop
        first = stack.pop();

        // 숫자 조합 및 결과 전달
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        sb.append(first);

        return Integer.parseInt(sb.toString());
    }

    // R 명령어 shift right
    // 1234 -> 4123
    static  int command_r(int num)
    {
        int tem, last;
        StringBuffer sb = new StringBuffer();
        Deque<Integer> deque = new LinkedList<>();


        // num 0~9999
        for(int i=0; i<4; i++)
        {
            // num 을 각 자릿수로 분리
            tem = num % 10;
            num = num / 10;
            deque.add(tem);
        }

        // 맨 뒤의 숫자 poll
        last = deque.poll();
        sb.append(last);

        // 숫자 조합 및 결과 전달
        while(!deque.isEmpty())
        {
            sb.append(deque.pollLast());
        }
        return Integer.parseInt(sb.toString());
    }
}

// 숫자 클래스
// num : 숫자 / str : 경로 (ex : DDD...)
class Number
{
    int num;
    String str;
    Number(int num, String str)
    {
        this.num = num;
        this.str = str;
    }
}
