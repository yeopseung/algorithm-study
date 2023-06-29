import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File> filelist = new ArrayList<>();
        
        //HEAD, NUMBER, TAIL 분리
        for(int i=0; i<files.length; i++)
        {
            String tem = files[i];
            String h = "";
            String n = "";
            String t = "";
            
            int j=0;
            //HEAD
            for(; j<tem.length();j++)
            {
                //숫자일 경우 HEAD 종료
                char ch = tem.charAt(j);
                if('0'<= tem.charAt(j) && tem.charAt(j)<='9')
                {
                    break;
                }
                h+=ch;
                
            }
            //NUMBER
            for(;j<tem.length();j++)
            {
                //숫자가 아닐경우 NUMBER 종료
                char ch = tem.charAt(j);
                if(tem.charAt(j)<'0' || tem.charAt(j)>'9')
                {
                    break;
                }
                n+=ch;
            }
             //TAIL
            for(;j<tem.length();j++)
            {
                char ch = tem.charAt(j);
                t+=ch;
            }
            
            //분리 결과 저장
            filelist.add(new File(h,n,t));
        }
        
        
        Comparator<File> comparator = new Comparator<File>() 
        {
            @Override
            public int compare(File a, File b) {
                //HEAD 비교
                int result_head = a.head.compareToIgnoreCase(b.head);
                if(result_head == 0)
                {
                     //a,b HEAD가 같을 경우 -> NUMBER 비교
                    int num_a = Integer.parseInt(a.number);
                    int num_b = Integer.parseInt(b.number);
                  
                    return num_a - num_b;
                }
                else
                {
                    return result_head;
                }
                 
                
            }
        };
        
        Collections.sort(filelist,comparator);
      
        for(int i=0; i<filelist.size();i++)
        {
            File f = filelist.get(i);
            StringBuffer sb = new StringBuffer();
            sb.append(f.head);
            sb.append(f.number);
     
            sb.append(f.tail);
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}

class File 
{
    String head;
    String number;
    String tail;
    
    File (String head, String number, String tail)
    {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
}

