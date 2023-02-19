package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9996
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        String pattern;
        StringBuilder result = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        pattern = "^"+br.readLine().replaceAll("\\*", ".*")+"$";

        for(int i=0; i<N; i++)
        {
           if(br.readLine().matches(pattern))
               result.append("DA\n");
           else
               result.append("NE\n");
        }

        System.out.println(result);
    }
}
