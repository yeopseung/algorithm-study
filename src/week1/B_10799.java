package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;


/*
    백준 10799번 쇠막대기

    '()' : 레이저
    '( ~~~ )' : 쇠막대기

    쇠막대기 위에 레이저 개수 n개 -> 잘려진 조각 개수 n+1개

    스택을 이용하여 구현

 */
public class B_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Stick> sticks = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        String input;
        int start, result=0;

        //예제 입력
        input = br.readLine();


        //쇠막대기
        for(int i=0; i< input.length(); i++)
        {
            if(input.charAt(i) == '(')
            {
                //'()' 레이저의 경우 다음 인덱스 ')'
                if(input.charAt(i+1) == ')')
                {
                    i++;
                }
                //쇠막대기일 경우
                else
                {
                    //쇠막대기 시작부분 저장
                    stack.push(i);
                }
            }
            else if(input.charAt(i) == ')')
            {
                //쇠막대기 초기값 설정 및 생성
                //시작 : start, 끝 : i, 레이저 : 0
                start = stack.pop();
                sticks.add(new Stick(start,i,0));

            }

        }
        //레이저
        for (int i=0; i< input.length() ; i++)
        {
            if(input.charAt(i) == '(') {
                //'()' 레이저의 경우 다음 인덱스 ')'
                if (input.charAt(i + 1) == ')') {
                    //쇠막대기의 시작~끝 사이에 레이저가 존재할 경우 조각냄
                    for (Stick stick : sticks) {
                        if (stick.start < i && i < stick.end) {
                            stick.count++;
                        }
                    }
                    i++;
                }
            }
        }

        for (Stick stick : sticks) {
            result += stick.count + 1;
        }
        System.out.println(result);
    }
}

class Stick {
    //쇠막대기 시작, 끝 인덱스
    int start, end;
    //쇠막대기 위에 레이저 개수
    int count;

    public Stick(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

}