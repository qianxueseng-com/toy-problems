public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3)
            return res;
        Arrays.sort(nums);
        List<Integer> items = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            //remove duplicate
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            //backtracking: begin search
            items.add(nums[i]);
            twoSum(res, items, nums, i+1, 0-nums[i]);
            items.remove(0);
        }
        return res;
    }
    
    public void twoSum(List<List<Integer>> res, List<Integer> items, int[] nums, int start, int target) {
        int left = start, right = nums.length-1;
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                //backtracking: add 4 numbers into result and restore items to search the next
                items.add(nums[left]);
                items.add(nums[right]);
                res.add(new ArrayList<Integer>(items));
                items.remove(2);
                items.remove(1);
                //remove duplicate
                left++;
                while(left < right && nums[left] == nums[left-1])
                    left++;
            }
            else if(nums[left] + nums[right] < target)
                left++;
            else
                right--;
        }
    }
}