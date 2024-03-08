package hot100;

//寻找两个正序数组的中位数
/*给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。*/
//一眼二分 假设中位数位于k 则每次都选nums1[k/2]和nums2[k/2]进行比较 每次筛选掉一半
public class FindMedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if((len1+len2)%2!=0){
            return findK(nums1,nums2,(len1+len2+1)/2);
        }
        else{
            return (double)(findK(nums1,nums2,(len1+len2)/2)+findK(nums1,nums2,(len1+len2)/2+1))/2.0;
        }
    }

    public int findK(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(len1, index1 + half) - 1;
            int newIndex2 = Math.min(len2, index2 + half) - 1;
            if(nums1[newIndex1]<nums2[newIndex2]){
                k-=(newIndex1-index1+1);
                index1=newIndex1+1;
            }
            else if(nums1[newIndex1]>nums2[newIndex2]){
                k-=(newIndex2-index2+1);
                index2=newIndex2+1;
            }
        }
    }

    public void test(){
        int[] nums1=new int[]{1,2};
        int[] nums2=new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static void main(String[] args) {
        new FindMedianSortedArray().test();
    }
}
