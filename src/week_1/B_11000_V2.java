package week_1;


import java.io.IOException;
import java.util.*;

public class B_11000_V2 {
    public static void main(String[] args) throws IOException {

        Lecture_Comparator cmp = new Lecture_Comparator();
        PriorityQueue<Lecture> lectures = new PriorityQueue<>(cmp);
        PriorityQueue<Integer> ends = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        Lecture l, tmp;

        int N, result =0;

        N = sc.nextInt();

        for(int i=0; i<N ; i++)
        {
            lectures.add(new Lecture(sc.nextInt(),sc.nextInt()));
        }


        while(lectures.size()>0)
        {
            l = lectures.poll();
            lectures.remove(0);
            //System.out.println("remove1 - >start: "+ l.start + "end: "+ l.end);


            Iterator iterator = lectures.iterator();
            while(iterator.hasNext())
            {
                tmp = (Lecture) iterator.next();
                //System.out.println("remove2 -> start: "+ tmp.start + "end: "+ tmp.end);
                if(l.end <= tmp.start)
                {
                    l = tmp;
                    lectures.remove(tmp);
                    break;
                }

            }

            result++;
        }

        System.out.println(result);
    }
}

