class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> resultset = new ArrayList<>();

       // get the index the element corresponds to
       for(int i=0; i<nums.length;i++){
        int index  = Math.abs(nums[i])-1;

        // if the numberis already negative it means we are encoutering it twice
        if(nums[index] < 0)
           resultset.add(index+1);

        // flip the positive number to positive
        nums[index] = nums[index] * -1;
       }
       return resultset;
     
    }
}