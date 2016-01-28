public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return 0;
        int left = 0, right = nums.length-1;
        while(left + 1 < right) {
            int mid = (left + right)/2;
            //since the way I write binary search will not touch first or
            //last element it is safe to test mid's neighbour element
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            //search left part
            else if(nums[mid-1] > nums[mid])
                right = mid;
            //search right part
            else 
                left = mid;
        }
        //Since it must contains peak element, it is either in left or right
        if(nums[left] > nums[right])
            return left;
        return right;
    }
}