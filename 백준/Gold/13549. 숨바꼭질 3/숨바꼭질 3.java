import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main {
	static StringTokenizer st;
	static int start;
	static int end;
	static int[] len;
	static boolean[] check;
	static Deque<Integer> q;

	public static void main(String args[]) throws Exception {
		//---------------------입력 시작--------------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		len = new int[200000];
		check = new boolean[200000];
		q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true; 
		//---------------------------------------------------
		if(start == end) { // 수빈이와 동생이 같은 곳에 있는 경우 예외처리
			System.out.println(0);
			return;
		}
		//------------------bfs 시작---------------------------------
		while(!q.isEmpty()) { 
			int cur = q.peekFirst(); q.pollFirst();
			int curLen = len[cur];
			
			//-------------------답을 찾은 경우---------------------------
			if(cur*2 == end) { // 입력으로 1 2가 들어온 경우때문에 따로 앞에 두었습니다.
				System.out.println(curLen);
				return;
			}
			if(cur+1 == end || cur-1 == end ) {
				System.out.println(curLen+1);
				return;
			}
			//----------------------bfs 큐에 넣기 ------------------
			if(cur*2 < len.length && !check[cur*2]) { // 거리가 0이니까 앞에다 넣고
				len[cur*2] = curLen;
				check[cur*2] = true;
				q.addFirst(cur*2);
			}
			
			if(cur-1 >= 0 && !check[cur-1]) { // 거리가 1이면 뒤에다 넣는다.
				len[cur-1] = curLen+1;
				check[cur-1] = true; 
				q.addLast(cur-1);
			}
			
			if(cur+1 < len.length && !check[cur+1]) {
				len[cur+1] = curLen+1;
				check[cur+1] = true; 
				q.addLast(cur+1);
			}
		
		
			
		}
	}
}
