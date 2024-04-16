import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long minTime = 1;
        long maxTime = n * (long)times[times.length - 1];
        
        while(minTime <= maxTime){
            long midTime = (minTime + maxTime) / 2;
            
            long count = 0;
            for(int time: times){
                count += midTime / time;
            }
            
            if(count >= n){
                maxTime = midTime - 1;
                answer = Math.min(answer, midTime);
            }
            else{
                minTime = midTime + 1;
            }
        }
        
        return answer;
    }
}
