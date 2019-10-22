package com.wsmOffers.Exercise;

public class Solution2 {

    public int countChar(String str) {
        int count=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if((c>='a'&& 'z'>=c) || (c>='A'&&'Z'>=c)){
                count++;

            }

        }

        return count;
    }


    public int countNum(String str) {
        int count=0;
        char[] c=str.toCharArray();
        for(int i=0;i<str.length();i++){
            int num=(int)c[i];
            if(num>=48 && 57>=num){
                count++;
            }

        }
        return count;
    }

    public int countChina(String str) {
        int count=0;
        String regx="[\u4e00-\u9fa5]";
        String[] s=str.split(regx);
        count=s.length-1;
        return count;
    }

}
