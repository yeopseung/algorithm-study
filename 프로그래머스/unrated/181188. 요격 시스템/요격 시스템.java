import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        
        int end = -1;
        for(int[] target: targets){
            if(end == -1){
                answer++;
                end = target[1] - 1;
                continue;
            }
            
            if(target[0] <= end && end <= target[1])
                continue;
            
            answer++;
            end = target[1] -1;
        }
        
        return answer;
    }
}