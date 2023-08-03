import java.util.*;

public class Main {
    private static List<Integer> negative;
    private static List<Integer> positive;

    private static boolean zero;

    private static int size;
    private static int result;


    public static void main(String[] args) {
        int a,b;
        int tem;

        Scanner scanner = new Scanner(System.in);
        negative = new ArrayList<>();
        positive = new ArrayList<>();


        //수열의 크기 입력
        size = scanner.nextInt();

        //수열의 수 입력
        for (int i=0; i<size; i++)
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
        for(int i=0; i<positive.size(); i++)
        {
            if(i == positive.size()-1 && positive.size()%2 != 0)
            {
                result += positive.get(i);

            }
            else
            {
                a = positive.get(i);
                b = positive.get(i+1);
                result += (a*b);
                i++;
            }
        }

        //음수 계산
        for(int i=0; i<negative.size(); i++)
        {
            if(i == negative.size()-1 && negative.size()%2 != 0)
            {
                if(zero)
                    result += negative.get(i) *0;
                else
                    result += negative.get(i);


            }
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

    public int calculate(int a, int b)
    {
        return a*b;
    }

}

