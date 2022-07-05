package week2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class B_17299 {
    public static void main(String[] args) {
        int N, num ,tem;
        int[] list;

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        N = sc.nextInt();
        list = new int[N];

        for(int i=0; i<N; i++)
        {
            num = sc.nextInt();
            list[i] = num;
            if(hashMap.containsKey(num))
            {
                tem = hashMap.get(num);
                hashMap.put(num,tem+1);
            }
            else
            {
                hashMap.put(num,1);
            }
        }

        stack.push(0);
        for(int i=1; i<N; i++)
        {

            while(!stack.isEmpty() && hashMap.get(list[stack.peek()]) < hashMap.get(list[i]))
            {
                list[stack.pop()] = list[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty())
        {
            list[stack.pop()] = -1;
        }

        for(int i=0; i<N; i++)
        {
            sb.append(list[i] + " ");
        }

        System.out.println(sb);
    }
}

//        HashMap 확인
//        Iterator<Integer> keys = hashMap.keySet().iterator();
//        while(keys.hasNext()){
//            int key = keys.next();
//            System.out.println("[Key]:" + key + " [Value]:" +  hashMap.get(key));
//        }
