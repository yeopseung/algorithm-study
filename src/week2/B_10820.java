package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10820 {
    public static void main(String[] args) throws IOException {
        int upper, lower, num, space;

        String str;
        StringBuffer result = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while((str = br.readLine()) != null)
        {


            upper = 0;
            lower = 0;
            num = 0;
            space = 0;

            for(int j=0; j< str.length(); j++)
            {

                if('A' <= str.charAt(j) && str.charAt(j) <= 'Z')
                {
                    upper++;
                }
                else if('a' <= str.charAt(j) && str.charAt(j) <= 'z')
                {
                    lower++;
                }
                else if('0' <= str.charAt(j) && str.charAt(j) <= '9')
                {
                    num++;
                }
                else if(str.charAt(j) == ' ')
                {
                    space++;
                }
            }

            result.delete(0,result.length());
            result.append(lower+" ");
            result.append(upper+" ");
            result.append(num+" ");
            result.append(space);
            System.out.println(result);

        }

    }
}
