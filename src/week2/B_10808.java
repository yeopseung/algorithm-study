package week2;

import java.util.Scanner;

public class B_10808 {
    public static void main(String[] args) {
        int[] alphabet = new int[26];

        String str;
        Scanner sc = new Scanner(System.in);


        str = sc.next();


        for(int i=0; i<str.length(); i++)
        {
            alphabet[(int)str.charAt(i)-97]++;
        }

        for(int i=0; i<26 ; i++)
        {
            System.out.print(alphabet[i] + " ");
        }

    }
}
