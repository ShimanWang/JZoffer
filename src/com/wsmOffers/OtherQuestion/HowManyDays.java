package com.wsmOffers.OtherQuestion;

//判断某一天是这一年的第几天
public class HowManyDays {
    public static boolean isRun(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    public static int monthDays(int year,int month){
        boolean flag = isRun(year);
        int num = 0;
        if(month==2){
            if(flag){
                num = 29;
            }else {
                num = 28;
            }
        }

        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            num = 31;
        }
        if(month==4||month==6||month==9||month==11){
            num = 30;
        }
        return num;
    }

    public static void days(int year,int month,int day){
        int sum = 0;
        for(int i =1;i<month;i++){
            sum = sum+monthDays(year,i);
        }
        sum = sum+day;
        System.out.println("第"+sum+"天");
    }


    public static void main(String[] args) {
        days(2019,3,3);
    }
}
