import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 1; i <= n / 3; i++) {
            int temA = n;
            int a = i * 3;

            temA -= a;
            

            for (int j = 1; j <= temA / 3; j++) {
                int temB = temA;
                int b = j * 3;

                temB -= b;


                for (int k = 1; k <= temB / 3; k++) {
                    int temC = temB;

                    int c = k * 3;

                    temC -= c;


                    if (temC == 0) {

                        result++;
                    }
                }
            }

        }


        System.out.println(result);
    }
}
