import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        // 최대 자릿수 계산
        int max = calc_max_decimal(storey);
        System.out.println(max);
        
        // Queue 생성 및 초기값 설정
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(storey, max, 0));
        
        // 순회
        while(!queue.isEmpty()){
            Number cur = queue.poll();
            
            // 0 이면 종료
            if(cur.num == 0){
                answer = cur.cnt;
                break;
            }
            
            // 최대 자리
            int x = (int)Math.abs(cur.num - Math.pow(10, cur.max));
            
            // 최대 자리 -1을 비교
            int y = (int)Math.abs(cur.num - Math.pow(10, cur.max-1));
            
            // 둘 중 절대값이 작은 것을 queue에 추가
            if(x < y){
                queue.add(new Number(x, calc_max_decimal(x), cur.cnt +1));
            }
            else{
                queue.add(new Number(y, calc_max_decimal(y), cur.cnt +1));
            }
            
        }
        
        
        return answer;
    }
    
    private int calc_max_decimal(int storey){
        int result = 0;
        
        while(storey > 0){
            storey /= 10;
            result++;
        }
        
        return result;
    }
}

class Number{
    int num;
    int max;
    int cnt;
    
    Number(int num, int max, int cnt){
        this.num = num;
        this.max = max;
        this.cnt = cnt;
    }
}

// 10의 n승 버튼
// 현재 층수 + 버튼에 적혀있는 값 (단 0보다 작으면 안움직임)
// 가장 아래가 0층이기 때문
// 버튼 한번당 돌 한개 -> 최소한으로 써서 도착하기
// 현재 층 storey 에서 0층으로 갈때 필요한 돌의 최솟값
