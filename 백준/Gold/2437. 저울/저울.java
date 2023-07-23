import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, result=0;
        boolean end = false;
        ArrayList<Integer> num = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i=0; i<N; i++)
        {
            num.add(scanner.nextInt());
        }
        Collections.sort(num);

        for(int i=0; i<N ; i++)
        {
            if(result+1 < num.get(i))
            {
               break;
            }
            result += num.get(i);
        }
        System.out.println(result+1);
    }
}
