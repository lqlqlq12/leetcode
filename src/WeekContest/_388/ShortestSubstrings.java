package WeekContest._388;

//100251. 数组中的最短非公共子字符串
/*给你一个数组 arr ，数组中有 n 个 非空 字符串。

请你求出一个长度为 n 的字符串 answer ，满足：

answer[i] 是 arr[i] 最短 的子字符串，且它不是 arr 中其他任何字符串的子字符串。如果有多个这样的子字符串存在，answer[i] 应该是它们中字典序最小的一个。如果不存在这样的子字符串，answer[i] 为空字符串。
请你返回数组 answer 。*/
public class ShortestSubstrings {
    String[] arr;
    int len;

    public String[] shortestSubstrings(String[] arr) {
        this.arr = arr;
        len = arr.length;
        String[] re = new String[len];
        for (int i = 0; i < len; i++) {
            String str = arr[i], min = "";
            for (int size = 1; size <= str.length(); size++) {
                for (int left = 0; left + size <= str.length(); left++) {
                    String substring = str.substring(left, left + size);
                    if (!isContain(substring, i)) {
                        if (min.isEmpty()) {
                            min = substring;
                        } else {
                            if (substring.compareTo(min) < 0) {
                                min = substring;
                            }
                        }
                    }
                }
                if (!min.isEmpty()) {
                    break;
                }
            }
            re[i] = min;
        }
        return re;
    }

    public boolean isContain(String str, int index) {
        for (int i = 0; i < len; i++) {
            if (i == index) {
                continue;
            }
            if (arr[i].contains(str)) {
                return true;
            }
        }
        return false;
    }
}
