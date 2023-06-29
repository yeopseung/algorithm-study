import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String question ="";
        int cnt = 0;
        int end = 0;
        
        //t개의 숫자만큼 n진법 숫자를 생성
        for(int i=0; i<(t*m);i++)
        {
            question+= Integer.toString(i,n);
        }
        question = question.toUpperCase();
        
        
        while(true)
        {
            //튜브가 말해야하는 숫자 t개를 만족했을 경우 
            if(end==t)
            {
                //종료
                break;
            }
            
            //게임 순서
            for(int i=1; i<=m;i++)
            {
                //튜브의 순서일 경우
                if(i==p)
                {
                    //말해야하는 숫자 저장
                    answer+= question.charAt(cnt);
                    end++;
                }
                cnt++;
            }
            
            
        }
        
        
        
        
        return answer;
    }
}