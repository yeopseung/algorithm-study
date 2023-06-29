import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        StringTokenizer st, s, e;
        String name, melody, melody_result; 
        int time;
        
        ArrayList<Music> musicList = new ArrayList<>();
        
        for(int i=0; i<musicinfos.length; i++)
        {
            time = 0;
            
            st = new StringTokenizer(musicinfos[i],",");
            
            //시작시간, 종료시간 분해
            s = new StringTokenizer(st.nextToken(),":");
            e = new StringTokenizer(st.nextToken(),":");
            time += (Integer.parseInt(e.nextToken()) - Integer.parseInt(s.nextToken())) * 60;
            time += Integer.parseInt(e.nextToken()) - Integer.parseInt(s.nextToken());
            //음악제목, 멜로디 분해
            name = st.nextToken();
            melody = st.nextToken();
        
            
            //멜로디를 재생시간에 맞게 생성
            int cnt=0;
            melody_result = "";
            for(int j=0; j<melody.length(); j++)
            {
                if(cnt == time)
                    break;
                
                
                char add = melody.charAt(j);
                if(j+1 < melody.length())
                {
                    if(melody.charAt(j+1) == '#')
                    {
                        melody_result += Character.toLowerCase(add);
                        j++;
                    }
                    else
                    {
                         melody_result += add;
                    }
                }
                else
                {
                     melody_result += add;
                }
                
               
                if(add != '#')
                {
                     cnt++;
                }
               
                if(j == melody.length()-1)
                    j=-1;
                
            }
           
            
            
            //Music객체 생성
            musicList.add(new Music(time,name,melody_result));
        }
        
        String M ="";
        for(int i=0; i<m.length(); i++)
        {
            char add = m.charAt(i);
            if(i+1< m.length())
            {
                if(m.charAt(i+1) == '#')
                {
                    
                    M += Character.toLowerCase(add);
                    i++;
                }
                else
                {
                         M += add;
                }
            }
            else
                M += add;
        }
        
        int max = -1;
        for(int i=0; i<musicList.size(); i++)
        {
            Music music = musicList.get(i);
            System.out.println(music.melody);
            System.out.println(music.melody.indexOf(M));
            
            int index = music.melody.indexOf(M);
            if(index != -1)
            {
            
               
                if(music.time > max)
                {
                    answer = music.name;
                    max = music.time;
                }   
            }
        }
        
        if(answer.equals(""))
        {
            answer = "(None)";
        }
        return answer;
    }
}

class Music
{
    int time;
    String name;
    String melody;
    
    Music(int time, String name, String melody)
    {
        this.time = time;
        this.name = name;
        this.melody = melody;
    }
}