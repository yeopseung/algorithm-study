import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int[] names;
	static int[][] grid = new int[1000][1002];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		names = new int[n];
		
		for(int i=0; i<n; i++) {
			names[i] = sc.nextInt();
		}
		sc.close();
		
		int idx = 1;
		int cnt = names[0] + 1; // 이름 수
		for(int i=0; i<grid.length; i++) {
			Arrays.fill(grid[i], -1);
		}
		System.out.println(check(idx, cnt));
	}

	public static int check(int idx, int cnt) {
		if(idx == n) return 0;
		int ans = grid[idx][cnt];
		if(ans != -1) return ans;
        	// 1. 다음줄에 쓰는 경우
		int left = m - cnt + 1; // 남은 칸 수
		ans = check(idx+1, names[idx]+1) + (left * left);
		
        	// 2. 현재줄에 이어쓰는 경우
		if(cnt + names[idx] <= m) {
			ans = Math.min(check(idx+1, cnt + names[idx] + 1), ans);
		}
		grid[idx][cnt] = ans;
		return ans;
	}
}