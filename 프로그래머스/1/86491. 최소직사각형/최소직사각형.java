import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int width = 0;
        int height = 0;
        
        for(int i=0; i<sizes.length; i++){
            int w1 = Math.max(width, sizes[i][0]);
            int h1 = Math.max(height, sizes[i][1]);
            int sum1 = w1 * h1;
            
            int w2 = Math.max(width, sizes[i][1]);
            int h2 = Math.max(height, sizes[i][0]);
            int sum2 = w2 * h2;
            
            answer = Math.min(sum1, sum2);
            width = sum1 < sum2 ? w1 : w2;
            height = sum1 < sum2 ? h1 : h2;
        }
        
        return answer;
    }
}