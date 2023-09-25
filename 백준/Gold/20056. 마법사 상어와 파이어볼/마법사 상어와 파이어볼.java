

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    // 파이어 볼이 이동하는 8 방향
    private static final int[] rangeX = {-1,-1,0,1,1,1,0,-1};
    private static final int[] rangeY = {0,1,1,1,0,-1,-1,-1};

    private static final int[] odd = {1,3,5,7};
    private static final int[] even = {0,2,4,6};


    private static int N, M, K;
    private static LinkedList<FireBall>[][] map;
    private static Queue<FireBall> fireballs;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // N: NxN 격자 크기
        N = Integer.parseInt(st.nextToken());
        // M: 파이어 볼 개수
        M = Integer.parseInt(st.nextToken());
        // K: 이동 명령 횟수
        K = Integer.parseInt(st.nextToken());

        // map[][]: 파이어볼 이동 위치
        map = new LinkedList[N+1][N+1];
        for(int i=1; i<=N; i++)
            for(int j=1; j<=N; j++)
                map[i][j] = new LinkedList<>();

        // fireballs: 파이어 볼 저장 ArrayList;
        fireballs = new LinkedList<>();
        int r, c, m, s, d;
        for(int i = 0; i<M; i++)
        {
            FireBall fb;

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            fb = new FireBall(r,c,m,s,d);

            fireballs.add(fb);
            map[r][c].add(fb);
        }

        for (int k = 0; k < K; k++)
        {
            // 1. 모든 파이어볼이 이동
            move_fireball();

            // 2. 2개 이상의 파이어볼이 있는 칸
            // 2-1. 같은 칸에 있는 파이어볼이 하나로 합쳐짐
            // 2-2. 파이어볼은 4개로 나누어짐

            // 3. 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
            // 3-1. 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
            // 3-2. 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
            // 3-3. 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.

            // 4. 질량이 0인 파이어볼은 소멸되어 없어진다.

            calc_fireball();

//            for(FireBall fb: fireballs)
//            {
//                System.out.println(fb.x +" "+fb.y+" "+fb.m+" "+fb.s+" "+fb.d);
//            }

        }

        int result=0;
        for(FireBall fb: fireballs)
        {
            result += fb.m;
        }
        System.out.println(result);
    }

    private static void move_fireball()
    {
        int size = fireballs.size();
        int dx, dy;

        FireBall fb, m_fb;

        for(int i=0; i<size; i++)
        {
            fb = fireballs.poll();
            map[fb.x][fb.y].remove(fb);

            dx = fb.x + ((fb.s % N) * rangeX[fb.d]);
            dy = fb.y + ((fb.s % N) * rangeY[fb.d]);

            if(dx > N)
                dx %= N;
            if(dy > N)
                dy %= N;
            if(dx <= 0)
                dx = N-Math.abs(dx);
            if(dy <= 0)
                dy = N-Math.abs(dy);

            m_fb = new FireBall(dx,dy,fb.m,fb.s,fb.d);

            fireballs.add(m_fb);
            map[dx][dy].add(m_fb);
        }

    }

    private static void calc_fireball()
    {
        FireBall fb, n_fb;
        int s_m, s_s;
        int size;
        boolean isOdd, isEven;

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
            {
                size = map[i][j].size();
                s_m = 0;
                s_s = 0;
                isOdd = false;
                isEven = false;

                if(size >= 2)
                {
                    for(int k=0; k<size; k++)
                    {
                        fb = map[i][j].poll();
                        fireballs.remove(fb);

                        s_m += fb.m;
                        s_s += fb.s;

                        if((fb.d % 2) == 0)
                            isEven = true;
                        else
                            isOdd = true;
                    }


                    if(s_m/5 <= 0)
                        continue;

                    if(isEven & isOdd)
                    {
                        for(int k=0; k<4; k++)
                        {
                            n_fb = new FireBall(i,j,s_m/5,s_s/size,odd[k]);

                            fireballs.add(n_fb);
                            map[i][j].add(n_fb);
                        }
                    }
                    else
                    {
                        for(int k=0; k<4; k++)
                        {
                            n_fb = new FireBall(i,j,s_m/5,s_s/size,even[k]);

                            fireballs.add(n_fb);
                            map[i][j].add(n_fb);
                        }
                    }
                }
            }
        }
    }

    static class FireBall
    {
        // x좌표, y좌표, 질량, 속력, 방향
        int x,y,m,s,d;

        FireBall(int x, int y, int m, int s, int d)
        {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }

    }
}
