#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>



int main(void) {

	//N:세로 M:가로
	int N, M;

	//보드 크기 입력 
	while (1) {
		scanf("%d%d", &N, &M);
		if (8 <= N && N <= 50) {
			if (8 <= M && M <= 50) {
				fflush(stdin);
				break;
			}
		}
	}

	//보드 동적할당
	char** board;
	board = (char**)malloc(sizeof(int*) * N);
	for (int i = 0; i < N; i++) {
		board[i] = (char*)malloc(sizeof(int) * M);
	}

	char ch;
	//보드에 B or W 입력
	for (int i = 0; i < N; i++) {
		while (true) {


			scanf("%s", board[i]);

			if (getchar() == '\n') {
				break;
			}
			else {
				ch = getchar();
				while (ch != '\n') {
					ch = getchar();
				}
			}
		}

	}


	char startColor;
	char requestColor;
	int change;
	int minchange = 999999999;
	//8X8 체스판 반복 가로 M-8 / 세로 N-8
	for (int i = 0; i <= N - 8; i++) {
		for (int j = 0; j <= M - 8; j++) {


			for (int k = 1; k <= 2; k++) {
				if (k == 1) {
					startColor = 'W';
					requestColor = 'B';
				}
				else {
					startColor = 'B';
					requestColor = 'W';
				}

				//8X8 체스판 변경 횟수 측정
				change = 0;
				for (int n = i; n < i + 8; n++) {
					for (int m = j; m < j + 8; m++) {
						//requestColor와 색이 같으면 change 필요 없음, 다음 색으로 반전
						//requestColor와 색이 다르면 change 필요함, 다음 색으로 반전 

						if (board[n][m] != requestColor) {
							change++;
							if (change > minchange) {
								break;
							}
						}
						if (m != j + 7) {
							//색 반전
							if (requestColor == 'W') {
								requestColor = 'B';
							}
							else if (requestColor == 'B') {
								requestColor = 'W';
							}
						}
					}
				}


				//최소 변경 횟수 저장
				if (change < minchange) {
					minchange = change;
				}
			}

		
		}
	}

	//최소 변경 횟수 결과 출력
	printf("%d", minchange);

	return 0;
}

