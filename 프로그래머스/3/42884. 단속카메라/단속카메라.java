import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        ArrayList<Car> cars = new ArrayList<>();
        
        for(int[] route: routes){
            cars.add(new Car(route[0], route[1])); 
        }
        
        Collections.sort(cars);
        
        int max = cars.get(0).end;
        answer++;
        
        for(Car car: cars){
            if(max < car.start){
                max = car.end;;
                answer++;
            }
        }
        
        return answer;
    }
}

class Car implements Comparable<Car>{
    int start, end;
    
    Car(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Car c){
        return this.end - c.end;
    }
}