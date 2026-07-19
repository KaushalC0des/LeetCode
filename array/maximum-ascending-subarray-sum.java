class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // Continue the ascending subarray
                currentSum += nums[i];
            } else {
                // Start a new ascending subarray
                currentSum = nums[i];
            }
            
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}