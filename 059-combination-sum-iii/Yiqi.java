public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        helper(res, items, k, 1, n);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> items, int k, int start, int target) {
        if(k == 0 && target == 0) {
            res.add(new ArrayList<Integer>(items));
            return;
        }
        else if(k == 0)
            return;
        for(int i = start; i <= 9; i++) {
            if(i > target)
                return;
            items.add(i);
            helper(res, items, k-1, i+1, target-i);
            items.remove(items.size()-1);
        }
    }
}