package week1;


import java.io.IOException;
import java.util.*;

public class B_11000 {
    public static void main(String[] args) throws IOException {
        ArrayList<Lecture> lectures = new ArrayList<>();
        Lecture_Comparator cmp = new Lecture_Comparator();
        Scanner sc = new Scanner(System.in);
        Lecture l;

        int N, result =0;

        N = sc.nextInt();

        for(int i=0; i<N ; i++)
        {
            lectures.add(new Lecture(sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(lectures,cmp);

        int k=0;
        while(lectures.size()>0)
        {
            l = lectures.get(k);
            lectures.remove(k);


            for(int j=0 ; j < lectures.size() ; j++)
            {
                if(l.end <= lectures.get(j).start)
                {
                    l = lectures.get(j);
                    lectures.remove(j);
                    //System.out.println("start:" + l.start + "end:" + l.end);
                }
            }
            result++;
        }

        System.out.println(result);
    }
}

class Lecture
{
    int start, end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }


}

class Lecture_Comparator implements Comparator<Lecture>
{
    @Override
    public int compare(Lecture o1, Lecture o2) {
        if(o1.end > o2.end)
            return 1;
        else if(o1.end < o2.end)
            return -1;
        else
            return 0;
    }
}