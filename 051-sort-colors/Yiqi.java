public class Solution {
    //counting sort
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i: nums) {
            count[i]++;
        }
        int oldCount = 0, total = 0;
        for(int i = 0; i < count.length; i++) {
            oldCount = count[i];
            count[i] = total;
            total += oldCount;
        }
        int[] aux = new int[nums.length];
        for(int i : nums) {
            aux[count[i]++] = i;
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = aux[i];
        }
    }
}

//follow up: use o(1) space and single pass
//the idea is that use three pointers: left, p, right. all nums before left are 0.
//all nums after right are 2. use p to scan through array, if we find 0, swap with left
//pointer. If we find 2, swap with right pointer
public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 0)
            return;
        int p = 0, l = 0, r = nums.length-1;
        //note if p == r, we should not stop, since it is possible the value swapped back is 
        //0, we need another iteration to swap it with left pointer
        while(p <= r) {
            if(nums[p] == 0 && p >= l) {
                int tmp = nums[l];
                nums[l] = nums[p];
                nums[p] = tmp;
                l++;
                if(nums[p] != 1)
                    continue;
            } else if(nums[p] == 2) {
                int tmp = nums[r];
                nums[r] = nums[p];
                nums[p] = tmp;
                r--;
                if(nums[p] != 1)
                    continue;
            }
            p++;
        }
    }
}