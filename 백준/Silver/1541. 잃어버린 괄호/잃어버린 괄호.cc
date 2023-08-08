#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


int main(void) {
    char question[51];
    char* number;

    int result = 0;
    int length;

    scanf("%s", question);

    length = strlen(question);
    bool isMinus = false;

    //처음 처리
    int i;
    for (i = 0; i < length; i++) {
        if (question[i] == '-') {
            isMinus = true;
            number = strtok(question, "-");
            result += atoi(number);
            break;
        }
        else if (question[i] == '+') {
            isMinus = false;
            number = strtok(question, "+");
            result += atoi(number);
            break;
        }
        else if (i == length - 1) {
            number = strtok(question, "+-");
            result += atoi(number);
        }
    }

    int tem = 0;
    for (i; i < length; i++) {
        if (isMinus) {
            if (question[i] == '+') {
                number = strtok(NULL, "+");
                tem += atoi(number);
            }
            else if (question[i] == '-' || i==length-1) {
                isMinus = true;
                number = strtok(NULL, "-");
                tem += atoi(number);
                result -= tem;
                tem = 0;
            }
          
        }
        else {
            if (question[i] == '+' || i== length-1) {
                number = strtok(NULL, "+");
                result += atoi(number);
            }
            else if (question[i] == '-' || i==length-1) {
                number = strtok(NULL, "-");
                result += atoi(number);
                isMinus = true;
            }
        }
    }

    printf("%d", result);

    return 0;

}