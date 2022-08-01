package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2281 {
    public static void main(String[] args) throws IOException {
        final int N, M;
        int[] name;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // name 입력
        name = new int[N];
        for(int i=0; i<N; i++)
        {
            name[i] = Integer.parseInt(br.readLine());
        }

        // 위의 예시
        // 끝 단어가 아닌 경우  (m - name[i]) -1 > 0
        // 끝 단어인 경우 ( (m - name[i])  || (m - name[i]) -1  ) == 0   -> 남은공간 계산 후 다음줄로 넘어감
        // 끝 단어로 넣으려 했으나 초과한 경우 ( (m - name[i]) || (m - name[i]) -1 ) < 0  -> 남은공간 계산 후 다음줄로 넘어감
        // -> 결론 :  ( (m - name[i])  || (m - name[i]) -1  ) <= 0 인 경우 남은공간 계산 후 다음줄로 넘어감
        // -> 결론 : ( (m - name[i])  || (m - name[i]) -1  ) > 0 인 경우 (m - name[i]) -1 값 저장 후 다음 단어 대입
        // 탈출 조건 : 단어를 다 썼을 경우
        int count = 0, apply, result = 0;
        int m = M;
        while(count < N)
        {

            // 단어
            apply = (m - name[count]);

            //끝 단어이며 남은 칸 0
            if(apply == 0)
            {
                //apply == 0 이므로 결과에 더할거 없음
                //다음 숫자
                //m 갱신
                count++;
                m = M;
            }
            //끝 단어이며 남은 칸 1
            else if(apply - 1 == 0)
            {
                //다음 숫자
                //남은 칸 1*1 = 1 저장
                //m 갱신
                count++;
                if(count == N)
                    break;
                result++;
                m = M;
            }
            //끝 단어로 넣으려 했으나 초과한 경우
            else if(apply < 0)
            {
                //숫자를 적용하기 전 남은공간 m 저장
                //다음숫자 x
                //m 갱신
                if(count == N)
                    break;
                m++;
                result += m*m;
                m = M;

            }
            else if((apply - 1) < 0)
            {
                //숫자를 적용하기 전 남은공간 m 저장
                //다음숫자 x
                //m 갱신
                if(count == N)
                    break;
                result += m*m;
                m = M;
            }
            //끝 단어가 아닌 경우
            else
            {
                //단어 적용 ( m 갱신 )
                //다음 숫자
                count++;
                if(count == N)
                    break;
                m = apply -1;
            }
        }
        System.out.println(result);

    }
}
