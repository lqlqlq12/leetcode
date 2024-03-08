package hot100;

import java.util.PriorityQueue;

//使用大小顶堆维护中位数
public class MedianFinder {

    //小于等于中位数
    PriorityQueue<Integer> small;

    //大于中位数
    PriorityQueue<Integer> large;
    public MedianFinder() {
        large=new PriorityQueue<Integer>();
        small=new PriorityQueue<Integer>((a,b)->(b-a));
    }

    public void addNum(int num) {
        if(small.isEmpty()||num<=small.peek()){
            small.offer(num);
            if(small.size()-1>large.size()){
                large.offer(small.poll());
            }
        }
        else{
            large.offer(num);
            if(large.size()>small.size()){
                small.offer(large.poll());
            }
        }
    }

    public double findMedian() {
        if(small.size()==large.size()){
            return (small.peek()+large.peek())/2.0;
        }
        return small.peek();
    }

}
