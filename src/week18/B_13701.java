package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class B_13701
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        BitSet bitSet = new BitSet();
        String[] str = br.readLine().split(" ");

        for(String s : str)
        {
            if(!bitSet.get(Integer.parseInt(s)))
            {
                bitSet.set(Integer.parseInt(s));
                sb.append(s+" ");
            }
        }

        System.out.println(sb);
    }
}
