/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    var res = [];
    if(nums.length < 3)
        return res;
    nums.sort(function(val1, val2) {
        return val1-val2;
    });
    var items = [];
    for(var i = 0; i < nums.length-2; i++) {
        if(i !== 0 && nums[i] === nums[i-1])
            continue;
        items.push(nums[i]);
        twoSum(res, items, nums, i+1, 0-nums[i]);
        items.pop();
    }
    return res;
};

function twoSum(res, items, nums, start, target) {
    var left = start, right = nums.length-1;
    while(left < right) {
        if(nums[left] + nums[right] === target) {
            //backtracking: add 4 nums into res and store the 'items' for next search
            items.push(nums[left]);
            items.push(nums[right]);
            var tmpItems = [];
            tmpItems.push.apply(tmpItems, items);
            res.push(tmpItems);
            items.pop();
            items.pop();
            left++;
            //remove duplicate
            while(left < right && nums[left] === nums[left-1])
                left++;
        }
        else if(nums[left] + nums[right] < target) 
            left++;
        else 
            right--;
    }
}