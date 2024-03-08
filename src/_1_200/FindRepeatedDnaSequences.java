package _1_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//187.重复的DNA序列
/*DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。

例如，"ACGAATTCCG" 是一个 DNA序列 。
在研究 DNA 时，识别 DNA 中的重复序列非常有用。

给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。*/
//思路:用hashMap+滑动窗口
//优化思路:只有ACGT四种情况 所以可以用2位bit来表示四种字符 所以一个长度位10的字符串 就可以用20个bit来表示
//一个int有32个bit 所以可以用一个int来表示 然后又可以使用滑动窗口 发现还不如不优化 哈哈哈
public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> re = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        if (len <= 10) return re;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= len - 10; i++) {
            String target = s.substring(i, i + 10);
            map.put(target, map.getOrDefault(target, 0) + 1);
            if (map.get(target) == 2) {
                re.add(target);
            }
        }
        return re;
    }

    public List<String> optimize(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        List<String> re = new ArrayList<>();
        if (len <= 10) return re;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Character, Integer> reflect = new HashMap<>();
        reflect.put('A', 0);
        reflect.put('C', 1);
        reflect.put('G', 2);
        reflect.put('T', 3);
        int number = 0;
        for (int i = 0; i < 10; i++) {
            number = (number << 2) | reflect.get(charArray[i]);
        }
        map.put(number, 1);
        for (int i = 1; i <= len - 10; i++) {
            number = ((number << 2) | reflect.get(charArray[i + 9])) & ((1 << 20) - 1);
            map.put(number, map.getOrDefault(number, 0) + 1);
            if (map.get(number) == 2) {
                re.add(s.substring(i, i + 10));
            }
        }
        return re;
    }
}
