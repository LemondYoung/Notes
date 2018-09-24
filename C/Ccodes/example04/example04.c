/**
 * @ author : monsterlin
 * @ date : 2017-04-30
 * @ desc : 输入某年某月某日，判断这一天是这一年的第几天？
 **/ 

# include <stdio.h>

int main(void){

    int day , month , year , sum , leap ;
    printf("\n 请输入年 月 日 ， 格式为 ： 年，月，日 (2015,12,10)\n");
    scanf("%d,%d,%d", &year,&month,&day); // 格式为2016，12，10

    switch(month){
        // 先计算某月以前的天数
        case 1 : sum = 0 ; break;
        case 2 : sum = 31 ; break ;
        case 3 : sum = 59 ; break ; //待定2月有28天，闰年和平年的区别
        case 4 : sum = 90 ; break ;
        case 5 : sum = 120 ; break ;
        case 6 : sum = 151 ; break ;
        case 7 : sum = 181 ; break ;
        case 8 : sum = 212 ; break ;
        case 9 : sum = 243 ; break ;
        case 10 : sum = 273 ; break ;
        case 11 : sum = 304 ; break ;
        case 12 : sum = 334 ; break ;
        default : printf("data error "); break ; 
    }


    sum += day ; 


    //判断是否为闰年
    if(year%400 == 0 || (year%4 ==0 && year%100 != 0 )){
        leap = 1; 
    }else {
        leap = 0 ;
    }

    if(leap == 1 && month > 2){
        sum ++ ; 
    }

    printf("这是这一年的第 %d 天", sum);

    return 0 ; 
}
