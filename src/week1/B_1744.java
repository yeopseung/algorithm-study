package week1;

import java.util.*;

/*
백준 1744번 수 묶기

양수 (1 제외)
-짝수 : 큰 숫자들을 우선적으로 묶어 계산
-홀수 : 큰 숫자들을 우선적으로 묶어 계산한 후 남은 숫자 더해줌

숫자 1
-그냥 더해줌

숫자 0
-음수가 홀수일때 : 가장 큰 음수와 묶어 계산
-그 외: 무시

음수
-짝수 : 작은 숫자들을 우선적으로 묶어 계산
-홀수,0 존재 : 작은 숫자들을 우선적으로 묶어 계산한 후 남은 숫자와 0을 결합하여 계산
-홀수,0 존재x : 작은 숫자들을 우선적으로 묶어 계산한 후 남은 숫자를 더해줌

 */
public class B_1744 {

    private static boolean zero;

    private static int result;


    public static void main(String[] args) {
        int a,b;
        int tem;

        Scanner scanner = new Scanner(System.in);
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();


        //수열의 크기 입력
        int size = scanner.nextInt();

        //수열의 수 입력
        for (int i = 0; i< size; i++)
        {
            tem = scanner.nextInt();
            if(tem>1)
                positive.add(tem);
            else if(tem==1)
                result += 1;
            else if(tem==0)
                zero = true;
            else if(tem<0)
                negative.add(tem);
        }



        //양수 내림차순 정렬
        Collections.sort(positive,Collections.reverseOrder());
        //음수 오름차순 정렬
        Collections.sort(negative);



        //양수 계산
        for(int i = 0; i< positive.size(); i++)
        {
            //홀수일때 마지막 숫자 계산
            if(i == positive.size()-1 && positive.size()%2 != 0)
            {
                result += positive.get(i);

            }
            //큰 숫자 우선으로 묶어 계산
           else
            {
                a = positive.get(i);
                b = positive.get(i+1);
                result += (a*b);
                i++;
            }
        }

        //음수 계산
        for(int i = 0; i< negative.size(); i++)
        {
            //홀수이며 0이 존재하면 가장 큰 음수와 0 묶음
            if(i == negative.size()-1 && negative.size()%2 != 0)
            {
                if(zero)
                    result += negative.get(i) *0;
                else
                    result += negative.get(i);


            }
            //작은 숫자 우선으로 묶어 계산
            else
            {
                a = negative.get(i);
                b = negative.get(i+1);
                result += (a*b);
                i++;
            }
        }

        System.out.println(result);
    }
}

