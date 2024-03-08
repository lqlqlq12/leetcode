package _201_400;

import java.util.Deque;
import java.util.LinkedList;

//316.去除重复字母
/*给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。

需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 s 由小写英文字母组成*/
//首先 如果是a 我肯定希望尽可能去掉后面的a 如果是z 我肯定希望尽可能去掉前面的z
//假设bbaabb 结果肯定是ab 去掉后面的a 保留第一个 对于b 理论上应该也是尽可能去掉后面的 保留前面的 因为b也很小
//但是因为前面已经有了一个a b应该尽可能去掉a前面的 没办法去掉另外说 比如 bbbaaa 就是ba
//那么思路大致如下:
//可以先遍历一遍 用hashMap或者26长度的数组 记录每个字母的出现次数 就可以得到最后结果的长度 用一个char
//然后从a开始 尽可能保留在前面的a 然后记录a的位置 然后处理b b也是进可能保留最前面的b 但是要注意尽量不去保留a前面的b
//然后对于c 也是一样 aabbcc aaccbb ccaabbc bbcaacc 尽量往前 但是最好不要超过a和b
//所以记录最大的被保留的下标
//不能这样做 太麻烦了
//官解:给定一个字符串s 将s去掉一个字符 使s的字典序最小 做法是 找到一个index 使得s[index]>s[index+1] 这个index尽可能小
//那我们就可以对s重复进行这个操作 维护一个单调栈 栈低到栈顶递增
//根据题意 s的每一种字符都要出现一次且不超过一次 所以如果元素已经在栈内 就不可以再入栈 而且如果栈顶元素是最后一个元素 就不可以出栈
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int[] number = new int[26];
        for (int i = 0; i < len; i++) {
            number[charArray[i] - 'a']++;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (stack.contains(charArray[i])) {
                number[charArray[i] - 'a']--;
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > charArray[i]) {
                if (number[stack.peek() - 'a'] == 1) {
                    break;
                }
                number[stack.pop() - 'a']--;
            }
            stack.push(charArray[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
