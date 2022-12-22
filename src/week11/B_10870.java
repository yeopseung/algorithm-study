package week11;

import java.util.Scanner;

public class B_10870 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(calc(N));



    }

    static int calc(int x)
    {
        if(x == 0)
            return 0;

        if(x == 1)
            return 1;

        int result = calc(x-1) + calc(x-2);


        return result;
    }
}
