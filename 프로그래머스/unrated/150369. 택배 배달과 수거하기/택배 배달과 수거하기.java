import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        
        Stack<Integer> delivery = new Stack<>();
        Stack<Integer> d_res = new Stack<>();
        Stack<Integer> pickup = new Stack<>();
        Stack<Integer> p_res = new Stack<>();
        
        for(int i: deliveries)
            delivery.add(i);
        
        for(int i: pickups)
            pickup.add(i);
        
        while(true){
            int d_cap = cap; // 최대 실을 수 있는 양
            int d_max = 0; // 최대 거리
            while(!delivery.isEmpty() && d_cap >=0){
            
                // 최상위 확인
                int d = delivery.peek();
            
                // 0 이면 pop하고 pass
                if(d == 0){
                    delivery.pop();
                    continue;
                }
                
                // 실을 수 있으면 pop하여 실음, 그때의 stack 크기 == 거리
                if((d_cap - d) >= 0){
                    d_max = Math.max(d_max, delivery.size());
                    d_cap -= delivery.pop();
                }
                else{
                    // ex) 남은 용량 1 물건 2 -> 1개만 실음
                    d_max = Math.max(d_max, delivery.size());
                    delivery.add(delivery.pop() - d_cap);
                    break;
                }
            }
            d_res.add(d_max);
        
            int p_cap = cap; // 최대 실을 수 있는 양
            int p_max = 0; // 최대 거리
            while(!pickup.isEmpty() && p_cap >=0){
            
                // 최상위 확인
                int p = pickup.peek();
                
                // 0 이면 pop하고 pass
                if(p == 0){
                    pickup.pop();
                    continue;
                }
                
                // 실을 수 있으면 pop하여 실음, 그때의 stack 크기 == 거리
                if((p_cap - p) >= 0){
                    p_max = Math.max(p_max, pickup.size());
                    p_cap -= pickup.pop();
                }
                else{
                    // ex) 남은 용량 1 물건 2 -> 1개만 실음
                    p_max = Math.max(p_max, pickup.size());
                    pickup.add(pickup.pop() - p_cap);
                    break;
                }
            }
            p_res.add(p_max);
        
            // 배달할게 없으면 종료
            if(d_max == 0 && p_max ==0)
                break;
        }
        
        // 둘 중 거리가 먼곳을 결과에 누적
        while(!d_res.isEmpty()){
            int d = d_res.pop();
            int p = p_res.pop();
            answer += Math.max(d,p)*2;
        } 
        
        return answer;
    }
}
