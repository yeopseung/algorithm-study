

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N, K, result;

        // N: 물병의 개수
        N = sc.nextInt();
        // K: 만들어야하는 물병의 개수
        K = sc.nextInt();

        result = 0;
        while(true)
        {
            char[] arr = Integer.toBinaryString(N).toCharArray();
            int cnt =0;
            
            for(int i=0; i<arr.length; i++)
                if(arr[i] == '1')
                    cnt++;
            
            if(cnt <= K)
            {
                System.out.println(result);
                break;
            }
            
            N++;
            result++;
        }
    }
}
