package _201_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//385.迷你语法分析器
/*给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。

列表中的每个元素只可能是整数或整数嵌套列表*/
public class Deserialize {
    class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return new ArrayList<>();
        }
    }


    public NestedInteger deserialize(String s) {
        NestedInteger ans = new NestedInteger();
        if (!s.contains("[")) {
            ans.setInteger(Integer.parseInt(s));
            return ans;
        }
        int count = 0, len = s.length(), start = 1;
        for (int i = 1; i < len; i++) {
            if (count == 0 && s.charAt(i) == ',') {
                if (start != i) ans.add(deserialize(s.substring(start, i)));
                start = i + 1;
            }
            if (s.charAt(i) == '[') {
                count++;
            } else if (s.charAt(i) == ']') {
                count--;
            }
        }
        if (start != len && start != len - 1) {
            ans.add(deserialize(s.substring(start, len - 1)));
        }
        return ans;
    }

    @Test
    public void test() {
        deserialize("[123,456,[788,799,833],[[]],10,[]]");
    }
}
