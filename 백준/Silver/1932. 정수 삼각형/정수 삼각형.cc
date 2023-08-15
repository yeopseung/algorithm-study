#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
int MaxNum(int a, int b);

int main(void){
    int n;
    int result=INT_MIN;
    int ** num;

    scanf("%d",&n);

    num = (int**)malloc(sizeof(int*)*n);
   

    for(int i=0; i<n; i++){
        num[i] = (int*)malloc(sizeof(int)*n);
        
        for(int j=0;j<=i;j++){
            scanf("%d", &num[i][j]);
        }
        
    }
    
    

    for(int i=1; i<n;i++){
        for(int j=0;j<=i;j++){
            if(j==0){
                num[i][j] = num[i][j]+num[i-1][j];
            }
            else if(i==j){
                num[i][j] = num[i][j]+num[i-1][j-1];
            }
            else{
                num[i][j] = num[i][j] + MaxNum(num[i-1][j-1],num[i-1][j]);
            }

            
        }
    }

    for(int i=0; i<n;i++){
        if(result<num[n-1][i]){
            result = num[n-1][i];
        }
    }
    

    printf("%d",result);

    return 0;

}

int MaxNum(int a, int b){
    if(a>b){
        return a;
    }
    else{
        return b;
    }
}