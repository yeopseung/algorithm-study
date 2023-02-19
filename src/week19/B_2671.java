package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2671
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sound = br.readLine();
        String pattern = "(100+1+|01)+";

        if(sound.matches(pattern))
            System.out.println("SUBMARINE");
        else
            System.out.println("NOISE");
    }
}
