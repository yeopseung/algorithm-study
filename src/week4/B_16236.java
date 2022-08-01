package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_16236 {
    public static void main(String[] args) throws IOException {
        int N;
        int startX=-1, startY=-1;
        int[] rangeX = {-1,0,0,1};
        int[] rangeY = {0,-1,1,0};
        int[][] list;
        int size=2, count=0, result =0;
        boolean[][] visit;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Fish> queue = new PriorityQueue<>(new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                //우선순위
                // 1. 거리가 가장 가까운 물고기       (distance 오름차순)
                // 2. 거리가 같은 경우 맨 위의 물고기    (x좌표 오름차순)
                // 3. 거리가 같으며 같은 맨 위일 경우 맨 왼쪽의 물고기  (y좌표 오름차순)
                if(o1.distance > o2.distance)
                    return 1;
                else if(o1.distance < o2.distance)
                    return -1;

                if(o1.x == o2.x)
                {
                    if(o1.y > o2.y)
                        return 1;
                    else
                        return -1;
                }
                else {
                    if(o1.x > o2.x)
                        return 1;
                    else
                        return -1;
                }
            }
        });



        //입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; i++)
        {
            st =  new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                //상어의 위치일 경우
                if((list[i][j] = Integer.parseInt(st.nextToken())) == 9)
                {
                    queue.add(new Fish(i,j,0));
                    visit[i][j] = true;
                    list[i][j] = 0;
                }
            }
        }


        //BFS
        Fish fish;
        while(!queue.isEmpty())
        {
            fish = queue.poll();

            //상어보다 크기가 작은 물고기
            if((size > list[fish.x][fish.y]) && list[fish.x][fish.y] != 0)
            {
                //System.out.println("x: "+fish.x+ " y: " +fish.y+ " distance: "+ fish.distance);
                //먹음
                list[fish.x][fish.y] = 0;
                count++;
                //크기만큼 물고리를 먹었을 경우
                if(size == count)
                {
                    //사이즈 업
                    size++;
                    count=0;
                }

                //초기화
                queue.clear();
                visit = new boolean[N][N];
                //결과 저장
                result += fish.distance;
                //현재위치에서 다시 시작
                //fish.distance = 0;
                queue.add(new Fish(fish.x,fish.y,0));
                visit[fish.x][fish.y] = true;
                continue;
            }

            for(int i=0; i<4; i++)
            {
                int dx = fish.x + rangeX[i];
                int dy = fish.y + rangeY[i];

                if(dx < 0 || dy < 0 || dx>= N || dy >= N)
                    continue;

               // System.out.println("x: "+dx+ " y: " +dy+ " distance: "+ fish.distance+1);
                if(!visit[dx][dy])
                {
                    //빈칸일 경우
                    if(list[dx][dy] == 0)
                    {
                        //이동할 공간 queue 에 저장
                        queue.add(new Fish(dx,dy,fish.distance+1));
                        visit[dx][dy] = true;
                    }
                    //물고기일 경우
                    else
                    {
                        //상어보다 크기가 작은 물고기
                        if(size > list[dx][dy])
                        {
                            //추가
                            queue.add(new Fish(dx,dy,fish.distance+1));
                            visit[dx][dy] = true;
                        }
                        //상어와 크기가 같은 물고기
                        else if(size == list[dx][dy])
                        {
                            //지나쳐감
                            queue.add(new Fish(dx,dy,fish.distance+1));
                            visit[dx][dy] = true;
                        }
                        //상어보다 크기가 큰 물고기
                        else if(size < list[dx][dy])
                        {
                            //못지나감
                        }
                    }
                }
            }
        }

        System.out.println(result);



    }
}

class Fish
{
    int x,y;
    int distance;

    Fish(int x, int y,int distance)
    {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}