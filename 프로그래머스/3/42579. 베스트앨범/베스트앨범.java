import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, ArrayList<Music>> musics = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            
            if(!musics.containsKey(genre)){
                musics.put(genre, new ArrayList<>());
                total.put(genre, 0);
            }
            
            total.put(genre, total.get(genre) + plays[i]);
            musics.get(genre).add(new Music(i, plays[i]));
        }
        
        
        ArrayList<String> keySet = new ArrayList<>(total.keySet());
        keySet.sort((o1, o2) -> total.get(o2).compareTo(total.get(o1)));
        
        for(String key: keySet){
            ArrayList<Music> m = musics.get(key);
            Collections.sort(m);
            
            int length = m.size() < 2 ? m.size() : 2;
            for(int i=0; i<length; i++){
                answer.add(m.get(i).num);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}


class Music implements Comparable<Music>{
    int num, plays;
    
    Music(int num, int plays){
        this.num = num;
        this.plays = plays;
    }
    
    @Override
    public int compareTo(Music m){
        return m.plays - this.plays;
    }
    
}