class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] < nums[mid+1]){
                low = mid+1; // increasing part of the mountain
            } else {
                high = mid; // decreasing part of the mountain
            }
        }
        return low;
        
    }
}