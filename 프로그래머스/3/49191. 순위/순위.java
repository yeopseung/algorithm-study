import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0; 
        
        int[][] graph = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        
        for(int[] result: results){
            int win = result[0];
            int lose = result[1];
            
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }
        
        for(int i=1; i<=n ; i++){
            boolean check = true;
            for(int j=1; j<=n ; j++){
                if(graph[i][j] == Integer.MAX_VALUE){
                    check = false;
                    break;
                }
            }
            
            if(check){
                answer++;
            }
        }
        
        
        
        return answer;
    }
}