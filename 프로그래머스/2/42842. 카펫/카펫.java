class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        int width = 0;
        int height = 0;
        
        for (int i = 1; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                width = sum / i;
                height = i;
                
                int b = (width + height) * 2 - 4;
                
                if (b == brown) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        
        return answer;
    }
}
