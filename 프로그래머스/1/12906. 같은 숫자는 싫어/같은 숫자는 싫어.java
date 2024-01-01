import java.util.*;

public class Solution {
    public ArrayList solution(int []arr) {
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        
        for(int i: arr){
            queue.add(i);
        }
        
        int cur = -1;
        int prev = -1;
        while(!queue.isEmpty()){
            cur = queue.poll();
            
            if(prev != cur){
                arrayList.add(cur);
            }
            
            prev = cur;
        }
        

        return arrayList;
    }
}