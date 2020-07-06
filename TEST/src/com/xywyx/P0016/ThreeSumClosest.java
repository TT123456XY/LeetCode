package src.com.xywyx.P0016;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.threeSumClosest(null ,0);
        System.out.println(res);
    }
}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1, k=n-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target){
                    return sum;
                }
                if (Math.abs(sum-target) < Math.abs(best - target)){
                    best = sum;
                }
                if (sum > target ){
                    int k0 = k -1;
                    while (j<k0&&nums[k0]==nums[k]){
                        --k0;
                    }
                    k=k0;
                }else {
                    int j0 = j +1 ;
                    while (j0<k&& nums[j0] == nums[j]){
                        ++j0;
                    }
                    j=j0;
                }
            }
        }
        return best;
    }
}