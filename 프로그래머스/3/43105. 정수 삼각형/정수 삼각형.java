import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int height = triangle.length;
        int[][] dp = new int[height][height];
        
        dp[0][0] = triangle[0][0];
        for(int x=0; x<height-1; x++){
            for(int y=0; y<triangle[x].length; y++){
                dp[x+1][y] = Math.max(dp[x+1][y], dp[x][y] + triangle[x+1][y]);
                dp[x+1][y+1] = Math.max(dp[x+1][y+1], dp[x][y] + triangle[x+1][y+1]);
            }
        }
        
        Arrays.sort(dp[height-1]);
        answer = dp[height-1][height-1];
        
        return answer;
    }
}