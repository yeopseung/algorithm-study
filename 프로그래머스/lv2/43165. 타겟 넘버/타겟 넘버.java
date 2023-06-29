import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Number num;
        int result =0;
        
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(0,0));
        
        
        while(!queue.isEmpty())
        {
            
            num = queue.poll();
            
            if((num.sum == target) && (num.cnt == numbers.length))
            {
                result++;
            }
            
          
            if(num.cnt < numbers.length)
            {
                 queue.add(new Number(num.sum+numbers[num.cnt] , num.cnt +1));
            queue.add(new Number(num.sum-numbers[num.cnt] , num.cnt +1));
    
            }
           
           
        }
        
        answer = result;
        return answer;
    }
}

class Number
{
    int sum;
    int cnt;
    
    Number(int sum, int cnt)
    {
        this.sum = sum;
        this.cnt = cnt;
    }
}