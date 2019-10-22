package com.jianzhiOffer;

//把字符串转换成整数
public class Solution49 {
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();
        boolean isNegative = true;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i==0 && (arr[i]=='+' || arr[i] == '-')){
                if(arr[i]=='+' )  isNegative=true;
                if(arr[i]=='-') isNegative = false;
                continue;
            }
            if(arr[i]<'0' || arr[i]>'9'){
                return 0;
            }
            res = res*10+(arr[i]-'0');
        }
        if(isNegative){
            return res;
        }else {
            return -res;
        }
    }

    public static void main(String[] args) {
        String str = "-123";
        int res = StrToInt(str);
        System.out.println(res);
    }
}
