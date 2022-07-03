package week_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_2437 {
    public static void main(String[] args) {
        int N, result, tem;
        boolean end = false;
        ArrayList<Integer> num = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N; i++)
        {
            num.add(scanner.nextInt());
        }
        Collections.sort(num);
        result = num.get(0);
        Collections.sort(num, Collections.reverseOrder());

        int i,j;
        while(true)
        {
            tem = result;

            for(i=0; i<N ; i++)
            {
                if(result>= num.get(i))
                {
                   break;
                }
            }

            for(j=i; j<N; j++)
            {
                if(tem-num.get(j) >=0)
                {
                    tem -= num.get(j);
                }

                if(tem == 0)
                {
                    break;
                }
            }
            if(j==N && tem >0)
            {
                break;
            }
            result++;
        }

        System.out.println(result);
    }
}
