public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, items, candidates, 0, target);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> items, int[] candidates, int start, int target) {
        //base case
        if(target == 0) {
            res.add(new ArrayList<Integer>(items));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] > target)
                return;
            items.add(candidates[i]);
            helper(res, items, candidates, i, target-candidates[i]);
            items.remove(items.size()-1);
        }
    }
}