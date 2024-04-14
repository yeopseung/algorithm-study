class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
       
        int sum = brown + yellow;   // 전체 크기
        int m = 1;  // 세로
        while(m <= (sum/2)){
            if(sum % m == 0){
                int n = sum / m;    // 가로
    
                int b = (n*2) + (m-2) * 2; 
                if(b == brown){
                    answer[0] = n;
                    answer[1] = m;
                    break;
                }
            }
             
            m++;
        }
        
        return answer;
    }
}