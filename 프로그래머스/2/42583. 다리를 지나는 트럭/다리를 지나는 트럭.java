import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int answer = 0;
        int cur_weight = 0;
        
        for(int i=0; i < truck_weights.length; i++){
            int truck = truck_weights[i];
            
            // 다리가 가득 찬 경우: 맨 앞 트럭 삭제
            if(bridge.size() == bridge_length){
                int end_truck = bridge.poll();
                cur_weight -= end_truck;
            }
            
            // 다리에 트럭이 올라갈 수 있는 경우
            if((cur_weight + truck) <= weight){
                bridge.add(truck);
                cur_weight += truck;
            }
            // 다리에 트럭이 올라갈 수 없는 경우: 무게 초과
            else{
                bridge.add(0); // Empty
                i--; 
            }
            
            answer++;
        }
        
        // 마지막 트럭 통과
        answer += bridge_length;
        
        return answer;
    }
}