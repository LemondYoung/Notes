/**
 * @author : monsterlin
 * @date : 2017-05-01
 * @desc : 输出特殊的C图案
 * */

#include "stdio.h"
int main(){
    char a=176,b=219;
     printf("%c%c%c%c%c\n",b,a,a,a,b);
     printf("%c%c%c%c%c\n",a,b,a,b,a);
     printf("%c%c%c%c%c\n",a,a,b,a,a);
     printf("%c%c%c%c%c\n",a,b,a,b,a);
     printf("%c%c%c%c%c\n",b,a,a,a,b);
     return 0;
}
