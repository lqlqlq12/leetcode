package hot100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//数组中的第k个最大元素
/*给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题*/
//快速选择 改进快速排序算法,但每次选择排序左区间或右区间 O(n)
//堆排序 用一个小顶堆,堆容量为k 每次出堆的都是小元素 剩下的就是大元素 O(nlogk)
public class FindKthLargest {

    public int findKthLargest(int[] nums,int k){
        return quick_select(nums,0,nums.length-1,k);
    }

    public int quick_select(int[] nums,int left,int right,int k){
        int l=left,r=right;
        int t=nums[l];
        for(int i=l;i<=r;){
            if(nums[i]<t){
                int num=nums[i];
                nums[i]=nums[l];
                nums[l]=num;
                l++;
                i++;
            }
            else if(nums[i]>t){
                int num=nums[i];
                nums[i]=nums[r];
                nums[r]=num;
                r--;
            }
            else{
                i++;
            }
        }
        if(right-r+1<=k&&right-l+1>=k){
            return t;
        }
        if(right-r+1>k){
            return quick_select(nums,r+1,right,k);
        }
        else{
            return quick_select(nums,left,r-1,k-(right-r+1));
        }
    }

    public int heapSort(int[] nums,int k){
        PriorityQueue<Integer> heap=new PriorityQueue<>(k,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o1-o2;
            }
        });
        for (int num : nums) {
            if(heap.size()==k) {
                if(num>heap.peek()) {
                    heap.offer(num);
                    heap.poll();
                }
            }
            else{
                heap.offer(num);
            }
        }
        return heap.peek();
    }

}
