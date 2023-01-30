package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20055
{
    static int N, K, result;
    static int[] belt;
    static boolean[] robot;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // N: 컨베이어 벨트의 길이, (칸은 0~2N-1)
        N = Integer.parseInt(st.nextToken());
        // K: 종료 조건 (내구도가 0인 칸의 개수가 K개 이상이면 종료)
        K = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        // belt[]: 컨베이어 벨트 (각 칸의 내구도를 저장하고 돌아감)
        belt = new int[2*N];
        // 각 칸의 초기값 설정
        for(int i=0; i<2*N; i++)
        {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        // robot[]: 각 칸에 로봇이 있는지 표시 (0~N)
        robot = new boolean[N];

        // result: 단계를 나타내는 수
        result = 0;
        while(checkBelt())
        {
            result++;

            // step1. 벨트 이동
            moveBelt();

            // step2. 로봇 이동
            moveRobot();

            // step3. 로봇 올리기
            addRobot();

        }

        System.out.println(result);
    }

    private static void moveBelt()
    {
         int last;

         // 한 칸씩 옮김
         last = belt[2*N-1];
         for(int i=2*N-1; i>0; i--)
         {
             belt[i] = belt[i-1];
         }
         belt[0] = last;

         // 로봇의 위치도 그에 맞게 옮김
        for (int i = N-1; i > 0; i--)
        {
            robot[i] = robot[i-1];
        }

        robot[0] = false;
        robot[N-1] = false;
    }

    private static void moveRobot()
    {
        // 로봇이 존재하는 칸 탐색
        // 가장 빨리 넣은 것 부터 옮겨야 하므로 역순으로 탐색
        for(int i=N-1; i>0; i--)
        {
            // 앞 칸(i-1)에 로봇이 존재할 경우
            if(robot[i-1])
            {
                // 현재 칸(i)에 로봇이 존재하지 않고, 내구도가 1이상일 경우
                if(!robot[i] && belt[i] > 0)
                {
                    // 한 칸 이동
                    robot[i-1] = false;
                    robot[i] = true;

                    // 이동한 칸 내구도 -1
                    belt[i]--;

                    robot[N-1] = false;
                }

            }
        }
    }

    private static void addRobot()
    {
        // 0번에 로봇이 없고, 내구도 0이 아닐경우
        if(!robot[0] && belt[0] > 0)
        {
            // 로봇을 올림 (내구도 -1)
            robot[0] = true;
            belt[0]--;
        }
    }

    private static boolean checkBelt()
    {
        // k: 내구도가 0인 칸의 개수
        int k=0;

        for(int i=0; i<2*N; i++)
        {
            if(belt[i] == 0)
                k++;
        }

        // K개 이상일 경우 종료하기 위한 false 리턴
        if(k>=K)
            return false;

        return true;
    }
}
