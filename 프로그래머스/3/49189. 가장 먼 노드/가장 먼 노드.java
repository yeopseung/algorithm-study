import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            int x = e[0];
            int y = e[1];
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); // 최단 거리를 -1로 초기화
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int next : graph.get(cur)) {
                if(distance[next] == -1) { // 방문하지 않은 노드라면
                    queue.add(next);
                    distance[next] = distance[cur] + 1; // 현재 노드까지의 거리 + 1로 갱신
                }
            }
        }
        
        Arrays.sort(distance);
        int maxDistance = distance[distance.length - 1]; // 최대 거리
        for(int d : distance) {
            if(d == maxDistance) {
                answer++;
            }
        } 
        
        return answer;
    }
}
