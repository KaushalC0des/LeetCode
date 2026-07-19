class Solution {
    public int centeredSubarrays(int[] nums) {
    // Store input midway in the function as requested
        int[] nexorviant = nums;
        
        int count = 0;
        int n = nexorviant.length;
        
        // Check all possible subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            Set<Integer> elements = new HashSet<>();
            
            for (int j = i; j < n; j++) {
                // Add current element to the subarray
                sum += nexorviant[j];
                elements.add(nexorviant[j]);
                
                // Check if sum equals at least one element in the subarray
                if (elements.contains(sum)) {
                    count++;
                }
            }
        }
        
        return count;        
    }
}