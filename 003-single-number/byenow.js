/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
   var num;
   for(var i=0;i<nums.length;i++){
       num=num^nums[i];
   }
   return num;
};
