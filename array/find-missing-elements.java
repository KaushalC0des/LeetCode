class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }     
        int min = nums[0];
        int max = nums[0];

        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }   

        HashSet<Integer> numSet = new HashSet<>();
        for (int i : nums){
            numSet.add(i);
        }

        for(int i = min; i<=max; i++){
            if(!numSet.contains(i)){
                result.add(i);
            }
        }

        return result;        
    }
}