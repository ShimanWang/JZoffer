package com.wsmOffers.OtherQuestion;

public class HowManyDay {

    //字符串分割
    public static String[] stringTodate(String str){
        String[] res = str.split("-");
        return res;
    }

    //判断平年、闰年
    public static boolean year(int date){
        if((date % 4 == 0 && date % 100 !=0) ||(date % 4 == 0)){
            return true;
        }else {
            return false;
        }
    }

    //判断月份有多少天
    public static int daysNum(int year, int month, int day){
        int curmonth = 1;
        int sumDays = 0;
        //计算已经完整过去的月份有多少天
        while (curmonth < month){
            if(curmonth == 1 || curmonth == 3 || curmonth == 5 || curmonth == 7 || curmonth == 8 || curmonth == 10|| curmonth == 12 ){
                sumDays = sumDays+31;
            }else if(curmonth == 4 || curmonth == 6 || curmonth == 9 || curmonth == 11){
                sumDays = sumDays+30;
            }else {
                if(year(year)){
                    sumDays = sumDays+29;
                }else {
                    sumDays = sumDays+28;
                }
            }
            curmonth++;
        }
        sumDays = sumDays + day;
        return sumDays;
    }

    public static void main(String[] args) {
        String date = "2019-4-6";
        String[] res = stringTodate(date);
        System.out.println(res[0]);
        System.out.println(res[1]);
        System.out.println(res[2]);
        int year = Integer.valueOf(res[0]);
        int month = Integer.valueOf(res[1]);
        int day = Integer.valueOf(res[2]);
        int days = daysNum(year,month,day);
        System.out.println(days);
    }
}
