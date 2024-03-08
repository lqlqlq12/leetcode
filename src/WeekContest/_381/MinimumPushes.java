package WeekContest._381;

import java.util.Arrays;

//100191. 输入单词需要的最少按键次数 I
/*给你一个字符串 word，由 不同 小写英文字母组成。

电话键盘上的按键与 不同 小写英文字母集合相映射，可以通过按压按键来组成单词。例如，按键 2 对应 ["a","b","c"]，我们需要按一次键来输入 "a"，按两次键来输入 "b"，按三次键来输入 "c"。

现在允许你将编号为 2 到 9 的按键重新映射到 不同 字母集合。每个按键可以映射到 任意数量 的字母，但每个字母 必须 恰好 映射到 一个 按键上。你需要找到输入字符串 word 所需的 最少 按键次数。

返回重新映射按键后输入 word 所需的 最少 按键次数。

下面给出了一种电话键盘上字母到按键的映射作为示例。注意 1，*，# 和 0 不 对应任何字母。*/
//思路:参考哈夫曼树的思想
public class MinimumPushes {
    public int minimumPushes(String word) {
        int[] times = new int[26];
        int re = 0;
        for (char c : word.toCharArray()) {
            times[c - 'a']++;
        }
        Arrays.sort(times);
        for (int i = 1; i <= 8; i++) {
            re += times[26 - i];
        }
        for (int i = 9; i <= 16; i++) {
            re += (2 * times[26 - i]);
        }
        for (int i = 17; i <= 24; i++) {
            re += (3 * times[26 - i]);
        }
        for (int i = 25; i <= 26; i++) {
            re += (4 * times[26 - i]);
        }
        return re;
    }
}
