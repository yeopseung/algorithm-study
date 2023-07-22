import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static int N, M, result;
    static int[][] map;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 벽을 세운다
        // 2. 바이러스를 퍼트린다
        // 3. 안전지대 타일의 개수를 센다

        // 1번 부터 시작
        DFS(0);

        // 결과 출력
        System.out.println(result);


    }

    // 1. DFS 를 활용하여 벽을 세운다
    public static void DFS(int count)
    {
        // 세워진 벽이 3개일 경우
        if(count == 3)
        {
            // 2. 바이러스 퍼트리기로 넘어감
            BFS();
            return;
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                // 빈칸(0)일 경우
                if(map[i][j] == 0)
                {
                    // 벽을 세움
                    map[i][j] = 1;
                    DFS(count + 1);
                    // 원상 복구
                    map[i][j] = 0;
                }
            }
        }
    }

    // 2. 바이러스를 퍼트린다
    public static void BFS()
    {
        int[][] v_map;
        Queue<Virus> queue = new LinkedList<Virus>();

        // 기존의 맵 복사
        v_map = new int[N][M];
        for (int i = 0; i < N; i++) {
            v_map[i] = map[i].clone();
        }

        // 초기 Queue 값 설정 (기존의 맵에 있던 바이러스 큐에 넣음)
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(v_map[i][j] == 2)
                {
                    queue.add(new Virus(i,j));
                }
            }
        }

        // BFS 로 바이러스 퍼뜨림
        int[] rangeX = { -1, 1, 0, 0 };
        int[] rangeY = { 0, 0, -1, 1 };
        int dx, dy;
        while (!queue.isEmpty())
        {
            Virus virus = queue.remove();

            // Virus 타일의 상하좌우를 탐색
            for(int i=0; i<4; i++)
            {
                dx = virus.x + rangeX[i];
                dy = virus.y + rangeY[i];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }

                // 빈칸(0) 타일을 발견할 경우
                if(v_map[dx][dy] == 0)
                {
                    // 바이러스를 퍼뜨림, 큐에 추가
                    v_map[dx][dy] = 2;
                    queue.add(new Virus(dx,dy));
                }
            }
        }

        // 3. 안전지대 타일의 개수를 센다로 넘어감
        count_safe(v_map);
    }

    // 3. 안전지대 타일의 개수를 센다
    public static void count_safe(int[][] v_map)
    {
        int count=0;

        // 바이러스가 퍼진 맵을 순회하면서 안전지대 탐색
        // 안전지대는 바이러스가 퍼져도 빈칸(0)인 곳
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(v_map[i][j] == 0)
                {
                    count++;
                }
            }
        }

        // 안전지대가 가장 많은 값이 결과
        result = Math.max(count,result);

    }
}

class Virus
{
    int x, y;

    Virus(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
