package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1920 {
    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        // N 입력
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        // M 입력
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
        {
            int find = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(0,nums.length-1,find));
        }



    }

    static int binarySearch(int start, int end, int find)
    {


        while(start <= end)
        {
            int mid = (start+end)/2;

            if(nums[mid] == find)
            {
                return 1;
            }
            else if(nums[mid] < find)
            {
                start = mid+1;
            }
            else
            {
               end = mid-1;
            }

        }

        return 0;
    }

}
