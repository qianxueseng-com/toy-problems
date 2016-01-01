/**
 * File name should be Solution.java
 * To differ from others' solution files, rename to yourusername.java
 */

public class Solution {
  public int singleNumber(int[] nums) {
    int result = 0;
    for(int i : nums) {
      result ^= i;
    }
    return result;
  }
}
