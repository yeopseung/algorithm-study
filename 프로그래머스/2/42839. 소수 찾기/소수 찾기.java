import java.util.*;

class Solution {
    private static int answer = 0;
    private static int n = 0;
    private static int[] arr;
    private static boolean[] checked = new boolean[10000000];
    
    public int solution(String numbers) {
        
        n = numbers.length();
        
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Character.getNumericValue(numbers.charAt(i));
        }
        
        for(int r=1; r <= n ; r++){
            permutation(arr, new boolean[n], new int[n], 0, n, r);
        }
        
        return answer;
    }
    
    private static void permutation(int[] arr, boolean[] visited, int[] res, int depth, int n, int r){
        if(depth == r){
            int num = convertToNumber(res, r);
            
            if(num < 2){
                return;
            }
            
            if(!checked[num]){
                checked[num] = true;
            
                boolean isPrime = calcPrimeNumber(num);
            
                if(isPrime){
                    answer++;
                }
            }
           
            
            return;
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                res[depth] = arr[i];
                permutation(arr, visited, res, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
    
    private static int convertToNumber(int[] result, int r){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<r ; i++){
           sb.append(result[i]);
        }
        
        
        
        return Integer.parseInt(sb.toString());
    }
    
    private static boolean calcPrimeNumber(int num){
        if(num == 1){
            return false;
        }
        
        for(int i=2; i*i<=num; i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    } 
    
}

