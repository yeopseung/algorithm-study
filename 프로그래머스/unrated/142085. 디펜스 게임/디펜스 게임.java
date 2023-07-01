import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++){
            int e = enemy[i];
            
            // (병사의 수 - 적의 수)
            if(n - e >= 0){
                // 가능: 적용
                n -= e;
                pq.add(e);
                answer++;
            }
            else{
                // 불가능: 무적권
                
                // 무적권 X: 종료
                if(k == 0)
                    break;
                
                // pq가 비어있을 경우: 현 라운드에 사용
                if(pq.isEmpty()){
                    k--;
                    answer++;
                    continue;
                }
                
                // (pq의 최상위 값 > 적의 수): 최상위 값에 적용
                if(pq.peek() > e){
                    int top = pq.poll();
                    n += top;
                    k--;
                    i--;
                    continue;
                }
                
                // (pq의 최상위 값 < 적의 수): 현재 라운드에 적용
                k--;
                answer++;
            }
        }
        
        return answer;
    }
}