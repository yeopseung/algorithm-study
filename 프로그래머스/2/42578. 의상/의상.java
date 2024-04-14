import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clothe: clothes){
            String category = clothe[1];
            
            if(!map.containsKey(category)){
                map.put(category, 0);
            }
            
            map.put(category, map.get(category) + 1);
        }
        
        Set<String> categories = map.keySet();
        for(String category: categories){
            int num = map.get(category);
            
            answer *= num + 1;
        }
        
        answer--;
        
        return answer;
    }
}