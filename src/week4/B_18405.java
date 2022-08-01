package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_18405 {
    public static void main(String[] args) throws IOException {
        int N, K, S, X, Y;
        int[] rangeX = {0,0,1,-1};
        int[] rangeY = {-1,1,0,0};
        int[][] list;
        boolean[][] visit;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Virus> arrayList = new ArrayList<>();
        Queue<Virus> queue = new LinkedList<>();

        //입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                if((list[i][j] = Integer.parseInt(st.nextToken())) != 0)
                {
                    //바이러스 일 경우 arrayList 에 저장
                    //바이러스 전파는 오름차순으로 진행하기 때문에 arraylist 로 정렬하기 위함
                    arrayList.add(new Virus(list[i][j],i,j,0));
                    visit[i][j] = true;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());


        //바이러스 번호 오름차순으로 정렬
        //queue 에 저장
        arrayList.sort(Virus::compareTo);
        for(int i=0; i<arrayList.size(); i++)
        {
            queue.add(arrayList.get(i));
        }

        //BFS
        Virus virus;
        while(!queue.isEmpty())
        {
            virus = queue.poll();

            // S초 경과시 종료
            if(virus.day == S)
                break;

            for(int i=0; i<4; i++)
            {
                int dx = virus.x + rangeX[i];
                int dy = virus.y + rangeY[i];

                if(dx <0 || dy <0 || dx>=N || dy >= N)
                    continue;

                //방문하지 않은 블록일 경우
                if(!visit[dx][dy])
                {
                    //해당 virus 의 번호로 list[dx][dy] 변경 및 queue 에 추가
                   list[dx][dy] = virus.num;
                   visit[dx][dy] = true;
                   queue.add(new Virus(list[dx][dy], dx,dy, virus.day+1));
                }
            }

        }


        //결과
        System.out.println(list[X-1][Y-1]);

    }
}

class Virus implements Comparable<Virus>
{
    int num;
    int x,y;
    int day;

    Virus(int num, int x, int y, int day)
    {
        this.num = num;
        this.x = x;
        this.y = y;
        this.day = day;
    }


    @Override
    public int compareTo(Virus o) {
        return Integer.compare(num,o.num);
    }
}