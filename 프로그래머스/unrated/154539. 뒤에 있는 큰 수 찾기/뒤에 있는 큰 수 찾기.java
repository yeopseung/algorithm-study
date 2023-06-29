import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1); // 기본값 설정

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && numbers[i] >= stack.peek()) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            }

            stack.push(numbers[i]);
        }

        return answer;
    }
}
