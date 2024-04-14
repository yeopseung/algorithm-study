import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int length = words.length;
        boolean[] visited = new boolean[length];
        Queue<Stage> queue = new LinkedList<>();
        queue.add(new Stage(begin, 0));
        
        while(!queue.isEmpty()){
            Stage cur = queue.poll();
            
            for(int i=0; i<length; i++){
                String word = words[i];
                
                if(visited[i]){
                    continue;
                }
                
                int diff = 0;
                for(int j=0; j < word.length(); j++){
                    if(cur.w.charAt(j) != word.charAt(j)){
                        diff++;
                    }
                }
                
                if(diff != 1){
                    continue;
                }
                
                if(word.equals(target)){
                    return cur.cnt + 1;
                }
                
                queue.add(new Stage(word, cur.cnt+1));
                visited[i] = true;
            }
            
        }
        
        
        return answer;
    }
}

class Stage{
    String w;
    int cnt;
    
    Stage(String w, int cnt){
        this.w = w;
        this.cnt = cnt;
    }
}