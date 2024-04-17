class Solution {
    private static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        
        for(int r=0; r<n; r++){
            permutation(dungeons, new boolean[n], new int[n][2], 0, n, r, k);
        }
        
        
        return answer;
    }
    
    private static void permutation(int[][] dungeons, boolean[] visited, int[][] result, int depth, int n, int r, int k){
        
        if(depth == n){
            print(result, n, k);
            return;
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth][0] = dungeons[i][0];
                result[depth][1] = dungeons[i][1];
                permutation(dungeons, visited, result, depth+1, n, r, k);
                visited[i] = false;
            }
        }
    }
    
    private static void print(int[][] result, int n, int k){
        int cnt = 0;
        int tem = k;
        
        for(int i=0; i<n ; i++){
            if(tem >= result[i][0]){
                tem -= result[i][1];
                cnt++;
            }
            else{
                break;
            }
        }
        
        if(cnt != 0){
            answer = Math.max(answer, cnt);
        }
    }
    
}