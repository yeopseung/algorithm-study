package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1316 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int cnt = Integer.parseInt(br.readLine());
        int result = 0;



        for(int i=0; i<cnt; i++)
        {
            boolean[] alphabet = new boolean[26];
            String str = br.readLine();
            int before=-1;
            boolean check = false;

            for(int j=0; j<str.length(); j++)
            {


                if(before == str.charAt(j)-'a')
                {
                    continue;
                }
                else if(!alphabet[str.charAt(j)-'a'])
                {
                    alphabet[str.charAt(j)-'a'] = true;
                    before = str.charAt(j)-'a';
                }
                else
                {
                    check = true;
                }

            }

            if(!check)
            {
                result++;
            }
        }

        System.out.println(result);



    }
}
