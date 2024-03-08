package typical150.Interval;

import java.util.ArrayList;
import java.util.List;

//汇总区间
/*给定一个  无重复元素 的 有序 整数数组 nums 升序。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b*/
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        int left, right;
        List<String> re = new ArrayList<>();
        for (left = 0, right = 1; right <= len; right++) {
            if (right == len || nums[right] - 1 != nums[right - 1]) {
                StringBuilder sb = new StringBuilder();
                if (left == right - 1) {
                    sb.append(nums[left]);
                    re.add(sb.toString());
                } else {
                    sb.append(nums[left]).append("->").append(nums[right - 1]);
                    re.add(sb.toString());
                }
                left = right;
            }
        }
        return re;
    }
}
