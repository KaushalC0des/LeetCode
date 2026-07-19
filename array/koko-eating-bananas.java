class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        while(low<high){
            int mid = (low+high)/2;
            int hours = 0;
            for(int pile:piles){
                hours += Math.ceil((double)pile/mid);
            }
            if(hours <= h){
                high = mid;
            } else {
                low = mid+1;
            }
            
        }
        return low;
    }
    public int getMax(int[] piles){
        int max = 0;
        for(int pile : piles){
            max = Math.max(pile,max);
        }
        return max;
    }
}