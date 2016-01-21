public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return;
        //iterate from right, find the first number that begins to
        //decrease
        int decreasedPos = nums.length-2;
        while(decreasedPos >= 0 && 
            nums[decreasedPos] >= nums[decreasedPos+1]) {
            decreasedPos--;
        }
        //if the nums are in desceding order
        if(decreasedPos == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        //reorder the number from decreasedPos to nums.length-1, to generate
        //next permutation
        int largerFirstNumPos = nums.length-1;
        //search from find the position where the number is just a little bit larger than 
        //number at decreasedPos.
        while(largerFirstNumPos > decreasedPos+1 && nums[largerFirstNumPos] <= nums[decreasedPos]) {
            largerFirstNumPos--;
        }
        swap(nums, largerFirstNumPos, decreasedPos);
        reverse(nums, decreasedPos+1, nums.length-1);
    }
    
    public void reverse(int[] nums, int begin, int end) {
        for(int i = 0; i <= (end-begin)/2; i++) {
            int tmp = nums[begin+i];
            nums[begin+i] = nums[end-i];
            nums[end-i] = tmp;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] =tmp;
    }
}