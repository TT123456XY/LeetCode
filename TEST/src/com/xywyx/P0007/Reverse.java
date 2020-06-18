package com.xywyx.P0007;

/**
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 */
public class Reverse {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.reverse(123);
        System.out.println(result);
    }
}

class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0 ){
            int temp = x%10 + res*10;
            if ((temp - x%10)/10 != res) {
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return res;
    }
}