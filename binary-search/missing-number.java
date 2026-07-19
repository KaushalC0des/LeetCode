class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;  // removed () - length is a field, not a method
        int expected = n * (n + 1) / 2;  // fixed parentheses and added missing )
        int actual = 0;  // fixed typo: inr -> int
        for(int i = 0; i < n; i++){
            actual = actual + nums[i];  // added missing semicolon
        }
        return expected - actual;  // added missing return statement
    }
}