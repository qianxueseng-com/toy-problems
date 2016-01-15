/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    var set = {};
    var res = false;
    nums.forEach(function(item, idx, array) {
        if(set.hasOwnProperty(item))
            res = true;
        else
            set[item] = true;
    });
    return res;
};