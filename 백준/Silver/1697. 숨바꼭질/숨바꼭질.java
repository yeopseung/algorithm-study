import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, K;
        int plus,minus,mul;
        boolean[] visit;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Location> queue = new LinkedList<>();
        StringTokenizer st;


        // N, K 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        //초기값 설정
        visit = new boolean[100002];
        queue.add(new Location(N, 0));


        Location location;
        //BFS 탐색
        if(N == K)
            System.out.println(0);
        else
        {
            while(!queue.isEmpty())
            {
                location = queue.poll();

                minus = location.num-1;
                plus = location.num+1;
                mul = location.num*2;

                // +1
                if(plus <= 100000)
                {
                    if(plus == K)
                    {
                        System.out.println(location.count+1);
                        break;
                    }
                    else if(!visit[plus])
                    {
                        queue.add(new Location(plus, location.count+1));
                        visit[plus] = true;
                    }
                }

                // -1
                if(minus >= 0)
                {
                    if(minus == K)
                    {
                        System.out.println(location.count+1);
                        break;
                    }
                    else if(!visit[minus])
                    {
                        queue.add(new Location(minus, location.count+1));
                        visit[minus] = true;
                    }
                }


                // x2
                if(mul <= 100000)
                {
                    if(mul == K)
                    {
                        System.out.println(location.count+1);
                        break;
                    }
                    {
                        queue.add(new Location(mul, location.count+1));
                        visit[mul] = true;
                    }
                }

            }
        }



    }
}

class Location
{
    int num;
    int count;

    Location (int num, int count)
    {
        this.num = num;
        this.count = count;
    }
}
