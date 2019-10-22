package com.wsmOffers.OtherQuestion;

public class PrimeNumber {
    //n:统计2~n之间的质数
    public static void prime(int n) {
        boolean flag;

        for (int i = 2; i <= n; i++) {
            flag = true;
            for (int j = 2; j <=Math.sqrt(i) ; j++) {//Math.sqrt(i)
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int m){
        for(int i = 2;i<=Math.sqrt(m);i++){
            if((m%i) == 0){
                return false;
            }
        }
        return true;
    }

    public static int maxPrime(int n){
        if(n<2){
            return -1;
        }
        if(n==2){return 2;}
        if((n%2)==0){
            n--;
        }
        while(!isPrime(n)){
            n--;
        }
        return n;
    }


    public static void main(String[] args) {
        //prime(100);//97
        System.out.println(maxPrime(15));

    }
}
