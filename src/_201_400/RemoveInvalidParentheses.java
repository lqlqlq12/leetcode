package _201_400;

import org.junit.Test;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

//301.删除无效括号
/*给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。

返回所有可能的结果。答案可以按 任意顺序 返回。*/
//思路:第一次出现不匹配的地方是因为 '('的数目left < ')'的数目right 此时 往前找 找到')'的地方 然后删除
//用回溯
//()()(((
//(()()
//)()((
//()())

//()(
//()(
//)()
//()
//关于left>right的情况 思路是 '('->')' 然后reverse 放弃了
//官解:先统计需要删除多少个(和多少个) 然后回溯删除
public class RemoveInvalidParentheses {
    List<String> re;

    public List<String> removeInvalidParentheses(String s) {
        re = new ArrayList<>();
        backTrack(new StringBuilder(s), 0, '(', ')');
        return re;
    }

    public void backTrack(StringBuilder sb, int index, char l, char r) {
        if (index == sb.length()) {
            if (l == '(') {
                re.add(sb.toString());
            } else {
                re.add(sb.reverse().toString());
            }
            return;
        }
        int left = 0, right = 0;
        for (int i = index; i < sb.length(); i++) {
            if (sb.charAt(i) == l) {
                left++;
            } else if (sb.charAt(i) == r) {
                right++;
            }
            if (right > left) {
                //删除[0:i]的')'
                for (int j = 0; j < i; j++) {
                    if (sb.charAt(j) != r) continue;
                    if (j != i - 1 & sb.charAt(j) == sb.charAt(j + 1)) continue;
                    backTrack(new StringBuilder(sb).deleteCharAt(j), i, l, r);
                }
                int k = i + 1;
                StringBuilder t = new StringBuilder();
                while (k < sb.length() && (sb.charAt(k) == sb.charAt(i) || sb.charAt(k) != l)) {
                    if (sb.charAt(k) != sb.charAt(i) && sb.charAt(k) != l) {
                        t.append(sb.charAt(k));
                    }
                    k++;
                }
                backTrack(new StringBuilder(sb).replace(i, k, t.toString()), i + t.length(), l, r);
                return;
            }
        }
        if (left == right) {
            if (l == '(') {
                re.add(sb.toString());
            } else {
                re.add(sb.reverse().toString());
            }
        } else {
            //left>right
            backTrack(sb.reverse(), 0, r, l);
        }
    }

    public List<String> optimize(String s) {
        re = new ArrayList<>();
        int lRemain = 0, rRemain = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lRemain++;
            } else if (c == ')') {
                if (lRemain == 0) {
                    rRemain++;
                } else {
                    lRemain--;
                }
            }
        }
        backTrack(new StringBuilder(s), 0, lRemain, rRemain);
        return re;
    }

    public void backTrack(StringBuilder s, int index, int left, int right) {
        if (left == 0 && right == 0) {
            if (isValid(s.toString())) {
                re.add(s.toString());
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) continue;
            if (left + right > s.length() - i) return;
            if (left > 0 && s.charAt(i) == '(') {
                backTrack(new StringBuilder(s).deleteCharAt(i), i, left - 1, right);
            }
            if (right > 0 && s.charAt(i) == ')') {
                backTrack(new StringBuilder(s).deleteCharAt(i), i, left, right - 1);
            }
        }
    }

    public boolean isValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            }
            if (left < right) return false;
        }
        return left == right;
    }

    @Test
    public void test() {
        //(r)()
        List<String> list = removeInvalidParentheses("()())r)");
        //)()())r)
        for (String s : list) {
            System.out.println(s);
        }
    }
}
