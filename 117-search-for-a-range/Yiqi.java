public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        //search left edge
        while(left < right - 1) {
            int mid = (left + right) / 2;
            if(nums[mid] >= target)
                right = mid;
            else 
                left = mid;
        }
        if(nums[left] == target)
            res[0] = left;
        else if(nums[right] == target)
            res[0] = right;
        left = 0;
        right = nums.length-1;
        //search right edge
        while(left < right - 1) {
            int mid = (left + right)/2;
            if(nums[mid] <= target)
                left = mid;
            else
                right = mid;
        }
        if(nums[right] == target)
            res[1] = right;
        else if(nums[left] == target)
            res[1] = left;
        return res;
    }
}