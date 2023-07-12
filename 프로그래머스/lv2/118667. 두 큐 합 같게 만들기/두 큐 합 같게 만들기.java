import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Long> a = new LinkedList<>();
        Queue<Long> b = new LinkedList<>();
        long a_sum = 0;
        long b_sum = 0;
        
        for(int num: queue1){
            a.add((long)num);
            a_sum += num;
        }
        
        for(int num: queue2){
            b.add((long)num);
            b_sum += num;
        }
        
        // 예외처리: 합이 홀수일 경우 두 큐의 합을 구할 수 없음
        if((a_sum + b_sum) % 2 != 0)
            return -1;
        
        long max_answer = (a.size() + b.size());
        long end = (a_sum + b_sum) / 2;
        while((!a.isEmpty() && !b.isEmpty()) && answer <= max_answer+1){
            
            // 두 큐의 합이 같으면: 종료
            if((a_sum == end) && (b_sum == end))
                break;
            
            // 종료가 아니라면: 작업 1번 더
            answer++;
            
            // B의 합이 더 큰 경우: B pop, A insert
            if(a_sum < b_sum){
                long num = b.poll();
                b_sum -= num;
                
                a.add(num);
                a_sum += num;
                
                continue;
            }
            
            // A의 합이 더 크거나 같은 경우: A pop, B insert
            long num = a.poll();
            a_sum -= num;
                
            b.add(num);
            b_sum += num;
            
        }
        
        // 예외처리 : 두 큐의 합을 같게 못 만들었을 경우 -1을 리턴
        if(a_sum != b_sum)
            return -1;
        
        return answer;
    }
    
    
}

// 하나의 큐에서 원소를 pop하여 다른 큐에 insert
// 두 큐의 원소 합이 같도록 만듬
// 작업 1회 : pop 1번 insert 1번
// 필요한 작업의 최소 횟수


