package hot100;

//寻找旋转排序数组中的最小值
/*注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。

你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。*/
//一眼二分
public class FindMin {

    public int findMin(int[] nums){
        int length= nums.length;
        int l=0,r=length-1;
        while(l<r){
            int mid=(l+r)>>1;
            if(nums[length-1]>nums[mid]){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return nums[l];
    }


    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] nums=new int[]{3,4,5,1,2};
        System.out.println(findMin.findMin(nums));
    }
}
