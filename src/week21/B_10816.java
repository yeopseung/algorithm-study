package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_10816
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, Integer> card;
        StringTokenizer st;

        int N, M;

        // N: 가지고있는 카드 개수
        N = Integer.parseInt(br.readLine());

        // card: 카드 저장 자료구조
        card = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken());

            // 이미 존재하는 숫자 -> 개수 +1
            if(card.containsKey(num))
                card.put(num, card.get(num) + 1);
            // 존재하지 않을 경우 -> 초기값 1
            else
                card.put(num, 1);
        }

        // M: 찾는 카드 개수
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
        {
            int find = Integer.parseInt(st.nextToken());

            // 존재할 경우 -> 카드 개수 반환
            if(card.containsKey(find))
                answer.append(card.get(find)+" ");
            // 존재하지 않을 경우 -> 0
            else
                answer.append("0 ");
        }

        System.out.println(answer);
    }
}
