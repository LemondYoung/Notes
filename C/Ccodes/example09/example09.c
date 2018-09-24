/**
 * @ author : monsterlin
 * @ date : 2017-05-04
 * @ desc : 要求输出国际象棋棋盘
 * @ tag : 国际象棋棋盘由64个黑白相间的格子组成，分为8行*8列。用i控制行，j来控制列
 *         根据i+j的和的变化来控制输出黑方格，还是白方格
 **/

# include "stdio.h"

int main(void){

    for(int i = 0 ; i < 8 ; i++){
        for(int j = 0 ; j < 8 ; j++){
            if((i+j)%2 ==0 ){
                 printf("%c%c", 219,219);
               else  printf("\n");
           printf("\n");
            }
        }
    }
    return 0  ;
}
