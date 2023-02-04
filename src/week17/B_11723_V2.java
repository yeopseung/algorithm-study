package week17;

import java.io.*;
import java.util.StringTokenizer;

public class B_11723_V2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String command;
        int M, num;
        int set=0, res;

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
                    num = Integer.parseInt(st.nextToken());
                    set = set | (1<<num);
                    break;

                case "check":
                    num = Integer.parseInt(st.nextToken());
                    res = set & (1<<num);
                    if(res != 0)
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;

                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set = set & ~(1<< num);
                    break;

                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    set = set ^ (1<<num);
                    break;

                case "all":
                    set = Integer.MAX_VALUE;
                    break;

                case "empty":
                    set = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
