//the idea is consider it as a graph problem. Find consecutive sequence is equivalent
//to bfs all nodes in this graph. This algorighm run o(n) time.
//source: http://codeganker.blogspot.com/2014/04/longest-consecutive-sequence-leetcode.html
public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int i : nums) {
            set.add(i);
        }
        for(int i : nums) {
            res = Math.max(res, bfs(i, set));
        }
        return res;
    }
    
    public int bfs(int start, HashSet<Integer> set) {
        if (!set.contains(start))
            return 0;
        int res = 1;
        int nei = start + 1;
        while (set.contains(nei)) {
            set.remove(nei);
            nei++;
            res++;
        }
        nei = start-1;
        while (set.contains(nei)) {
            set.remove(nei);
            nei--;
            res++;
        }
        return res;
    }
}