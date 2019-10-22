package com.jianzhiOffer;

public class Solution2 {
    public static String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer("");
        for(int i = 0; i<str.length(); i++){
            char everyWord = str.charAt(i);
            if (everyWord == ' '){
                res.append("%20");
            }else {
                res.append(everyWord);
            }
        }
        String a = null;
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy.")));
    }
}
