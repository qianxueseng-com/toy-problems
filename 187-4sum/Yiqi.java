public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4)
            return res;
        ArrayList<Integer> items = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++) {
            //remove duplicate
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            items.add(nums[i]);
            threeSum(res, nums, items, i+1, target-nums[i]);
            items.remove(0);           
        }
        return res;
    }
    
    public void threeSum(List<List<Integer>> res, int[] nums, ArrayList<Integer> items, int start, int target) {
        for(int i = start; i < nums.length-2; i++) {
            //remove duplicate
            if(i != start && nums[i] == nums[i-1])
                continue;
            items.add(nums[i]);
            twoSum(res, nums, items, i+1, target-nums[i]);
            items.remove(1);
        }
    }
    
    public void twoSum(List<List<Integer>> res, int[] nums, ArrayList<Integer> items, int start, int target) {
        int left = start, right = nums.length-1;
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                items.add(nums[left]);
                items.add(nums[right]);
                res.add(new ArrayList(items));
                items.remove(3);
                items.remove(2);
                left++;
                while(left < right && nums[left] == nums[left-1])
                    left++;
            }
            else if(nums[left] + nums[right] > target)
                right--;
            else
                left++;
        }
    }
}