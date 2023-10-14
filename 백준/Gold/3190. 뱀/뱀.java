

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer,String> direction = new HashMap<>();
        int N, K, L, X, res;
        int[][] map;
        String C;

        // N: 맵의 크기
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        // K: 사과의 개수
        K = Integer.parseInt(br.readLine());
        for(int k=0; k<K; k++)
        {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }

        // L: 방향 전환 정보 개수
        L = Integer.parseInt(br.readLine());
        for(int l=0; l<L; l++)
        {
            st = new StringTokenizer(br.readLine());
            direction.put(Integer.parseInt(st.nextToken()),st.nextToken());
        }


        Deque<Location> deque = new LinkedList<>();
        deque.add(new Location(1,1));

        // 우하좌상
        int[] rangeX = {0,1,0,-1};
        int[] rangeY = {1,0,-1,0};
        int d=0;
        res = 0;
        while(true)
        {
            res++;
            Location cur = deque.peekFirst();

            int dx = cur.x + rangeX[d];
            int dy = cur.y + rangeY[d];

            if(dx < 1 || dx > N || dy < 1 || dy > N)
            {
                System.out.println(res);
                return;
            }


            for(Location loc: deque)
            {
                if(loc.x == dx && loc.y == dy)
                {
                    System.out.println(res);
                    return;
                }
            }



            if(map[dx][dy] == 2)
            {
                map[dx][dy] = 0;
            }
            else
                deque.pollLast();

            deque.addFirst(new Location(dx,dy));


            if(direction.containsKey(res))
            {
                C = direction.get(res);

                if(C.equals("L"))
                {
                    if(d == 0)
                        d = 3;
                    else
                        d--;
                }
                else
                {
                    if(d == 3)
                        d = 0;
                    else
                        d++;
                }
            }

        }


    }

    static class Location
    {
        int x, y;

        Location(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
