public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int size = res.size();
            for(int j = 0; j < size; j++) {
                List<Integer> iter = res.get(j);
                List<Integer> set = new ArrayList<>(iter);
                set.add(nums[i]);
                res.add(set);
            }
        }
        return res;
    }
}