import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[] answer;
        ArrayList<Integer> ans = new ArrayList();
        
        int[] rangeX = {-1,1,0,0};
        int[] rangeY = {0,0,1,-1};
       
        // map 2차원 배열로 변경
        char[][] map = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++)
            map[i] = maps[i].toCharArray();
        
        boolean[][] visited = new boolean[map.length][map[0].length];
        for(int i=0; i<map.length; i++)
        {
            for(int j=0; j<map[0].length; j++)
            {
                if(!visited[i][j] && 'X' != map[i][j])
                {
                    Stack<Location> stack = new Stack();
                    stack.add(new Location(i,j));
                    visited[i][j] = true;
                    int result = map[i][j] - '0';
                    
                    while(!stack.isEmpty())
                    {
                        Location cur = stack.pop();
                
                        
                        for(int k=0; k<4; k++)
                        {
                            int dx = cur.x + rangeX[k];
                            int dy = cur.y + rangeY[k];
                            
                            if(dx <0 || dy <0 || dx>=map.length || dy >= map[0].length)
                                continue;
                            
                            if(!visited[dx][dy] && 'X' != map[dx][dy])
                            {
                                stack.add(new Location(dx,dy));
                                visited[dx][dy] = true;
                                result += (map[dx][dy] - '0');
                            }
                            
                        }
                    }  
                    ans.add(result);
                }
                
            }
        }
        
        Collections.sort(ans);
        if(ans.size() == 0)
        {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)
        {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    class Location
    {
        int x, y;
        
        Location(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}