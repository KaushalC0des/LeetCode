class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n-k+1];

        for(int i=0; i<k; i++){

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        } 
        // The front of the deque is the maximum of the first window
        result[0] = nums[deque.peekFirst()];  

        for(int i=k; i<n; i++){
            if(deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            // remove all the elements that are smaller than incoming
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            // Add the current element index 
            deque.offerLast(i);

            // the front of the deque is always max
            result[i-k+1] = nums[deque.peekFirst()];
        }   

        return result;


    }
}