package com.NbasicClass.Class08;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {
    public static class Programe{
        int start ;
        int end ;

        public Programe(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    //按照结束时间早放在前面构造的比较器
    public static class MyComparator implements Comparator<Programe>{

        @Override
        public int compare(Programe o1, Programe o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(int[] starts,int[] ends , int start){
        Programe[] programes = new Programe[starts.length];
        for(int i = 0; i<programes.length; i++){
            programes[i] = new Programe(starts[i],ends[i]);
        }
        Arrays.sort(programes,new MyComparator());
        int count = 0;
        for(int i = 0; i<programes.length; i++){

            if(programes[i].start >= start){
                count++;
                start = programes[i].end;
            }
        }
        return count;
    }

}
