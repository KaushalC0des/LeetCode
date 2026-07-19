class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < m*k){
            return -1;
        }
        int low =  Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int bloom : bloomDay){
            low = Math.min(low,bloom);
            high = Math.max(high,bloom);
        }
        int answer  = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(canMake(bloomDay, m, k, mid)){
                answer = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return answer;
    }
    private boolean canMake(int[] bloomDay, int m, int k, int day){
        int flowers = 0;
        int bouquets = 0;
        for(int bloom: bloomDay){
            if(bloom <= day){
                flowers++;
                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        if(bouquets >= m){
            return true;
        } else {
            return false;
        }
    }
}