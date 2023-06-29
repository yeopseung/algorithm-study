import java.util.*;

class Solution {
    boolean[][] marked;
    char[][] map;
    int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        
        boolean end = false;
        
        
        map = new char[m][n];
        for(int i=0; i<m ; i++)
        {
            for(int j=0; j<n;j++)
            {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        
        while(true)
        {
            marked = new boolean[m][n];
            
            //2x2블록을 찾아서 mark
            if(!search(m,n))
            {
                //2x2블록이 없을 경우 종료
                break;
            }
           
            
            accept(m,n);
            sort(m,n);
          
            
         
        }
        return answer;
    }
    
    boolean search(int m, int n)
    {
        boolean isChecked = false;
        for(int i=0; i<m-1; i++)
        {
            for(int j=0; j<n-1;j++)
            {
                char ch = map[i][j];
                
                if(ch=='#')
                    continue;
                
                //2X2 블록을 발견할 경우
                if((ch==map[i][j+1]) && (ch==map[i+1][j]) 
                  && ch==map[i+1][j+1])
                {
                    //해당 블록 체크
                    marked[i][j] = true;
                    marked[i][j+1] = true;
                    marked[i+1][j] = true;
                    marked[i+1][j+1] = true;
                    
                    isChecked = true;
                }
            }
        }
        return isChecked;
    }
    
    
    void accept(int m, int n)
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(marked[i][j])
                {
                    map[i][j] = '#';
                    answer++;
                }
            }
        }
    }
    
    void sort(int m, int n)
    {
        for(int i=0; i<m-1; i++)
        {
            for(int j=0;j<n; j++)
            {
                if(map[i][j] != '#')
                {
                    int k=i+1;
                    int count=0;
                    while(k<m)
                    {
                        if(map[k][j]=='#')
                        {
                            count++;
                        }
                        else
                            break;
                        k++;
                    }
                    
                
                    if(count != 0)
                    {
                        map[i+count][j] = map[i][j];
                        map[i][j] = '#';
                        i=0;
                        j=0;
                    }
                    
                }
            }
        }
    }


}
