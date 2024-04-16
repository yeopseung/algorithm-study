import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n ; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e: edge){
            int x = e[0];
            int y = e[1];
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        Integer[] distance = new Integer[n+1];
        Arrays.fill(distance, 0);
        
        boolean[] visited = new boolean[n+1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            ArrayList<Integer> next = graph.get(cur.n);
            
            distance[cur.n] = Math.max(distance[cur.n], cur.cnt);
            
            for(int i=0; i<next.size(); i++){
                if(!visited[next.get(i)]){
                    queue.add(new Node(next.get(i), cur.cnt+1));
                    visited[next.get(i)] = true;
                }
            }
        }
        
        Arrays.sort(distance, Collections.reverseOrder());
        int max = distance[0];
        for(int d: distance){
            if(max == d){
                answer++;
            }
        } 
        
        
        return answer;
    }
}

class Node{
    int n, cnt;
    
    Node(int n, int cnt){
        this.n = n;
        this.cnt = cnt;
    }
}