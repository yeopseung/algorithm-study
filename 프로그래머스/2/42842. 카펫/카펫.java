class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
       
        int sum = brown + yellow;   
        int height = 1;  
        
        while(height <= (sum/2)){
            if(sum % height == 0){
                int width = sum / height;
                int b = (width*2) + (height-2) * 2; 
                
                if(b == brown){
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
             
            height++;
        }
        
        return answer;
    }
}