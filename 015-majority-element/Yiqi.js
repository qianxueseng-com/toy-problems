/**
 * @param {number[]} nums
 * @return {number}
 */

//boyer-moore majority algorithm: use o(1) space and o(n) time, source:
//http://gregable.com/2013/10/majority-vote-algorithm-find-majority.html

var majorityElement = function(nums) {
    var candidate = nums[0], count = 0;
    nums.forEach(function(item) {
        if(count === 0)
            candidate = item;
        if(candidate === item)
            count++;
        else 
            count--;
    })
    return candidate;
};