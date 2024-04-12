import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> queue = new LinkedList<>();
        int n = priorities.length;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            queue.add(new Process(i, priorities[i]));
        }
        
        int tem = 0;
     
        while(!queue.isEmpty()){
            Process cur = queue.poll();
            answer++;
            
            // 최대 우선순위 체크
            boolean hasMaxPrority = true;
            for(int i=0; i<n; i++){
                if(cur.priority < priorities[i] && !visited[i]){
                    hasMaxPrority = false;
                    break;
                }
            }
            
            // 최대 우선순위가 아닌 경우
            if(!hasMaxPrority){
                queue.add(cur);
                answer--;
                continue;
            }
            
            // 최대 우선순위인 경우, 찾던 프로세스 -> 종료
            if(cur.location == location){
                break;
            }
            
            visited[cur.location] = true;
        }
        
       
        return answer;
    }
}

class Process{
    int location, priority;
    
    Process(int location, int priority){
        this.location = location;
        this.priority = priority;
    }
}

