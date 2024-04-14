import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        StringTokenizer st;
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation: operations){
            st = new StringTokenizer(operation);
            
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(oper.equals("D")){
                // 최댓값 삭제
                if(num == 1 && max.size() > 0){
                    int remove = max.poll();
                    min.remove(remove);
                }
                
                // 최솟값 삭제
                if(num == -1 && min.size() > 0){
                    int remove = min.poll();
                    max.remove(remove);
                }    
            }
            else if(oper.equals("I")){
                // 주어진 숫자 삽입
                min.add(num);
                max.add(num);
            }
        }
        
        // 최댓값, 최솟값 저장
        if(!min.isEmpty() && !max.isEmpty()){
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        
        return answer;
    }
}