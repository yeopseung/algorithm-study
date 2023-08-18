import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int end=99999;
    static ArrayList<House> house = new ArrayList<>();
    static ArrayList<House> chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;


        //N,N 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //치킨집, 집 좌표 저장
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                switch (Integer.parseInt(st.nextToken()))
                {
                    //집
                    case 1:
                        house.add(new House(i,j));
                        break;
                    //치킨집
                    case 2:
                        chicken.add(new House(i,j));
                        break;
                }
            }
        }


        combination(new int[M],0,0,M);
        System.out.println(end);
    }

    static void combination(int[] comb, int index, int count, int left){


        if(left== 0){
            int tem = search(comb);
            if(tem<end)
                end = tem;
            return;
        }

        if(count == chicken.size()) return;

        comb[index] = count;
        combination(comb,index+1, count+1, left-1);
        combination(comb,index,count+1,left);
    }

    static int search(int[] comb)
    {
        int distance;
        int min;
        int result =0;

        House h;
        House c;

        for(int i=0; i< house.size(); i++)
        {
            min = 9999;
            h = house.get(i);

            for(int j=0; j<comb.length; j++)
            {
                c = chicken.get(comb[j]);
                distance = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);

                if(distance < min)
                    min = distance;
            }

            result += min;
        }

        return result;
    }
}

class House
{
    int x,y;

    House(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
