import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T, N;
        Location home, festival;
        Location[] store;

        // T: 테이스 케이스 개수
        T = Integer.parseInt(br.readLine());

        // 테이스 케이스 개수 만큼 실행
        for(int i=0; i<T; i++)
        {
            // N: 맥주를 파는 편의점의 개수
            N = Integer.parseInt(br.readLine());
            store = new Location[N];

            // home: 집 좌표
            st = new StringTokenizer(br.readLine());
            home = new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            // store[]: 편의점들 좌표
            for(int j=0; j<N; j++)
            {
                st = new StringTokenizer(br.readLine());
                store[j] = new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }

            // festival: 락 페이스벌 좌표
            st = new StringTokenizer(br.readLine());
            festival = new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));


            // BFS
            Queue<CurLocation> queue = new LinkedList<>();
            double distance;
            double cnt;
            boolean isOK;
            boolean[] visited = new boolean[N];


            // 집에서 맥주 20병을 가지고 출발
            queue.add(new CurLocation(home.x,home.y,20));
            isOK = false;

            while(!queue.isEmpty())
            {
                CurLocation curLocation = queue.remove();

                // 현재 위치와 페스티벌 까지의 거리 계산
                distance = Math.abs(curLocation.x-festival.x) + Math.abs(curLocation.y - festival.y);

                // 움직이기 위한 맥주 개수 계산
                cnt = distance/50;

                // 페스티벌로 이동할 수 있을 경우
                if(curLocation.beer >= cnt)
                {
                    isOK = true;
                    break;
                }

                for(int k= 0; k<N; k++)
                {
                    Location moveLocation = store[k];

                    // 현재 위치와 움직일 곳의 거리를 계산
                    distance = Math.abs(curLocation.x-moveLocation.x) + Math.abs(curLocation.y - moveLocation.y);

                    // 움직이기 위한 맥주 개수 계산
                    cnt = distance / 50;

                    // 가지고 있는 맥주 개수로 해당 위치로 움직일 수 있을 경우
                    if(curLocation.beer >= cnt && !visited[k])
                    {

                        visited[k] = true;

                        // 맥주를 소모하고 해당 위치로 이동
                        queue.add(new CurLocation(moveLocation.x, moveLocation.y, 20));
                    }

                }
            }

            if(isOK)
                sb.append("happy\n");
            else
                sb.append("sad\n");


        }

        System.out.println(sb);
    }

}

class Location
{
    int x, y;

    Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}

class CurLocation extends Location
{
    int beer;


    CurLocation(int x, int y, int beer)
    {
        super(x, y);
        this.beer = beer;

    }
}