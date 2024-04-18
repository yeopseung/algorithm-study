import java.util.*;

class Solution {
    private static final int MOD = 1000000007; 
    
    public int solution(int m, int n, int[][] puddles) {
        // 물 웅덩이 위치 설정
        boolean[][] puddleMap = new boolean[n][m]; 
        for(int[] puddle: puddles){
            puddleMap[puddle[1]-1][puddle[0]-1] = true;
        }
        
        // 각 지점까지의 경로 수 저장
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 출발지 pass
                if(i == 0 && j == 0)
                    continue;
                
                // 물 웅덩이가 있는 경우 pass
                if(puddleMap[i][j])
                    continue;
                
                // 이전 위치에서의 경로 수를 현재 위치에 더함
                if(i > 0) dp[i][j] += dp[i-1][j];
                if(j > 0) dp[i][j] += dp[i][j-1];
            
                dp[i][j] %= MOD;
            }
        }
        
        return dp[n-1][m-1];
    }
}
