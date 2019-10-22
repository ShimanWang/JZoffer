package com.jianzhiOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

//数据流中的中位数
/*准备两个堆，一个大根堆，一个小根堆
1.第一个数字进入大根堆
2.要准备比较的数字<=大根堆的堆顶元素，扔进大根堆；否则扔进小根堆
3.两个堆中的数据量大小差值超过1，就把较大的数据（堆顶数据）弹出来，放到另外一个堆中
这样可以使中位数只会出现在两个堆的交接处
* */
public class Solution63 {
    private PriorityQueue<Integer> minHeap ;
    private PriorityQueue<Integer> maxHeap ;
    private int count ;

    public Solution63(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        count = 0;
    }


    public void Insert(Integer num) {
        count++;
        if (count == 1){
            maxHeap.add(num);
        }else if(num <= maxHeap.peek()){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }

        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }

    }

    public Double GetMedian() {
        if(count == 0){
            throw  new RuntimeException("count = 0 无中位数");
        }
        if(count%2 == 0){
            return  (maxHeap.peek()+minHeap.peek())/2.0;
        }else {
            if(maxHeap.size() > minHeap.size()){
                return (double) maxHeap.peek();
            }else {
                return (double) minHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        Solution63 s63 = new Solution63();
        s63.Insert(1);
        System.out.println(s63.GetMedian());
        s63.Insert(2);
        System.out.println(s63.GetMedian());
        s63.Insert(3);
        System.out.println(s63.GetMedian());

    }
}
