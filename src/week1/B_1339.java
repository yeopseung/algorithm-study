package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int N, ten, count=9, result=0;
        int[] alphabet = new int[26];


        N = Integer.parseInt(br.readLine());


        for(int i=0; i < N; i++)
        {
            str = br.readLine();
            ten = 1;
            for(int j=str.length()-1; j >= 0; j--)
            {
                alphabet[(int)str.charAt(j)-65] += ten;
                ten *= 10;

            }
        }

        Arrays.sort(alphabet);
        int temp=0;
        for (int i = 0; i < alphabet.length / 2; i++) {
            temp = alphabet[i];
            alphabet[i] = alphabet[(alphabet.length - 1) - i];
            alphabet[(alphabet.length - 1) - i] = temp;
        }

        for(int i=0; i< 26; i++)
        {
            if(alphabet[i]==0)
                break;
            result += alphabet[i] * count;
            count--;
        }

        System.out.println(result);
    }
}

