#include <stdio.h>

typedef struct{
    int zero;
    int one;
}Count;

Count fibonacci(int n);



Count count[41];


int main(void){

    int T;
    int n;
    
    scanf("%d",&T);

    count[0].zero=1;
    count[0].one=0;
    count[1].zero=0;
    count[1].one=1;
    
    for(int i=0; i<T; i++){
        scanf("%d",&n);
        fibonacci(n);
        printf("%d %d\n", count[n].zero, count[n].one);
    }

    return 0;
  
   
}

Count fibonacci(int n) {
    
   if(count[n].zero == 0 && count[n].one == 0){
       count[n-1] = fibonacci(n-1);
       count[n-2] = fibonacci(n-2);
       count[n].one = count[n-1].one + count[n-2].one;
       count[n].zero = count[n-1].zero + count[n-2].zero;
   }

    return count[n];
}