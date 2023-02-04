package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_11723
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<Integer> set = new HashSet<>();
        String command;
        int M, num;

        // M: 수행해야하는 연산의 횟수
        M = Integer.parseInt(br.readLine());

        // 연산 횟수만큼 진행
        for(int m=0; m<M; m++)
        {
            st = new StringTokenizer(br.readLine());
            // command: 명령어
            command = st.nextToken();


            switch (command)
            {
                case "add":
                    // num: 값
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "check":
                    // num: 값
                    num = Integer.parseInt(st.nextToken());
                    if(set.contains(num))
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "remove":
                    // num: 값
                    num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "toggle":
                    // num: 값
                    num = Integer.parseInt(st.nextToken());
                    if(set.contains(num))
                        set.remove(num);
                    else
                        set.add(num);
                    break;
                case "all":
                    set.clear();
                    for(int i=1; i<=20; i++)
                        set.add(i);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
    }
}
