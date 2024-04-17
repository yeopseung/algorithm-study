import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        ArrayList<ArrayList<Integer>> towers = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            towers.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            towers.get(wire[0]).add(wire[1]);
            towers.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire : wires){
            int r1 = wire[0];
            int r2 = wire[1];
            
            // 전선 끊기
            towers.get(r1).remove(Integer.valueOf(r2));
            towers.get(r2).remove(Integer.valueOf(r1));
            
            Queue<ArrayList<Integer>> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            int cnt = 0;
            
            queue.add(towers.get(r1));
            visited[r1] = true;
            while(!queue.isEmpty()){
                ArrayList<Integer> cur = queue.poll();
                
                cnt++;
                
                for(int next : cur){
                    if(!visited[next]){
                        queue.add(towers.get(next));
                        visited[next] = true;
                    }
                }
            }
            
            // 송전탑을 나눈 후의 차이 갱신
            answer = Math.min(answer, Math.abs(n - 2 * cnt));
            
            // 전선 연결
            towers.get(r1).add(r2);
            towers.get(r2).add(r1);
        }
        
        return answer;
    }
}
