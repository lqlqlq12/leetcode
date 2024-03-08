package typical150.BinarySearch;

//4.寻找两个正序数组的中位数
/*给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。*/
//思路:二分查找法 假设要查找第k个大的数
//比较nums1[(k-1)/2]和nums2[(k-1)/2]
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if ((len1 + len2) % 2 == 0) {
            return (findK(nums1, nums2, (len1 + len2) / 2) + findK(nums1, nums2, (len1 + len2) / 2 + 1)) / 2.0;
        } else {
            return findK(nums1, nums2, (len1 + len2 + 1) / 2);
        }
    }

    //在两个数组中找到第k小的
    public int findK(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == len1) {
                return nums2[k - 1 + index2];
            }
            if (index2 == len2) {
                return nums1[k - 1 + index1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
