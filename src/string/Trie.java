package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 专门处理字符串匹配的数据结构，
 * 用来解决在一组字符串集合中快速查找某个字符串的问题
 */
public class Trie {

    private TrieNode root = new TrieNode('/');

    public static void main(String[] args) {

        Trie trie = new Trie();
        List<String> list = Arrays.asList("how", "who", "hi", "her", "hello");
        for (String s : list) {
            trie.insert(s.toCharArray());
        }
        String str = "who";
        boolean b = trie.find(str.toCharArray());
        System.out.println(b);

    }

    class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26]; //假设存储的字符串只有从 a-z 26个小写字母
        boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }

    /**
     * 我们在数组中下标为0的位置，
     * 存储指向子节点a的指针，
     * 下标为1的位置指向子节点b的指针，
     * 以此类推
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (char aText : text) {
            int index = aText - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(aText);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 查找字符串时，
     * 我们通过字符串的ASCII码减去字符a的ASCII码，
     * 可以迅速找到匹配的子节点的指针
     */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (char aPattern : pattern) {
            int index = aPattern - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }

}
