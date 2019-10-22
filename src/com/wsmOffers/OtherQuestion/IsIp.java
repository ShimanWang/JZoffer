package com.wsmOffers.OtherQuestion;

public class IsIp {
    public static boolean isIpByRegex(String str){
        String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        if(str.matches(regex)){
            String[] arr = str.split("\\.");
            for(int i = 0; i<4; i++){

                if(Integer.valueOf(arr[i]) < 0 || Integer.valueOf(arr[i]) > 255){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String ip = "1921.168.132.101";
        System.out.println(isIpByRegex(ip));
    }
}
