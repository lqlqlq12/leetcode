package typical150.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//查找和最小的k对数字
/*给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。

定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。

请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) */
//一眼大根堆,把大的都踢出去,剩下的就是小的了 结果太慢......
//堆的真正用法:用小顶堆,当(i,j)出堆时,说明此时(i,j)之和最小,那么次小的就是(i+1,j)和(i,j+1)
//这样会有重复,例如(0,0)出堆后,(1,0)(0,1)就要入堆,再往后就是(1,1)(2,0)和(1,1)(0,2)就有重复了
//如何避免重复：(i,j)出堆后,只入堆(i,j+1)这样依次就有(0,0),(0,1),(0,2),(0,3).....
//所以我们先把所有(i,0)入堆,i从0到Math(k,len1)-1 还有一个可以优化的就是队列存的数组长度可以从3简化为2
//几个小优化,初始化堆的时候,可以指定好容量,然后自定义排序的lambda表达式用return也可以快一点,还有把re.size()<k改成k-->0也可以快一点
//二分法,用二分法找到一个尽量小的值，使得小于这个值的求和对的数量大于等于k,然后把小于的求和对添加到答案里,再从相等的求和对中添加到达到要求
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //建立大根堆
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        List<List<Integer>> re = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int iIndex = Math.min(len1, (int) Math.sqrt(k) + 1);
        int jIndex = Math.min(len2, (int) Math.sqrt(k) + 1);
        if (len1 < Math.ceil(Math.sqrt(k))) {
            iIndex = len1;
            jIndex = k / len1 + 1;
        }
        if (len2 < Math.ceil(Math.sqrt(k))) {
            jIndex = len2;
            iIndex = k / len2 + 1;
        }
        for (int i = 0; i < iIndex; i++) {
            for (int j = 0; j < jIndex; j++) {
                if (heap.size() == k) {
                    int sum = nums1[i] + nums2[j];
                    if (sum < heap.peek()[2]) {
                        heap.poll();
                        heap.offer(new int[]{i, j, sum});
                    } else {
                        break;
                    }
                } else {
                    heap.offer(new int[]{i, j, nums1[i] + nums2[j]});
                }
            }
        }
        while (!heap.isEmpty()) {
            int[] pairs = heap.poll();
            List<Integer> t = new ArrayList<>();
            t.add(nums1[pairs[0]]);
            t.add(nums2[pairs[1]]);
            re.add(t);
        }
        return re;
    }

    //小根堆 每次选可能的解
    public List<List<Integer>> kSmall(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        List<List<Integer>> re = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < Math.min(k, len1); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (!pq.isEmpty() && re.size() < k) {
            int[] pairs = pq.poll();
            List<Integer> t = new ArrayList<>();
            t.add(nums1[pairs[0]]);
            t.add(nums2[pairs[1]]);
            re.add(t);
            if (pairs[1] + 1 < len2) {
                pq.offer(new int[]{pairs[0], pairs[1] + 1});
            }
        }
        return re;
    }

    public List<List<Integer>> binarySearch(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        List<List<Integer>> re = new ArrayList<>();
        int left = nums1[0] + nums2[0], right = nums1[len1 - 1] + nums2[len2 - 1];
        int target = 0;
        //下面这行代码有很大的坑,因为len1*len2可能超过Integer.MAX_VALUE了,超过内存限制的幕后黑手
//        if (len1 * len2 <= k) {
        if (k / len1 > len2) {
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    List<Integer> t = new ArrayList<>();
                    t.add(nums1[i]);
                    t.add(nums2[j]);
                    re.add(t);
                }
            }
            return re;
        }
        while (left < right) {
            int mid = (int) (0L + left + right) >> 1;
            int numbers = 0;
            for (int i = 0; i < len1 && numbers < k; i++) {
                for (int j = 0; j < len2 && numbers < k; j++) {
                    if (nums1[i] + nums2[j] <= mid) {
                        numbers++;
                    } else {
                        break;
                    }
                }
            }
            if (numbers >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        target = left;
        for (int i = 0; i < len1 && k > 0; i++) {
            for (int j = 0; j < len2 && k > 0; j++) {
                if (nums1[i] + nums2[j] < target) {
                    List<Integer> t = new ArrayList<>();
                    t.add(nums1[i]);
                    t.add(nums2[j]);
                    re.add(t);
                    k--;
                } else {
                    break;
                }
            }
        }
        //再利用二分查找找相等的值
        for (int i = 0; i < len1 && k > 0; i++) {
            int a = nums1[i], b = target - a;
            int begin = 0, end = len2 - 1;
            int boundaryX, boundaryY;
            //找左界限
            while (begin < end) {
                int mid = (int) (0L + begin + end) >> 1;
                if (nums2[mid] < b) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (nums2[begin] != b) {
                continue;
            }
            boundaryX = begin;
            end = len2 - 1;
            //找右界限
            while (begin < end) {
                int mid = (int) (0L + begin + end + 1) >> 1;
                if (nums2[mid] > b) {
                    end = mid - 1;
                } else {
                    begin = mid;
                }
            }
            boundaryY = begin;
            for (int p = boundaryX; p <= boundaryY && k > 0; k--, p++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                temp.add(b);
                re.add(temp);
            }
        }
        return re;
    }

    public void test() {
        int[] nums1 = new int[]{1, 7, 11};
        int[] nums2 = new int[]{2, 4, 6};
        List<List<Integer>> lists = kSmall(nums1, nums2, 3);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new KSmallestPairs().test();
    }

}
