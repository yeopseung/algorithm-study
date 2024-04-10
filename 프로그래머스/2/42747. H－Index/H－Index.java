import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        int answer = 0;
        
        for(int i=0; i<length; i++){
            int h_index = Math.min(citations[i], length -i);
            answer = Math.max(answer, h_index);
        }
        
        return answer;
    }
}