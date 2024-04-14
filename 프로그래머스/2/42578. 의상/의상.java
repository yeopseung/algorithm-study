import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clothe: clothes){
            String category = clothe[1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        for(int clothesNum: map.values()){
            answer *= clothesNum + 1;
        }
        
        return answer - 1;
    }
}