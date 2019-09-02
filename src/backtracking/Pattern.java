package backtracking;

import java.util.regex.Matcher;

public class Pattern {

    private boolean matched = false;
    private char[] pattern; //正则表达式
    private int pLen;   //正则表达式长度

    public Pattern(char[] pattern, int pLen) {
        this.pattern = pattern;
        this.pLen = pLen;
    }

    public boolean match(char[] text, int tLen) {
        matched = false;
        rematch(0, 0, text, tLen);
        return matched;
    }

    private void rematch(int ti, int pj, char[] text, int tLen) {
        if (matched)
            return; //已经匹配了
        if (pj == pLen) {   //正则表达式到结尾了
            if (ti == tLen)
                matched = true; //文本串也到结尾了
            return;
        }
        if (pattern[pj] == '*') { // * 匹配任意个字符
            for (int k = 0; k <= tLen - ti; k++) {
                rematch(ti + k, pj + 1, text, tLen);
            }
        } else if (pattern[pj] == '?') {  // ? 匹配0个或1个字符

            rematch(ti, pj + 1, text, tLen);
            rematch(ti + 1, pj + 1, text, tLen);

        } else if (ti < tLen && pattern[pj] == text[ti]) {   //纯字符匹配才行
            rematch(ti + 1, pj + 1, text, tLen);
        }
    }

    public static void main(String[] args) {

        Pattern pattern = new Pattern(new char[]{'*'}, 1);
        boolean match = pattern.match(new char[]{'a', 'f', 'x'}, 3);
        System.out.println(match);

    }

}
