package week2;

import java.util.Arrays;
import java.util.Scanner;

public class B_10809 {
    public static void main(String[] args) {
        int[] alphabet = new int[26];

        String str;
        Scanner sc = new Scanner(System.in);


        str = sc.next();
        Arrays.fill(alphabet,-1);

        for(int i=0; i<str.length(); i++)
        {
            if( -1 == alphabet[(int)str.charAt(i)-97])
                alphabet[(int)str.charAt(i)-97] = i;
        }

        for(int i=0; i<26 ; i++)
        {
            System.out.print(alphabet[i] + " ");
        }

    }
}
