/**
 * @ author : monsterlin
 * @ date : 2017-05-04
 * @ desc : 输出9*9口诀
 * */

# include "stdio.h"

int main(void){

    for (int i = 1 ; i <10 ; i ++){
        for(int j = 1 ; j < 10 ; j ++){
            printf("%d * %d = %3d ", i , j , i*j);  //3d表示左对齐，占3位
        }

        printf("\n");
    }
    return 0 ;
}
