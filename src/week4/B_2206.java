package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2206 {
    public static void main(String[] args) throws IOException {
        int N, M;
        int distance = -1;
        int[] rangeX = {0,0,1,-1};
        int[] rangeY = {-1,1,0,0};
        int[][] list;
        boolean[][][] visit;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> queue = new LinkedList<>();
        StringTokenizer st;
        String str;
        String[] tem;
        Node node;


        //입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N][M];
        visit = new boolean[N][M][2];
        tem = new String[M];
        for(int i=0; i<N; i++)
        {
            str = br.readLine();
            tem = str.split("");
            for(int j=0; j<M; j++)
            {
                list[i][j] =  Integer.parseInt(tem[j]);
            }
        }


        //BFS
        queue.add(new Node(0,0,1,false));
        visit[0][0][0] = true;
        while(!queue.isEmpty())
        {
            node = queue.poll();

            // (N, M)을 도착했을 때 종료
            if(node.x == N-1 && node.y == M-1)
            {
                distance = node.distance;
                break;
            }



            for(int i=0; i<4; i++)
            {
                int dx = node.x + rangeX[i];
                int dy = node.y + rangeY[i];

                if(dx < 0 || dy <0 || dx>=N || dy>=M)
                    continue;



                //벽을 부수지 않았을 때
                if(!node.isBreak)
                {
                    //방문하지 않았으며
                    if(!visit[dx][dy][0])
                    {
                        //벽이 아닌 경우
                        if(list[dx][dy] == 0)
                        {
                            queue.add(new Node(dx,dy, node.distance+1, node.isBreak));
                            visit[dx][dy][0] = true;
                        }
                        //벽인 경우
                        else if(list[dx][dy] == 1)
                        {
                            queue.add(new Node(dx,dy, node.distance+1,true));
                            visit[dx][dy][1] = true;
                        }
                    }
                }
                //벽을 부쉈을 때
                else
                {
                    //방문하지 않았으며
                    if(!visit[dx][dy][1])
                    {
                        //벽이 아닌 경우
                        if(list[dx][dy] == 0)
                        {
                            queue.add(new Node(dx,dy,node.distance+1, node.isBreak));
                            visit[dx][dy][1] = true;
                        }
                        //벽인 경우
                        else if(list[dx][dy]==1)
                        {
                            visit[dx][dy][1] = true;
                        }
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(distance);

    }
}

class Node
{
    int x,y;
    int distance;
    boolean isBreak;

    public Node(int x, int y, int distance, boolean isBreak)
    {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.isBreak = isBreak;
    }
}
