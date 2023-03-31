import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] rangeX = {0,1,0,-1};
        int[] rangeY = {1,0,-1,0};
        
        // 행렬 생성
        int[][] matrix = new int[rows+1][columns+1];
        int k = 1;
        for(int i=1; i<=rows; i++)
        {
            for(int j=1; j<=columns; j++)
            {
                matrix[i][j] = k++;
            }
        }
        
        
        // 쿼리 실행
        for(int i=0; i<queries.length; i++)
        {
            int startX = queries[i][0];
            int startY = queries[i][1];
            
            int cur = matrix[startX][startY];
            int x = startX;
            int y = startY;
            int result = cur;
            
            // 우
            while(true)
            {
                // 다음 블록
                x += rangeX[0];
                y += rangeY[0];
                int next = matrix[x][y];
                
                matrix[x][y] = cur;
                result = Math.min(result, next);
                cur = next;
                
                if(y == queries[i][3])
                    break;   
            }
        
            // 하
            while(true)
            {
                x += rangeX[1];
                y += rangeY[1];
                int next = matrix[x][y];
                
                matrix[x][y] = cur;
                result = Math.min(result, next);
                cur = next;
                
                if(x == queries[i][2])
                    break;
            }
            
            // 좌
            while(true)
            {
                x += rangeX[2];
                y += rangeY[2];
                int next = matrix[x][y];
                
                matrix[x][y] = cur;
                result = Math.min(result, next);
                cur = next;
                
                if(y == queries[i][1])
                    break;
            }
            
            // 상
            while(true)
            {
                x += rangeX[3];
                y += rangeY[3];
                int next = matrix[x][y];
                
                matrix[x][y] = cur;
                result = Math.min(result, next);
                cur = next;
                
                if(x == queries[i][0])
                    break;
            }
//               for(int m=1; m<=rows; m++)
//             {
//                 for(int n=1; n<=columns; n++)
//                 {
//                     System.out.print(matrix[m][n]+" ");
//                 }
//                 System.out.println();
//             }
           
           
            
            answer[i] = result;
        }
        
        // 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자
        return answer;
    }
}