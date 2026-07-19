class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]); // fix: no `int` here
            high += nums[i];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int parts = countSubarrays(nums, mid);
            if (parts > k) {
                low = mid + 1; // need larger max sum
            } else {
                high = mid - 1; // try smaller max sum
            }
        }

        return low;
    }

    private int countSubarrays(int[] nums, int limit) {
        int count = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num <= limit) {
                sum += num;
            } else {
                count++;
                sum = num;
            }
        }

        return count;
    }
}
