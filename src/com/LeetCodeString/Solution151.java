package com.LeetCodeString;

/*反转字符串里的单词
输入: "the sky is blue"
输出: "blue is sky the"

输入: "a good   example"
输出: "example good a"

输入: "  hello world!  "
输出: "world! hello"
要求：
1.如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
2.输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括
* */
public class Solution151 {
    public static String reverseWords(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        //1.先反转整个句子
        reverse(arr,0,s.length()-1);
        //2.反转每一个单词
        reverseWord(arr);
        //3.处理单词之间多余的空格
        return deletSpace(arr);
    }

    //反转操作(用两个指针i j)
    public static void reverse(char[] arr,int i, int j){
        while (i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    //反转每一个单词(用两个指针i j)
    public static void reverseWord(char[] arr){
        int i = 0;
        int j = 0;
        while (i < arr.length){
            //找到单词的起始位置坐标
            while (arr[i] == ' '){
                i++;
            }
            //找到单词的结束位置坐标
            while (j<i || arr[j] != ' '){
                j++;
                if(j==arr.length){
                    break;
                }
            }
            reverse(arr,i,j-1);
            i = j;
        }
    }


    //处理单词之间多余的空格
    public static String deletSpace(char[] arr){
        int i = 0;
        int j = 0;
        while (i < arr.length){
//            while (i < arr.length && arr[i]==' '){
//                i++;
//            }
            while (i < arr.length && arr[i]!=' '){
                arr[j++] = arr[i++];
            }
            //将所有空格跳过
            while (i < arr.length && arr[i]==' '){
                i++;
            }
            //最后一个的话就不用加空格了
            if(i < arr.length){
                arr[j++] = ' ';
            }
        }
        return String.valueOf(arr).substring(0,j);

    }

    public static void main(String[] args) {
        String s = "    the     sky is blue";
        String res = reverseWords(s);
        System.out.println(res);
        System.out.println(res.length());
    }
}
