package week2;

import java.util.Scanner;

public class B_17298
{
    public static void main(String[] args)
    {
        int N;
        int[] arr, result;



        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();
        arr = new int[N];
        result = new int[N];


        for(int i=0; i<N; i++)
        {
            arr[i] = sc.nextInt();
        }


        int tem;
        for(int i=0; i<N; i++)
        {
            tem = -1;

            for (int j = i; j < N; j++)
            {
                if(arr[i] < arr[j])
                {
                    tem = arr[j];
                    break;
                }
            }

            result[i] = tem;
        }

        for(int i=0; i<N;i++)
            System.out.print(result[i] +" ");



    }
}
