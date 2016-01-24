//hashmap solution: use o(n) space and o(n) time
public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
            int val = num[i];
            if(countMap.containsKey(val)) 
                countMap.put(val, countMap.get(val) + 1);
            else 
                countMap.put(val, 1);
        }
        int res = 0;
        for(Integer keyIter: countMap.keySet()) {
            if(countMap.get(keyIter) > num.length/2)
                res = keyIter;
        }
        return res;
    }
}

//boyer-moore majority algorithm: use o(1) space and o(n) time, source:
//http://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0)
            return 0;
        int candidate = nums[0], count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                candidate = nums[i];
            }
            if(candidate == nums[i])
                count++;
            else 
                count--;
        }
        return candidate;
    }
}