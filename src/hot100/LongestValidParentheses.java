package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

//最长有效括号
/*给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度*/
//s[i] 为 '(' 或 ')'
//滑动窗口 3ms 有点垃圾
//动规 O(n)
//dp[i] 以i结尾的最长的有效的 只有')'才能结尾
// s[i-1]=='(' -> dp[i]=dp[i-1]+2
// s[i-1]==')'&&s[i-dp[i-1]-1]=='('->dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]
//栈方法,左括号入栈,右括号匹配出栈,用栈顶的左括号和当前右括号算有效距离 O(n)
//比较左右括号个数 O(n),不需要额外空间 但是要遍历两次 非常好理解
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int re = 0;
        for (int l = 0; l < len - 1; ) {
            if (charArray[l] == ')') {
                l++;
                continue;
            }
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(l);
            int r = l + 1;
            for (; r < len; r++) {
                if (charArray[r] == '(') {
                    stack.push(r);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        if (stack.isEmpty()) {
                            int size = r - l + 1;
                            re = Math.max(re, size);
                        }
                    } else {
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                int size = r - l;
                re = Math.max(re, size);
                l = r + 1;
            } else {
                if (stack.size() == 1) {
                    int t = stack.pop();
                    if (t == l) {
                        re = Math.max(re, r - l - 1);
                        return re;
                    } else {
                        l = t + 1;
                    }
                } else {
                    int before = len;
                    while (!stack.isEmpty()) {
                        int last = stack.pop();
                        re = Math.max(re, before - last - 1);
                        before = last;
                    }
                    return re;
                }
            }
        }
        return re;
    }

    public int dynamicProgramming(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int re = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (charArray[i] == '(') {
                continue;
            }
            if (charArray[i - 1] == '(') {
                dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
            } else {
                if (i - dp[i - 1] - 1 >= 0 && charArray[i - dp[i - 1] - 1] == '(') {
                    dp[i] += (2 + dp[i - 1]);
                    int t = i - dp[i - 1] - 2;
                    if (t >= 0) {
                        dp[i] += dp[t];
                    }
                }
            }
            re = Math.max(re, dp[i]);
        }
        return re;
    }


    public int stackMethod(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int re = 0;
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                int l = stack.peek();
                re = Math.max(re, i - l);
            }
        }
        return re;
    }

    public int func(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int re = 0;
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                left++;
            } else {
                right++;
                if (right == left) {
                    re = Math.max(re, left + right);
                } else if (right > left) {
                    right = 0;
                    left = 0;
                }
            }
        }
        left = 0;
        right = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (charArray[i] == ')') {
                right++;
            } else {
                left++;
                if (left == right) {
                    re = Math.max(re, left + right);
                } else if (left > right) {
                    left = 0;
                    right = 0;
                }
            }
        }
        return re;
    }

}
