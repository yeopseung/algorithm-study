class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // 내부의 점 (x-a)^2 + (y-b)^2 < r^2
        // 외부의 점 (x-a)^2 + (y-b)^2 > r^2
        long r1Pow = (long)Math.pow(r1,2);
        long r2Pow = (long)Math.pow(r2,2);
        long side = 0;
        for(int i=1; i<=r2 ; i++){
            long maxY = (long)Math.floor(Math.sqrt((r2Pow - Math.pow(i,2))));
            long minY = 0;
            if(i < r1)
                minY = (long)Math.ceil(Math.sqrt((r1Pow - Math.pow(i,2))));
            
            answer += maxY-minY +1;
        }
    
        return answer*4;
    }
}