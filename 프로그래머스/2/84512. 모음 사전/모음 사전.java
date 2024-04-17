import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        
        String[] vowel = {"A", "E", "I", "O", "U"};  
        ArrayList<String> words = new ArrayList<>();

        for(int i=0; i<5; i++){
            String s1 = vowel[i];
            words.add(s1);
            for(int j=0; j<5; j++){
                String s2 = vowel[j];
                words.add(s1+s2);
                for(int k=0; k<5; k++){
                    String s3 = vowel[k];
                    words.add(s1+s2+s3);
                    for(int m=0; m<5; m++){
                        String s4 = vowel[m];
                        words.add(s1+s2+s3+s4);
                        for(int n=0; n<5; n++){
                            String s5 = vowel[n];
                            words.add(s1+s2+s3+s4+s5);
                        }
                    }
                }
            }
        }
        
        Collections.sort(words);
        for(String w: words){
            answer++;
            if(w.equals(word)){
                break;
            }
        }
        
        return answer;
    }

}