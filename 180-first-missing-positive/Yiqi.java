public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)
            return 1;
        for (int i = 0; i < nums.length; i++) {
            //use counting sort: move positive numbers to the position where
            //index equals to the number. nums[nums[i]] != nums[i] is used to
            //avoid infinite loop
            if (nums[i] > 0 && nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
                //do same operation on the number swapped back again in next iteration
                i--;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        //since 1 ... nums.length-1 exists in array, test nums.length exist or not
        return nums[0] == nums.length ? nums.length+1 : nums.length;
    }
}