#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <limits.h> 

void permutation(int level);
void insertOperator(int key, int repeat);
void calculation();

bool isVisit[12];	//위치 체크
int index = 1;

int N;	//숫자 개수
int* num;	//숫자
int* oper; //연산자 저장배열
int tem[12];
int max= INT_MIN, min=INT_MAX;	//최대값, 최소값

int main(void) {
	
	int add, sub, mul, div;	//덧셈, 뺄셈, 곱셈, 나눗셈 개수
	
	scanf("%d", &N);

	num = (int*)malloc(sizeof(int) * N+1);
	oper = (int*)malloc(sizeof(int) * N);

	for (int i = 1; i <= N; i++) {
		scanf("%d", &num[i]);
	}

	scanf("%d %d %d %d", &add, &sub, &mul, &div);
	insertOperator(1, add);
	insertOperator(2, sub);
	insertOperator(3, mul);
	insertOperator(4, div);

	permutation(1);

	printf("%d\n", max);
	printf("%d\n", min);

	return 0;
}



void insertOperator(int key, int repeat) {
	for (int i = 0; i < repeat;i++) {
		oper[index++] = key;
	}
}

void permutation(int level) {

	if (level == N) {
		calculation();
	}

	for (int i = 1; i <= N-1; i++) {
		if (isVisit[i] == true) {
			continue;
		}
		else {
			tem[level] = i;
			isVisit[i] = true;

			permutation(level + 1);

			isVisit[i] = false;
		}
	}

}

void calculation() {
	int sum=num[1];
	for (int i = 1; i <= N - 1; i++) {
		switch (oper[tem[i]])
		{
		case 1:
			sum += num[i+1];
			break;
		case 2:
			sum -= num[i+1];
			break;
		case 3:
			sum *= num[i+1];
			break;
		case 4:
			sum /= num[i+1];
			break;
		default:
			break;
		}
	}

	if (sum >= max) {
		max = sum;
	}
	
	if (sum <= min) {
		min = sum;
	}

	return;
}