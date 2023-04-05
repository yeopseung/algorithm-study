import java.util.*;

/*
    카드는 총 100장 (1~100)
    숫자 하나 선택 (2~100) -> 그 수보다 작거나 같은 숫자 카드들을 준비
    
    준비한 카드의 수 만큼 상자 준비 -> 상자에 카드 한 장씩 넣고 무작위로 섞고 일렬로 나열
    ->나열된 숫자에 1부터 번호 붙임
    
    상자를 연다 -> 카드 숫자를 확인 -> 해당 숫자의 상자를 연다 
    -> 이미 열려있는 상자 or 열게 없을 경우 종료 (1번 상자 그룹)
    
    게임 점수 : 1번 상자를 여는 데 열게 없으면 0점
    게임 점수 : 1번 상자 그룹에 속한 상자 수 * 2번 상자 그룹에 속한 상자의 수  
    
    결과 : 이 게임에서 얻을 수 있는 최고 점수
*/

class Solution {
     boolean[] isOpen;
    
    public int solution(int[] cards) {
        int answer = 0;
        isOpen = new boolean[cards.length+1];
        ArrayList<Integer> group = new ArrayList();
        
        
        for(int i=1; i<=cards.length; i++){
            if(!isOpen[i]){
                group.add(dfs(i-1, cards));
            }
        }
        
        if(group.size() <= 1)
            return 0;
        
        Collections.sort(group);
        answer = group.get(group.size()-1) * group.get(group.size()-2);
        
        return answer;
    }
    
    private int dfs(int i, int[] cards){
        Stack<Integer> stack = new Stack();
        stack.add(cards[i]);
        
        int result = 0;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            isOpen[cur] = true;
            
            result++;
            
            if(!isOpen[cards[cur-1]])
                stack.add(cards[cur-1]);
        }
        
        return result;
    }
}