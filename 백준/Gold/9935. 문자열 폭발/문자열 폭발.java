

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int strLength = str.length();

        String bomb = br.readLine();
        int bombLength = bomb.length();


        for(int i=0; i<strLength; i++)
        {
            char c = str.charAt(i);
            sb.append(c);

            if(sb.length() >= bombLength)
            {
                boolean hasBomb = true;
                for(int j=0; j<bombLength; j++)
                {
                    char c1 = sb.charAt(sb.length()-bombLength + j);
                    char c2 = bomb.charAt(j);

                    if(c1 != c2)
                    {
                        hasBomb = false;
                        break;
                    }
                }

                if(hasBomb)
                {
                    sb.delete(sb.length() - bombLength, sb.length());
                }
            }
        }

        if(sb.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(sb);

    }
}
