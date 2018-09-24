/**
 * @author : monsterlin
 * @date : 2017-05-01
 * @desc : 用*号输出字母C的图案
 * */

#include "stdio.h"

int main(void){
    printf("*号输出字母C的图案\n");
    printf("****\n");
    printf("*\n");
    printf("*\n");
    printf("*\n");
    printf("****\n");

    printf("\n");

    for(int i = 1 ; i <= 4 ; i++ ){
        if(i==1||i==4){
            printf("****\n");
        }else{
            printf("*\n");
        }
        
    }
    return 0 ;
}
