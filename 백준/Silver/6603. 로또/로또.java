import java.util.*;
public class Main{
    public static int[] arr, ans;
    public static boolean[] visit;
    public static int n;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        while(true) {
            n = scan.nextInt();
            if(n == 0) {
            	break;
            }
            visit = new boolean[n];
            arr = new int[n];
            ans = new int[n];
            for(int i = 0	; i < n; i++){
                arr[i] = scan.nextInt();
            }
            dfs(0,0);
            System.out.println();
        }
    }
    public static void dfs(int start,int depth){
        if(depth == 6){
            for(int i = 0; i < 6; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
        for(int i = start; i < n; i++){
            if(!visit[i]){
            	ans[depth] = arr[i];
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}