package com.xywyx.isPalindrome;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 */
public class Palindrome {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean is = s.isPalindrome(-121);
        System.out.println(is);
    }

}
class Solution {
    boolean isPalindrome(int x) {
            String xStr = String.valueOf(x);
            for (int i = 0; i < xStr.length()/2; i++){
                if (xStr.charAt(i) != xStr.charAt(xStr.length() - 1 - i)){
                    return false;
                }
            }
        return true;
    }
}