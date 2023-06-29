class Solution {
    public int solution(String s) {
         int answer = 0;
        int min = 9999;

        //1~s.length() 의 길이로 잘랐을 때
        for(int i=1; i<=s.length();i++)
        {
            StringBuffer sb = new StringBuffer();
            String str;
            int start = 0;
            int end = i;
            int count;


            //초기값 설정
            str = s.substring(start,end);
            count=0;

            while(end<=s.length())
            {
                
                if(str.equals(s.substring(start,end)))
                {
                    start = end;
                    end += i;
                    count++;
                }
                else {

                    if (count == 1)
                        sb.append(str);
                    else
                        sb.append(count + str);

                    str = s.substring(start, end);

                    start = end;
                    end += i;
                    count = 1;
                }

                if(end > s.length())
                {
                    if (count == 1)
                        sb.append(str);
                    else
                        sb.append(count + str);
                }
              
            }

            if(end> s.length() && start<= s.length())
            {
                sb.append(s.substring(start));
            }

            if(sb.length() < min)
            {
                min = sb.length();
            }


        }




        answer = min;

        return answer;
    }
    
   
}