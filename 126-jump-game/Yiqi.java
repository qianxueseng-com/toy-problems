public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0)
            return false;
        int max = nums[0];
        for(int i = 0; i <= max; i++) {
            if(i >= nums.length - 1)
                return true;
            max = Math.max(max, i+nums[i]);
        }
        return false;
    }
}