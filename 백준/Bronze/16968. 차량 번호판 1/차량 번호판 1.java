import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String carNumber = br.readLine();

        int result = 1;
        char prev = '0', cur;
        for (int i = 0; i < carNumber.length(); i++) {
            cur = carNumber.charAt(i);

            if (cur == 'c') {
                if (prev == cur)
                    result *= 25;
                else
                    result *= 26;

            } else if (cur == 'd') {
                if(prev == cur)
                    result *= 9;
                else
                    result *= 10;
            }

            prev = cur;
        }

        System.out.println(result);
    }
}
