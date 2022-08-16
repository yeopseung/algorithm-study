package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1759 {
    static int L, C;
    static char[] alphabet;


    public static void main(String[] args) throws IOException {

        int cnt=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;

        // L,C 입력
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // alphabet 입력
        alphabet = new char[C];
        str = br.readLine();
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i) == ' ')
                continue;

            alphabet[cnt] = str.charAt(i);
            cnt++;
        }
        Arrays.sort(alphabet);


        //탐색
        for(int i=0; i<= (C-L) ; i++)
        {
            dfs(i,new StringBuffer());
        }

    }

    static void dfs(int index, StringBuffer sb)
    {
        StringBuffer next;

        //문자열에 추가
        sb.append(alphabet[index]);


        // 길이가 만족될 경우
        if(sb.length()==L)
        {
            // 자음, 모음 검사
            if(check(sb))
            {
                System.out.println(sb);
            }

            return;
        }

        for(int i= index+1; i<alphabet.length; i++)
        {
            next = new StringBuffer();
            next.append(sb);
            dfs(i,next);
        }



    }

    static boolean check(StringBuffer sb)
    {
        //자음 모음
        int consonant=0, vowel =0;
        for(int i=0; i<sb.length(); i++)
        {
            switch (sb.charAt(i))
            {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowel++;
                    break;

                default:
                    consonant++;
                    break;
            }
        }

        //자음 최소 2개, 모음 최소 1개 이상
        if(vowel>=1 && consonant>=2)
        {
            return true;
        }
        return false;
    }
}
