package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_4195
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<String, String> relation;
        int T, F;

        // T: 테스트 개수
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++)
        {
            // relation: 친구 관계 저장 HashMap
            relation = new HashMap<>();

            // F: 친구 관계 수
            F = Integer.parseInt(br.readLine());

            String A,B;
            for(int f=1; f<=F; f++)
            {
                st = new StringTokenizer(br.readLine());

                A = st.nextToken();
                B = st.nextToken();

                // 친구 관계 맵에 없을 경우
                if(!relation.containsKey(A))
                {
                    relation.put(A,B);
                }
            }
        }
    }
}
