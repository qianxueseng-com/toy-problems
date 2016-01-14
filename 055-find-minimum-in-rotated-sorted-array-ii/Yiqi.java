public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0)
            return -1;
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = (left + right)/2;
            //base case 1: there is only one number
            if(left == right)
                return nums[left];
            //base case 2: array is ascending order
            else if(nums[left] < nums[right])
                return nums[left];
            //base case 3: there are only two numbers
            //and nums[right] <= nums[left]
            else if(left == right - 1)
                return nums[right];
            //normal binary search: right part
            else if(nums[mid] >= nums[left] && nums[left] > nums[right])
                left = mid+1;
            //normal binary search: left part
            else if(nums[mid] <= nums[right] && nums[left] > nums[right])
                right = mid;
            //special case: nums[mid] == nums[left] == nums[right]
            else 
                left++;
        }
        return -1;
    }
}