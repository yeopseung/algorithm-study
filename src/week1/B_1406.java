package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1406 {
    public static void main(String[] args) throws IOException {
        int cursor, M;

        StringBuffer sb = new StringBuffer();
        //Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //편집기에 입력되어있는 문자열
        sb.append(br.readLine());

        //입력할 명령어의 개수
        M = Integer.parseInt(br.readLine());

        //초기 커서
        cursor = sb.length();

        //명령어 처리
        for(int i=0; i<M ; i++)
        {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken())
            {
                //커서의 위치를 왼쪽으로 한칸 (맨 왼쪽일 경우 무시)
                case "L":
                    if(cursor != 0)
                    {
                        cursor--;
                    }
                    break;
                //커서의 위치를 오른쪽으로 한칸 (맨 오른쪽일 경우 무시)
                case "D":
                    if(cursor != sb.length())
                    {
                        cursor++;
                    }
                    break;
                //커서 왼쪽에 있는 문자 삭제 (맨 왼쪽일 경우 무시)
                case "B":
                    if(cursor != 0)
                    {
                        sb.deleteCharAt(cursor-1);
                        cursor--;

                    }
                    break;
                //문자를 커서 왼쪽에 추가
                case "P":
                    sb.insert(cursor,st.nextToken());
                    cursor++;

                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
