package _201_400;

//387.字符串中的第一个唯一字符
/*给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。*/
//重拳出击 Map 数组实现的
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int len = s.length();
        int[] arr = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            arr[charArray[i] - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (arr[charArray[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
