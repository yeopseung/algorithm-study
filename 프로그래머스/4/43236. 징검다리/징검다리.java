import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;
            
            int prev = 0; 
            int remove = 0;

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    remove++;
                } else {
                    prev = rock;
                }
            }

            if (distance - prev < mid) {
                remove++;
            }

            if (remove <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
