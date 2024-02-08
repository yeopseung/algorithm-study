import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for(int i=0; i<answers.length ; i++){
            int ans = answers[i];
            
            if(ans == student1[i % 5])
                cnt1++;
            
            if(ans == student2[i % 8])
                cnt2++;
            
            if(ans == student3[i % 10])
                cnt3++;
        }
        
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        if(max == cnt1){
            answer.add(1);
        }
        
        if(max == cnt2){
            answer.add(2);
        }
        
        if(max == cnt3){
            answer.add(3);
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}