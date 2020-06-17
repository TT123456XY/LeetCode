package com.xywyx.isMatch;

import java.util.Arrays;

/**
 *给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * s和p必须全量比上。不能是s的部分或者是p的部分
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class Match {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean is = s.isMatch("aab","c*aab");
        System.out.println(is);
    }
}
class Solution {
    boolean [] [] memo;
    public boolean isMatch(String s, String p) {
        memo = new boolean [s.length() + 1][p.length() + 1];
        boolean dp = dp(0, 0, s, p);
//        for (int i = 0; i < s.length() + 1; i++) {
//            System.out.println(Arrays.toString(memo[i]));
//        }
        return dp;
    }
    public boolean dp(int i, int j, String text, String pattern) {
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            //是否第i位的s，和第j位的p可以对上
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));
            //如果j还没到p的倒数第二位，且下一位是*
            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                //第一部分相当于把*当成0个。直接跳过p的前两个字符
                //第二部分就是把*当成1个，如果可以匹配上，在把s的下一个和p这个比较。因为p的下一个是*，相当于前一个字符
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
                //如果下一个字符不是*，那这个字符必须能匹配上，同时比较后面的
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ;
        return ans;
    }
}
