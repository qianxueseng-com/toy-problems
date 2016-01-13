/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    nums.sort(function arrSort(a,b){
        return a-b;
    });
    for(var i=0;i<nums.length;i++){
        if(nums[i]===nums[i+1]){
            return true;
        }
    }
    return false;
};
