package com.jianzhiOffer;

//表示数值的字符串
public class Solution53 {
    public static boolean isNumeric(char[] str) {
        int len = str.length;
        boolean hasE = false;
        boolean hasPoint = false;
        boolean hasSign = false;
        for (int i=0; i<len; i++){

            if(str[i] == 'e' || str[i] == 'E'){                       //(1)
                // 不能同时存在两个e
                if (hasE){
                    return false;
                }
                // e后面一定要接整数  e后面也可以是+-
                int j = i+1;
                //如果e是最后一位，false
                if(j>=len){
                    return false;
                }
                if(str[j] == '+' ||str[j] == '-'){
                    j++;
                }
                while (j<len){
                    if (str[j] >= '0' && str[j] <= '9'){//   (int)str[j]-(int)'0'>=0 && (int)str[j]-(int)'0'<=9
                        j++;
                    }else {
                        return false;
                    }
                }
                hasE = true;
            }else if(str[i] == '+' || str[i] == '-'){                 //(2)
                //第二次出现+-符号，则必须紧接在e之后
                if(hasSign){
                    if(str[i-1]!='e' && str[i-1]!='E'){
                        return false;
                    }
                }
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!hasSign){
                    if(i!=0){
                        if(str[i-1]!='e' && str[i-1]!='E'){
                            return false;
                        }
                    }
                }
                hasSign = true;
            }else if(str[i] == '.'){    //(3) .只可以出现一次
                if (hasPoint){
                    return false;
                }
                hasPoint = true;

            }else if(str[i] < '0' || str[i] > '9'){     //(4)输入不合法
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[] input={'1','2','3','.','4','e','+','5'};
        char[] input={'1','2','e'};
        System.out.println(isNumeric(input));
//        int a = Integer.valueOf('2');
//        System.out.println(a);
//        char s = '2';
//        int res = (int)s - (int)'0';
//        System.out.println(res);
    }
}
