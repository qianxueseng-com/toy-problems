public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        if(nums.length == 0)
            return res;
        //initialization: add first number set and add set into result. Use lastAddSetNum to
        //represents how many sets has been added into res in last iteration
        List<Integer> set = new ArrayList<>();
        set.add(nums[0]);
        res.add(set);
        int lastAddSetNum = 1;
        //the idea to generate subsets[i] is that if nums[i] != nums[i-1], we can extract each
        //set in subset[i-1] and add nums[i] into the set and add the set back to result.
        //if nums[i] == nums[i-1], we do not extract every set in subset[i-1] to generate subset[i].
        //since in that way there must be duplicatition. The only sets we should use in subset[i-1]
        //to generate subset[i] is the lastest set which contains element nums[i-1]
        for(int i = 1; i < nums.length; i++) {
            int begin = nums[i] == nums[i-1] ? res.size()-lastAddSetNum : 0;
            int end = res.size();
            lastAddSetNum = 0;
            for(int j = begin; j < end; j++) {
                set = new ArrayList<>(res.get(j));
                set.add(nums[i]);
                res.add(set);
                lastAddSetNum++;
            }
        }
        return res;
    }
}