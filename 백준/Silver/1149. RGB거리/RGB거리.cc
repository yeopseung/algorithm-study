#include <stdio.h>
#include <stdlib.h>


typedef struct{
    int red;
    int green;
    int blue;
    int check;  //1:red 2:green 3:blue
}Home;

int MinCost(int a, int b);
Home home[1001];
Home cost[1001];

int main(void){

    int N;
    int result;

    scanf("%d",&N);

    for(int i=1; i<=N; i++){
        scanf("%d %d %d",&home[i].red,&home[i].green,&home[i].blue);
    }

    cost[1].red = home[1].red;
    cost[1].green = home[1].green;
    cost[1].blue = home[1].blue;

    for(int i=2; i<=N;i++){

        cost[i].red = home[i].red +MinCost(cost[i-1].green,cost[i-1].blue);
        cost[i].green = home[i].green +MinCost(cost[i-1].red,cost[i-1].blue);
        cost[i].blue = home[i].blue + MinCost(cost[i-1].red,cost[i-1].green);

    }

    result = MinCost(MinCost(cost[N].red,cost[N].green),cost[N].blue);
    printf("%d",result);

    return 0;
   
}

int MinCost(int a, int b){
    if(a>b){
        return b;
    }
    else{
        return a;
    }
}


