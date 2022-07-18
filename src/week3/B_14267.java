package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_14267{
    public static void main(String[] args) throws IOException {
        int n, m;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        Company company;

        //n, m 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        //직속 상사 번호 입력
        company = new Company(n);
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
        {
            company.addEdge(i,Integer.parseInt(st.nextToken()));
        }


        int start, good;
        //칭찬 지수 입력
        for(int i=1; i<=m; i++)
        {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            good = Integer.parseInt(st.nextToken());

            company.employees[start].good += good;
        }
        company.dfs(company.employees[1]);

        //칭찬 지수 출력
        for(int i=1; i<=n; i++)
        {
            sb.append(company.employees[i].good + " ");
        }
        System.out.println(sb);
    }
}

class Company
{
    class Employee
    {
        int num;        //자신의 번호
        int good;        //칭찬 횟수

        LinkedList<Employee> adjacent;      //상사-부하 관계


        Employee(int num)
        {
            this.num = num;
            good = 0;

            adjacent = new LinkedList<>();
        }


    }

    Employee[] employees;

    Company(int size)
    {
        employees = new Employee[size+1];

        for(int i=1; i<=size; i++)
        {
            employees[i] = new Employee(i);
        }
    }

    void addEdge(int i1, int i2)
    {
        if(i1 == 1)
            return;

        Employee employee = employees[i1];    //부하
        Employee boss = employees[i2];    //상사

        //상사의 관계도에 부하 추가 (상사->부하)
        if(!boss.adjacent.contains(employee))
        {
            boss.adjacent.add(employee);
        }

    }


    void dfs(Employee r)
    {
        if(r==null)
            return;

        for(Employee n: r.adjacent)
        {
            n.good += r.good;
            dfs(n);
        }
    }
}
