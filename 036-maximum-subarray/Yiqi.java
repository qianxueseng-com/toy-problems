public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int tmp = 0, res = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(tmp <= 0)
                tmp = nums[i];
            else
                tmp += nums[i];
            res = Math.max(res, tmp);
        }
        return res;
    }
}