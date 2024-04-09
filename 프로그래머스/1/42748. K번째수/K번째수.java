import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int[] command: commands){
            int i = command[0] -1;
            int j = command[1] -1;
            int k = command[2] -1;
            
            // 부분 배열 
            ArrayList<Integer> subArray = new ArrayList<>();
            while(i<=j){
                subArray.add(array[i]);
                i++;
            }
            
            // 정렬
            Collections.sort(subArray);

            // 정답 저장
            answer.add(subArray.get(k));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}