import java.util.*;

class Solution {
    private static final int DIV = 10;
    
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        // 숫자를 이어붙인 문자열 ab, ba를 비교하여 내림차순 정렬
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            }
        };
        
        // 숫자들을 문자열로 변환
        String[] numbersAsString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersAsString[i] = String.valueOf(numbers[i]);
        }
        
        // 문자열로 변환한 숫자들을 comparator를 통해 정렬 
        Arrays.sort(numbersAsString, comparator);
        
        // 정렬한 문자열들을 이어붙여 정답 생성
        for(String s: numbersAsString){
            answer.append(s);
        }
        
        // 예외 처리: 모든 숫자가 0인 경우 "000" -> "0"
        if(answer.charAt(0) == '0'){
            return "0";
        }
                       
        return answer.toString();
    }
}