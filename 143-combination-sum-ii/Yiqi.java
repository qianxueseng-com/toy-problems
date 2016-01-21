public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, items, candidates, 0, target);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> items, int[] candidates, int start, int target) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(items));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(i != start && candidates[i] == candidates[i-1])
                continue;
            if(candidates[i] > target)
                return;
            items.add(candidates[i]);
            helper(res, items, candidates, i+1, target-candidates[i]);
            items.remove(items.size()-1);
        }        
    }
}