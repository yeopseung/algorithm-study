package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B_3649 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str;
        while(sc.hasNextInt())
        {
            //입력
           long x = sc.nextInt()*10000000;
           int n = sc.nextInt();
           int[] num = new int[n];

           for(int i=0; i<n; i++)
           {
               num[i] = sc.nextInt();
           }
           Arrays.sort(num);


           //초기값 설정
           int head = 0;
           int tail = num.length-1;


           while(head<tail)
           {
               int l1 = num[head];
               int l2 = num[tail];
               long sum = l1+l2;

               if(sum == x)
               {
                   break;
               }

               if(sum > x)
               {
                   tail--;
               }
               else
               {
                   head++;
               }
           }

            if(head >= tail){
                System.out.println("danger");
            }else{
                System.out.println(String.format("yes %d %d",num[head],num[tail]));;
            }
        }

    }
}
