/**
 * @param {number[]} nums
 * @return {number}
 */
 /**
 * @param {number[]} nums
 * @return {number}
 */
 //排序，比较相邻项
var singleNumber = function(nums) {
  nums.sort(function sortNums(a,b){
      return a-b;
  });
  for(var i=0,len=nums.length;i<len;i+=2){
      if(nums[i]!==nums[i+1]){
          return nums[i];
      }
  }
};
 //位运算
var singleNumber = function(nums) {
   var num;
   for(var i=0;i<nums.length;i++){
       num=num^nums[i];
   }
   return num;
};
