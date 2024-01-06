import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int max = 0;
        int cnt = 0;  
        
        for(int i=0; i<progresses.length; i++){
            int estimate = (int)Math.ceil((100.0-progresses[i]) / speeds[i]);
            
            if(max < estimate){
                if(cnt > 0){
                    answer.add(cnt);
                }
                cnt = 0;
                max = estimate;
            }
            
            cnt++;
        }
        
        if(cnt > 0){
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}