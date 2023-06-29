import java.util.*;

class Solution {
    // picks[0] : 다이아 곡갱이 개수, picks[1] : 철 곡갱이 개수, picks[2] : 돌 곡갱이 개수
    // minerals : 다이아 or 철 or 돌 캐내는 순서
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int cnt = 0;
        int cost = 0;
        int start = 0;
        
        ArrayList<Bundle> arrayList = new ArrayList();
        Queue<String> queue = new LinkedList();
        
        
        for(int i=0; i<picks.length; i++)
        {
            for(int j=0; j<picks[i]; j++)
            {
                if(i == 0)
                    queue.add("dia");
                else if(i == 1)
                    queue.add("iron");
                else if(i == 2)
                    queue.add("stone");
            }
        }
        int max = Math.min((queue.size()*5), minerals.length);
       
        
        for(int i=0; i<max; i++)
        {
          
            switch(minerals[i])
            {
                case "diamond":
                    cost += 25;
                    break;
                case "iron":
                    cost += 5;
                    break;
                case "stone":
                    cost += 1;
                    break;
            }
            
            cnt++;
            
            if(cnt == 5)
            {
                System.out.println(start+" "+cost);
                arrayList.add(new Bundle(start, cost));
                cnt = 0;
                start = i+1;
                cost = 0;
                
            }
            
        }
        
        if(cnt < 5 && arrayList.size() < queue.size())
        {
            
            cost = 0;
            for(int i = start; i<minerals.length; i++)
            {
                switch(minerals[i])
                {
                    case "diamond":
                    cost += 25;
                    break;
                    case "iron":
                    cost += 5;
                    break;
                    case "stone":
                    cost += 1;
                    break;
                }
            }
            System.out.println(start+" "+cost);
            arrayList.add(new Bundle(start, cost));
        }
        
        Collections.sort(arrayList, new Comparator<Bundle>() {
            
            public int compare(Bundle o1, Bundle o2)
            {
                return o2.cost - o1.cost;
            }
        });
        
        for(int i=0; i<arrayList.size(); i++)
        {
            Bundle cur = arrayList.get(i);
            String grain = "";
            
            if(queue.isEmpty())
                break;
            else
            {
                grain = queue.poll();
            }
            
            int check =0;
            for(int j = cur.start; j<minerals.length; j++)
            {
                if(check == 5)
                    break;
                
                switch(grain)
                {
                    case "dia":
                        answer += 1;
                        break;
                    case "iron":
                        if(minerals[j].equals("diamond"))
                            answer += 5;
                        else
                            answer += 1;
                        break;
                    case "stone":
                        if(minerals[j].equals("diamond"))
                            answer += 25;
                        else if(minerals[j].equals("iron"))
                            answer += 5;
                        else
                            answer += 1;
                        break;
                }
                
                check ++;
                
               
            }
        }
        
        
        // 최소한의 피로도를 return 
        return answer;
    }
    
    class Bundle
    {
        int cost, start;
        
        Bundle(int start, int cost)
        {
            this.start = start; 
            this.cost = cost;
        }
    }
}