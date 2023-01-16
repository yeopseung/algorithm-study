package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2179_V2
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, result, cnt, l, r;
        String[] str;


        // N : 문장 갯수
        N = Integer.parseInt(br.readLine());


        str = new String[N+1];
        for(int i=0; i<N; i++)
        {
            str[i] = br.readLine();
        }

        result = 0;
        l = N;
        r = N;
        for(int i=0; i<N; i++)
        {
            for(int j=i+1; j<N; j++)
            {
                if(str[i].equals(str[j]))
                    continue;

                cnt = 0;
                for(int k=0; k<Math.min(str[i].length(),str[j].length());k++)
                {
                    if(str[i].charAt(k) != str[j].charAt(k))
                        break;

                    cnt++;
                }

                if(result < cnt)
                {
                    result = cnt;
                    l = i;
                    r = j;
                }
            }
        }

        System.out.println(str[Math.min(l,r)]);
        System.out.println(str[Math.max(l,r)]);
    }

}
