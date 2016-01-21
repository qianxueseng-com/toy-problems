public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3)
            return -1;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int diff = twoSum(nums, i+1, target-nums[i]);
            if(Math.abs(diff) < Math.abs(minDiff))
                minDiff = diff;
        }
        return target-minDiff;
    }
    
    public int twoSum(int[] nums, int start, int target) {
        int left = start, right = nums.length-1, minDiff = Integer.MAX_VALUE;
        while(left < right) {
            int diff = target-nums[left]-nums[right];
            if(Math.abs(diff) < Math.abs(minDiff))
                minDiff = diff;
            if(diff == 0)
                return 0;
            else if(diff > 0)
                left++;
            else
                right--;
        }
        return minDiff;
    }
}