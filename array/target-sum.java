class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return calculateWays(nums, 0, 0, target);
    }

    private int calculateWays(int[] nums, int index, int currentSum, int target) {
        
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        
        int add = calculateWays(nums, index + 1, currentSum + nums[index], target);

        
        int subtract = calculateWays(nums, index + 1, currentSum - nums[index], target);

        return add + subtract;
    }
}