import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int left = 0;
        int right = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '('){
                left++;
            }
            else if(c == ')'){
                right++;
                
                if(left < right){
                    answer = false;
                    break;
                }
            }
        }
        
        if(left != right){
            answer = false;
        }

        return answer;
    }
}