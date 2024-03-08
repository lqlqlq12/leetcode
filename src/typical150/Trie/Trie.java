package typical150.Trie;

//208.实现前缀树(Trie)
/*Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。*/
//思路 一个节点代表一个字母 节点中有一个节点数组
//一遍过 直接秒了
public class Trie {
    boolean isEnd;
    Trie[] child;

    public Trie() {
        isEnd = false;
        child = new Trie[26];
    }

    public void insert(String word) {
        Trie node = this;
        char[] charArray = word.toCharArray();
        int index = 0, len = charArray.length;
        while (index < len && node.child[charArray[index] - 'a'] != null) {
            node = node.child[charArray[index] - 'a'];
            index++;
        }
        while (index < len) {
            node.child[charArray[index] - 'a'] = new Trie();
            node = node.child[charArray[index] - 'a'];
            index++;
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        int index = 0, len = charArray.length;
        Trie node = this;
        while (index < len && node.child[charArray[index] - 'a'] != null) {
            node = node.child[charArray[index] - 'a'];
            index++;
        }
        return index == len && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        int index = 0, len = charArray.length;
        Trie node = this;
        while (index < len && node.child[charArray[index] - 'a'] != null) {
            node = node.child[charArray[index] - 'a'];
            index++;
        }
        return index == len;
    }
}
