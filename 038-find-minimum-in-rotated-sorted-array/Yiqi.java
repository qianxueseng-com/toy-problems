public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(left == right || nums[left] < nums[right])
                return nums[left];
            else if(nums[mid] >= nums[left] && nums[left] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return 0;
    }
}