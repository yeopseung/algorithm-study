import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    private static int N, M, start, end;
    private static HashMap<Integer, ArrayList<Bridge>> island;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int s, e, w, low, mid, high;

        st = new StringTokenizer(br.readLine());
        // N: 섬의 개수
        N = Integer.parseInt(st.nextToken());
        // M: 다리의 개수
        M = Integer.parseInt(st.nextToken());

        low = 1;
        mid = 1;
        high = 1;
        island = new HashMap<>();
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if(!island.containsKey(s))
                island.put(s,new ArrayList<>());

            if(!island.containsKey(e))
                island.put(e,new ArrayList<>());

            island.get(s).add(new Bridge(e,w));
            island.get(e).add(new Bridge(s,w));

            high = Math.max(high, w);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while(low <= high)
        {
            mid = (low+high)/2;

            if(BFS(mid))
                low = mid +1;
            else
                high = mid -1;
        }

        System.out.println(high);
    }

    private static boolean BFS(int mid)
    {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty())
        {
            int cur = queue.poll();

            if(cur == end)
                return true;

            for(Bridge bridge : island.get(cur))
            {
                if(!visited[bridge.destination] && mid <= bridge.weight)
                {
                    queue.add(bridge.destination);
                    visited[bridge.destination] = true;
                }
            }
        }
        return false;
    }

    static class Bridge
    {
        int destination, weight;

        Bridge(int destination, int weight)
        {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
