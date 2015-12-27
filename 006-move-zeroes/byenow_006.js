/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    if(nums.length!==0){
        //i用于遍历数组，index用于定位
        for(var i=0,index=0,len=nums.length;i<len;i++,index++){
            if(nums[index]===0){
                nums.splice(index,1);
                nums.push(0);
                //splice使数组发生了改变，index前移一位
                index--;
            }
        }
    }
};
