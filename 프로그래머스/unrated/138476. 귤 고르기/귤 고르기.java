import java.util.*;

class Solution {
    private static final int MAX_LENGTH = 10000000;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] t = new int[MAX_LENGTH+1];
        
        for(int i: tangerine)
            t[i]++;

        
        Arrays.sort(t);
        
        for(int i= MAX_LENGTH; i>0; i--){
            if(k <=0)
                break;
        
            k -= t[i];
            answer++;
        }
        
        return answer;
    }
}
