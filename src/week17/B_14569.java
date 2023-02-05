package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14569
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N, K, t, M, P, q;
        long[] subject, student;

        // N: 총 과목의 수
        N = Integer.parseInt(br.readLine());

        // subject[]: 각 과목의 수업시간을 저장하는 배열
        subject = new long[N];

        for(int n=0; n<N; n++)
        {
            st = new StringTokenizer(br.readLine());

            // K: 각 과목의 수업시간 수
            K = Integer.parseInt(st.nextToken());

            for(int i=0; i<K; i++)
            {
                // t: 과목의 수업이 진행되는 교시
                t = Integer.parseInt(st.nextToken());
                subject[n] = subject[n] | (1L << t);
            }
        }

        // M: 학생 수
        M = Integer.parseInt(br.readLine());

        // student[]: 학생들의 비어있는 교시 저장 배열
        student = new long[M];

        for(int m=0; m<M; m++)
        {
            st = new StringTokenizer(br.readLine());
            // P: 비어있는 교시 개수
            P = Integer.parseInt(st.nextToken());

            for(int i=0; i<P; i++)
            {
                // q: 비어있는 교시
                q = Integer.parseInt(st.nextToken());
                student[m] = student[m] | (1L << q);
            }
        }


        int cnt;
        for(int m=0; m<M; m++)
        {
            cnt = 0;
            for(int n=0; n<N; n++)
            {
                if((student[m] & subject[n]) == subject[n])
                    cnt++;

            }

            sb.append(cnt+"\n");
        }

        System.out.println(sb);
    }
}
