import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String name: completion){
            if(!map.containsKey(name)){
               map.put(name, 0);
            }
            map.put(name, map.get(name)+1);
        }
        
        for(String name: participant){
            if(!map.containsKey(name)){
                return name;
            }
            map.put(name, map.get(name)-1);
        }
        
        for(String name: completion){
            if(map.get(name) != 0){
                return name;
            }
        }
        
        return answer;
    }
}