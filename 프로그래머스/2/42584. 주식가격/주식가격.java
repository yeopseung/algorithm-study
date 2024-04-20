import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Queue<Integer> queue = new LinkedList<>();

        for (int price : prices) {
            queue.add(price);
        }

        int number = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            answer[number] = 0;
            
            for (int next : queue) {
                answer[number]++;
                if (cur > next) {
                    break;
                }
            }
            
            number++;
        }

        return answer;
    }
}