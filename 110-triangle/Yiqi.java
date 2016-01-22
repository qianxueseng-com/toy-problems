public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        int[] res = new int[triangle.get(triangle.size()-1).size()];
        res[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> nums = triangle.get(i);
            res[nums.size()-1] = nums.get(nums.size()-1) + res[nums.size()-2];
            for(int j = nums.size()-2; j > 0; j--) {
                res[j] = Math.min(res[j], res[j-1]) + nums.get(j);
            }
            res[0] += nums.get(0);
        }
        int min = res[0];
        for(int i = 0; i < res.length; i++)
            min = Math.min(res[i], min);
        return min;
    }
}