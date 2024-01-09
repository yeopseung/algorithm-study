import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.BitSet;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static String input;
    static BitSet B;
    static int idx, num;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solve();
    }

    static void Solve() throws IOException {
        input = br.readLine();
        st = new StringTokenizer(input);
        B = new BitSet();
        while(st.hasMoreTokens()){
            idx = Integer.parseInt(st.nextToken());
            if(B.get(idx)) continue;
            B.set(idx);
            bw.write(idx + " ");
        }
        bw.flush();
    }
}