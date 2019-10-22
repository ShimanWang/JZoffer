package com.NbasicClass.Class08;


import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    //项目
    public static class Programe{
        private int cost;
        private int profit;

        public Programe(int cost, int profit){
            this.cost = cost;
            this.profit = profit;
        }
    }

    //两个比较器
    public static class MinCost implements Comparator<Programe>{

        @Override
        public int compare(Programe o1, Programe o2) {
            return o1.cost-o2.cost;
        }
    }

    public static class MaxProfit implements Comparator<Programe>{

        @Override
        public int compare(Programe o1, Programe o2) {
            return o2.profit - o1.profit;
        }
    }

    /**
     *
     * @param k 项目数
     * @param money  给的钱数
     * @param costs  花费数组
     * @param profits  利润数组
     * @return  最大利润
     */
    public static int maxProfitMethod(int k ,int money,int[] costs, int[] profits){
        //Programe的数组里面放着所有的项目
        Programe[] programes = new Programe[profits.length];
        for(int i = 0; i<profits.length; i++){
            programes[i] = new Programe(costs[i],profits[i]);
        }

        PriorityQueue<Programe> minCost = new PriorityQueue<>(new MinCost());
        PriorityQueue<Programe> maxProfit = new PriorityQueue<>(new MaxProfit());

        for(int i = 0; i<programes.length;i++){
            minCost.add(programes[i]);
        }

        //依次做项目，一共做k个
        for(int i = 0; i<k ;i++){
            while (minCost.peek().cost<=money && minCost.size()!=0){
                maxProfit.add(minCost.poll());
            }
            if(maxProfit.size() == 0){
                return money;
            }
            money = money + maxProfit.peek().profit;
        }
        return money;
    }
}
