import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N, result,cnt;
        int[] rangeX = {-1,1,0,0}, rangeY = {0,0,1,-1};
        int[][] map, loss;

        cnt = 1;
        while(true)
        {
            // N: 동굴의 크기 (NxN)
            N = Integer.parseInt(br.readLine());

            if(N == 0)
                break;

            // map[][]: 동굴 내 도둑루피 지도
            map = new int[N][N];
            for(int i=0; i<N; i++)
            {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++)
                {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // loss[][] : 잃는 금액의 최솟값을 저장하는 배열
            loss = new int[N][N];
            for(int i =0; i<N; i++)
            {
                Arrays.fill(loss[i],Integer.MAX_VALUE);
            }
            
            // result: 결과값 저장
            result = Integer.MAX_VALUE;

            // BFS
            Queue<Location> queue = new LinkedList<>();
            queue.add(new Location(0,0));
            loss[0][0] = map[0][0];

            while(!queue.isEmpty())
            {
                Location curLocation = queue.remove();
                
                // 상하좌우 탐색
                for(int i=0; i<4; i++)
                {
                    int dx = curLocation.x + rangeX[i];
                    int dy = curLocation.y + rangeY[i];

                    if(dx<0 || dy<0 || dx>=N || dy>=N)
                        continue;
                    
                    // 현재 위치에서 이동했을 때의 잃는 금액
                    // 이동할 위치의 기존 잃는 금액을 비교하여 최솟값을 선택
                    if(loss[dx][dy] > loss[curLocation.x][curLocation.y] + map[dx][dy])
                    {
                        loss[dx][dy] = loss[curLocation.x][curLocation.y] + map[dx][dy];
                        queue.add(new Location(dx,dy));
                    }

                }
            }

            result = loss[N-1][N-1];
            System.out.println("Problem "+cnt+ ": "+result);
            cnt++;
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
