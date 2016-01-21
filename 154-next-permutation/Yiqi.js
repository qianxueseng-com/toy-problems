/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    //initial condition
    if(nums.length < 2)
        return;
    //find the first decreasedPos from left side
    var decreasedPos = nums.length-2;
    while(decreasedPos >= 0 && nums[decreasedPos] >= nums[decreasedPos+1])
        decreasedPos--;
    if(decreasedPos == -1) {
        reverse(nums, 0, nums.length-1);
        return;
    }
    //find the first number which is a little bit larger than number at
    //decreasedPos from right side
    var largerPos = nums.length-1;
    while(largerPos > decreasedPos+1 && nums[largerPos] <= nums[decreasedPos])
        largerPos--;
    swap(nums, decreasedPos, largerPos);
    reverse(nums, decreasedPos+1, nums.length-1);
};

function reverse(nums, begin, end) {
    for(var i = 0; i <= (end-begin) / 2; i++) {
        var tmp = nums[begin+i];
        nums[begin+i] = nums[end-i];
        nums[end-i] = tmp;
    }
}

function swap(nums, i, j) {
    var tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}