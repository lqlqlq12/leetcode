package typical150.SlideWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//串联所有单词的子串
/*给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。

 s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。

例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。*/
//用滑动窗口,一开始的办法相当于暴力解法,没有用到窗口
//第二个方法才是真正的滑动窗口,但是因为是匹配单词,所以窗口每次的移动距离是一个单词的长度,所以有好几个窗口在那里
//滑动,理想情况下,应该有n-1个窗口,n是一个单词的大小
public class FindSubString {
    String[] words;
    String s;
    int wordSize;

    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length();
        int wLen = words.length;
        int wordSize = words[0].length();
        this.wordSize = wordSize;
        this.s = s;
        this.words = words;
        List<Integer> re = new ArrayList<>();
        for (int i = 0; i < sLen; i++) {
            int j = i + wLen * wordSize;
            if (j > sLen) {
                break;
            }
            if (recursion(i, j, new boolean[wLen])) {
                re.add(i);
            }
        }
        return re;
    }

    public boolean recursion(int begin, int end, boolean[] used) {
        if (begin == end) {
            return true;
        }
        if (begin + wordSize > end) {
            return false;
        }
        String word = s.substring(begin, begin + wordSize);
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && word.equals(words[i])) {
                used[i] = true;
                return recursion(begin + wordSize, end, used);
            }
        }
        return false;
    }

    public void test() {
        String s = "ababababab";
        String[] words = new String[]{"ababa", "babab"};
        List<Integer> substring = findS(s, words);
        for (Integer i : substring) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new FindSubString().test();
    }

    public List<Integer> findS(String s, String[] words) {
        int wordSize = words[0].length();
        int windowSize = words.length * wordSize;
        List<Integer> re = new ArrayList<>();
        if (s.length() < windowSize) {
            return re;
        }
        Map<String, Integer> target = new HashMap<>();
        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordSize && i + windowSize <= s.length(); i++) {
            //先初始化窗口
            Map<String, Integer> now = new HashMap<>();
            int valid = 0;
            for (int j = 1; j <= words.length; j++) {
                String word = s.substring(i + (j - 1) * wordSize, i + j * wordSize);
                int contain = now.getOrDefault(word, 0);
                int need = target.getOrDefault(word, 0);
                if (contain + 1 == need) {
                    valid++;
                } else if (need != 0 && contain == need) {
                    valid--;
                }
                if (need != 0) {
                    now.put(word, contain + 1);
                }
            }
            if (valid == target.size()) {
                re.add(i);
            }
            //开始移动窗口,窗口每次移动一个单词的距离
            for (int left = i; left + windowSize + wordSize <= s.length(); left += wordSize) {

                String wordLeft = s.substring(left, left + wordSize);
                int right = left + windowSize;
                String wordRight = s.substring(right, right + wordSize);
                int leftNeed = target.getOrDefault(wordLeft, 0);
                int rightNeed = target.getOrDefault(wordRight, 0);
                //移除左边单词
                if (leftNeed != 0) {
                    int contain = now.get(wordLeft);
                    if (contain - 1 == leftNeed) {
                        valid++;
                    } else if (contain == leftNeed) {
                        valid--;
                    }
                    now.put(wordLeft, contain - 1);
                }
                //增加右边单词
                if (rightNeed != 0) {
                    int contain = now.getOrDefault(wordRight, 0);
                    if (contain + 1 == rightNeed) {
                        valid++;
                    } else if (contain == rightNeed) {
                        valid--;
                    }
                    now.put(wordRight, contain + 1);
                }
                if (valid == target.size()) {
                    re.add(left + wordSize);
                }
            }
        }
        return re;
    }
}
