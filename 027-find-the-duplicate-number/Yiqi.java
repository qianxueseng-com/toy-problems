//floyd's cycle detecting algorithms: https://leetcode.com/discuss/69766/share-my-solution-o-n-time-o-1-space-12-ms
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;
        }
        int find = 0;
        while(true) {
            slow = nums[slow];
            find = nums[find];
            if(slow == find)
                break;
        }
        return slow;
    }
}