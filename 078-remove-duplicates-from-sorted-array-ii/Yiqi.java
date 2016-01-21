public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3)
            return nums.length;
        int idx = 1;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] == nums[idx]) {
                if(nums[i] == nums[idx-1])
                    continue;
                else
                    nums[++idx] = nums[i];
            }
            else
                nums[++idx] = nums[i];
        }
        return idx+1;
    }
}