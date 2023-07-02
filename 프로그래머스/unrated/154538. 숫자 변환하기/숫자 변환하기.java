import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(y,0));
        while(!queue.isEmpty()){
            Number cur = queue.poll();
            if(cur.y == x){
                answer = cur.cnt;
                break;
            }
            
            if(cur.y % 2 == 0){
                queue.add(new Number(cur.y / 2, cur.cnt + 1));
            }
            
            if(cur.y % 3 == 0){
                queue.add(new Number(cur.y / 3, cur.cnt + 1));
            }

            if(cur.y - n >= x){
                queue.add(new Number(cur.y - n, cur.cnt + 1));
            }
        }
        
        
        return answer;
    }
}

class Number{
    int y;
    int cnt;
    
    Number(int y, int cnt){
        this.y = y;
        this.cnt = cnt;
    }
}