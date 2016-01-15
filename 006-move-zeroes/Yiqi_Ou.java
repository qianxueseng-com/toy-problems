public class Solution {
    public void moveZeroes(int[] nums) {
        //let idx represents the number of non-zero values we found. Each time we find new 
    	//non-zero value, just put the value to that position
    	int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        //change all the value after idx to zero
        for(int i = idx; i < nums.length; i++) 
            nums[i] = 0;
    }
}