import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 9999;

    //재료 개수
    static int N;
    //최소 단백질 지방 탄수화물 비타민
    static int mp, mf, ms, mv;
    //단백질 지방 탄수화물 비타민 가격 저장
    static int[] p, f, s, v, c;
    //최소 비용
    static int min = MAX;
    //최소 비용일때 재료
    static ArrayList<Integer> result = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //입력
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());


        p = new int[N + 1];
        f = new int[N + 1];
        s = new int[N + 1];
        v = new int[N + 1];
        c = new int[N + 1];
        for (int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            f[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        //탐색시작
        search(1,new Nutrient(0,0,0,0,0));

        //결과출력

        if(min == MAX)
        {
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }
        Collections.sort(result);
        for(int i : result)
        {
            System.out.print(i+" ");
        }
        System.out.println();

    }

    static void search(int index, Nutrient nutrient)
    {

//        System.out.println(" p : " + nutrient.p +" f : " + nutrient.f+" s : " + nutrient.s+" v : " + nutrient.v+" c : " + nutrient.c);
//        for(int i : nutrient.list)
//        {
//            System.out.print(i +" ");
//        }
//        System.out.println();

        //최소 영양소 조건 만족하며
        if((index >=1 && nutrient.p >= mp && nutrient.f >= mf && nutrient.s >= ms && nutrient.v >= mv))
        {
            //최소 비용일 경우
            if(nutrient.c <= min)
            {
                min = nutrient.c ;
                result = (ArrayList<Integer>) nutrient.list.clone();
            }
            return;
        }

        if(index == N+1)
        {
            return;
        }

        //index 번째를 선택하지 않았을 때
        search(index+1,new Nutrient(index,nutrient.p,nutrient.f,nutrient.s,nutrient.v,nutrient.c,nutrient.list));

        //index 번째를 선택했을 때
        search(index+1,new Nutrient(index,nutrient.p+p[index],nutrient.f+f[index],nutrient.s+s[index],nutrient.v+v[index],nutrient.c+c[index],nutrient.list));

    }
}

class Nutrient
{
    int p,f,s,v,c;
    ArrayList<Integer> list = new ArrayList<>();


    public Nutrient(int p, int f, int s, int v, int c)
    {
        this.p = p;
        this.f = f;
        this.s = s;
        this.v = v;
        this.c = c;
    }

    public Nutrient(int index ,int p, int f, int s, int v, int c,ArrayList<Integer> list) {
        this.p = p;
        this.f = f;
        this.s = s;
        this.v = v;
        this.c = c;
        this.list = (ArrayList<Integer>) list.clone();
        list.add(index);
    }
}