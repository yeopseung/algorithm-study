import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        
        PriorityQueue<Job> work = new PriorityQueue<>((j1, j2) -> j1.time - j2.time);
        PriorityQueue<Job> ready = new PriorityQueue<>((j1, j2) -> j1.start - j2.start);
        
        for(int[] job : jobs){
            ready.add(new Job(job[0], job[1]));
        }
        
        while(!work.isEmpty() || !ready.isEmpty()){
            while(!ready.isEmpty() && ready.peek().start <= time){
                work.add(ready.poll());
            }
            
            if(work.isEmpty()){
                time = ready.peek().start;
                continue;
            }
            
            Job cur = work.poll();
            answer += time + cur.time - cur.start;
            time += cur.time;
                        
        }

        return answer / jobs.length;
    }
}

class Job{
    int start, time;
    
    Job(int start, int time){
        this.start = start;
        this.time = time;
    }
}