/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    if(nums.length === 0)
        return -1;
    var left = 0, right = nums.length-1;
    while(left <= right) {
        var mid = Math.floor((left + right) / 2);
        //base case 1: the nums is ascending order
        if(nums[left] < nums[right])
            return nums[left];
        //base case 2: one numbers left
        else if(left === right)
            return nums[left];
        //base case 3: two numbers left, since there is base case 1
        //the nums[right] must be less than nums[left]
        else if(left === right - 1)
            return nums[right];
        //normally binary search: right part
        else if(nums[mid] > nums[left])
            left = mid + 1;
        //if(nums[mid] < nums[right]): left part
        else 
            right = mid;
    }
    //do not return anything
};