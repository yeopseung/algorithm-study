import java.util.*;

class Solution {
    private static int[] rangeX = {-1,1,0,0};
    private static int[] rangeY = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        int length_x = maps.length;
        int length_y = maps[0].length;
        
        boolean[][] visited = new boolean[length_x][length_y];
        
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Position cur = queue.poll();
            
            if(cur.x == length_x-1 && cur.y == length_y-1){
                answer = cur.cnt;
                break;
            }
            
            for(int i=0; i<4; i++){
                int dx = cur.x + rangeX[i];
                int dy = cur.y + rangeY[i];
                
                if(dx < 0 || dy < 0 || dx >= length_x || dy >= length_y){
                    continue;
                }
                
                if(!visited[dx][dy] && maps[dx][dy] == 1){
                    queue.add(new Position(dx, dy, cur.cnt+1));
                    visited[dx][dy] = true;
                }
            }
        }
        
        
        return answer;
    }
}

class Position{
    int x, y, cnt;
    
    Position(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}