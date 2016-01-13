public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        if(nums == null || nums.length == 0)
            return false;
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;
        }
        return false;
    }
}