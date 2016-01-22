public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int res = nums[0], min = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tmpMax = max*nums[i], tmpMin = min*nums[i];
            max = Math.max(tmpMax, tmpMin);
            max = Math.max(max, nums[i]);
            min = Math.min(tmpMax, tmpMin);
            min = Math.min(min, nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}