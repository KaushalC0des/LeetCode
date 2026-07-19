class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0; // Position to place next non-zero element
        
        // Move all non-zeros to the front
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp=nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        
        // Fill remaining positions with zeros
        // while (i < nums.length) {
        //     nums[i] = 0;
        //     i++;
        // }
    }
}