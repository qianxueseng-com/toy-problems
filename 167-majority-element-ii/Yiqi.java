//source: https://leetcode.com/discuss/43248/boyer-moore-majority-vote-algorithm-and-my-elaboration
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //initial condition must be satisfied
        if(nums.length == 0) 
            return res;
        //initial condition, note candidate1 and candidate2 must be different numbers
        //they do not have to be numbers in nums array, as long as you set count1 and
        //count2 = 0
        int candidate1 = 0, candidate2 = 1, count1 = 0, count2 = 0;
        for(int iter: nums) {
            if(iter == candidate1) 
                count1++;
            else if(iter == candidate2)
                count2++;
            else if(count1 == 0) {
                candidate1 = iter;
                count1 = 1;
            }
            else if(count2 == 0) {
                candidate2 = iter;
                count2 = 1;
            }
            else {
                count1--; count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int iter: nums) {
            if(iter == candidate1)
                count1++;
            else if(iter == candidate2)
                count2++;
        }
        if(count1 > nums.length/3)
            res.add(candidate1);
        if(count2 > nums.length/3)
            res.add(candidate2);
        return res;
    }
}