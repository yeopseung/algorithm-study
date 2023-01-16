package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2179
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, result, cnt;
        String[] words;
        ArrayList<Word> str = new ArrayList<>();
        ArrayList<Similar> arrayList = new ArrayList<>();

        // N : 문장 갯수
        N = Integer.parseInt(br.readLine());

        // 문장 입력
        words = new String[N+1];
        for(int i=0; i<N; i++)
        {
            words[i] = br.readLine();
            str.add(new Word(words[i],i));
        }

        // 문자열을 기준으로 오름차순 정렬
        Collections.sort(str, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.str.compareTo(o2.str);
            }
        });


        result = 0;
        for(int i=0; i<N; i++)
        {
            Word a = str.get(i);

            for(int j=i+1; j<N; j++)
            {
                Word b = str.get(j);


                if(a.str.equals(b.str))
                    continue;

                cnt = 0;
                // 접두사의 길이 측정
                for(int k=0; k<Math.min(a.str.length(),b.str.length()); k++)
                {
                    if(a.str.charAt(k) == b.str.charAt(k))
                        cnt++;
                    else
                        break;
                }

                if(cnt == 0)
                    continue;

                if(result <= cnt)
                {

                    if(b.idx > a.idx)
                    {
                        arrayList.add(new Similar(a.idx,b.idx,cnt));
                    }
                    else
                    {
                        arrayList.add(new Similar(b.idx,a.idx,cnt));
                    }
                    result = cnt;

                }
                else
                    break;

            }
        }


        Collections.sort(arrayList, new Comparator<Similar>() {
            @Override
            public int compare(Similar o1, Similar o2) {

                if((o2.cnt - o1.cnt) == 0)
                {
                    if((o1.s - o2.s) == 0)
                    {
                        return o1.t - o2.t;
                    }

                    return o1.s - o2.s;
                }

                return o2.cnt - o1.cnt;
            }
        });

//        for(int i=0; i<arraㅎyList.size();i++)
//        {
//            System.out.println(arrayList.get(i).s+"  "+arrayList.get(i).t+"  "+arrayList.get(i).cnt);
//        }


        if(arrayList.size() == 0)
        {
            System.out.println("null");
            System.out.println("null");
            return;
        }
        System.out.println(words[arrayList.get(0).s]);
        System.out.println(words[arrayList.get(0).t]);


    }

    static class Word
    {
        String str;
        int idx;

        Word(String str, int idx)
        {
            this.str = str;
            this.idx = idx;
        }
    }

    static class Similar
    {
        int s,t;
        int cnt;

        Similar(int s, int t, int cnt)
        {
            this.s = s;
            this.t = t;
            this.cnt = cnt;
        }
    }

}
