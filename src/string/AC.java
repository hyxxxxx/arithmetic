package string;

import java.util.LinkedList;
import java.util.Queue;

public class AC {

    private AcNode root = new AcNode('/');

    public static void main(String[] args) {

        AC ac = new AC();
        String str = "ohmygodyouaresuchafuckingshit";
        String fuck = "fuck";
        String shit = "shit";
        String god = "god";
        ac.insert(fuck.toCharArray());
        ac.insert(shit.toCharArray());
        ac.insert(god.toCharArray());
        ac.buildFailurePointer();
        char[] text = str.toCharArray();
        char[] match = ac.match(text);
        System.out.println(match);
    }


    static class AcNode {
        char data;
        AcNode[] children = new AcNode[26]; //字符集只包含 a-z 26个字符
        boolean isEndingChar = false;   //结尾字符为true
        int length = -1;    //当 isEndingChar = true 时，记录模式串长度
        AcNode fail;    //失败指针

        public AcNode(char data) {
            this.data = data;
        }
    }

    public void insert(char[] text) {
        AcNode p = root;
        int length = 0;
        for (char aText : text) {
            int index = aText - 'a';
            if (p.children[index] == null) {
                AcNode newNode = new AcNode(aText);
                p.children[index] = newNode;
            }
            p = p.children[index];
            length++;
        }
        p.isEndingChar = true;
        p.length = length;
    }

    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode pc = p.children[i];
                if (pc == null)
                    continue;
                if (pc == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    /**
     * @param text 主串
     */
    public char[] match(char[] text) {
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; ++i) {
            int index = text[i] - 'a';
            while (p.children[index] == null && p != root) {
                p = p.fail; //失败指针发挥作用的地方
            }
            p = p.children[index];
            if (p == null)
                p = root;   //如果没有匹配的，从root开始重新匹配
            AcNode tmp = p;
            while (tmp != root) {    //打印出可以匹配的模式串
                if (tmp.isEndingChar) {
                    int pos = i - tmp.length + 1;
                    for (int j = 0; j < tmp.length; ++j) {
                        text[pos + j] = '*';
                    }
                    System.out.println("匹配起始下标 " + pos + "; 长度 " + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
        return text;
    }

}
