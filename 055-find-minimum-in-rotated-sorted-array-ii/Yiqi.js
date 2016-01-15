/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    var left = 0, right = nums.length - 1;
    while(left <= right) {
        var mid = Math.floor((left + right)/2);
        //base case 1: there is only one number left
        if(left === right)
            return nums[left];
        //base case 2: the number is ascending order
        else if(nums[left] < nums[right])
            return nums[left];
        //base case 3: there are two numbers left and 
        //nums[right] <= nums[left]
        else if(left === right-1)
            return nums[right];
        //normal binary search: left part
        else if(nums[mid] <= nums[right] && nums[left] > nums[right])
            right = mid;
        //normal binary search: right part
        else if(nums[mid] >= nums[left] && nums[left] > nums[right])
            left = mid + 1;
        //special case: nums[mid] === nums[left] === nums[right]
        else
            left++;
    }
};