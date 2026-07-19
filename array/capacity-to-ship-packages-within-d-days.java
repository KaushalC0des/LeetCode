class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0; i<weights.length; i++){
            low = Math.max(low,weights[i]);
            high += weights[i];
        }
        while(low<=high){
            int mid =(low+high)/2;
            int numberDays = findDays(weights,mid);
            if(numberDays <= days){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
            
        return low;
    }
        public int findDays(int[] weights, int cap){
            int load = 0;
            int Day = 1;
            for(int i = 0; i<weights.length; i++){
                if(load+weights[i] > cap){
                    Day = Day+1;
                    load = weights[i];
                } else {
                    load += weights[i];
                }
            }
            return Day;
        }    
    
}