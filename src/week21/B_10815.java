package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_10815
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        Set<Integer> card;
        int N, M;

        // N: 가지고있는 카드 개수
        N = Integer.parseInt(br.readLine());

        // card: 카드 저장 자료구조
        card = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            card.add(num);
        }

        // M: 찾는 카드 개수
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
        {
            int find = Integer.parseInt(st.nextToken());

            // 존재할 경우 -> 1
            if(card.contains(find))
                answer.append("1 ");
            // 존재하지 않을 경우 -> 0
            else
                answer.append("0 ");
        }

        System.out.println(answer);
    }
}
