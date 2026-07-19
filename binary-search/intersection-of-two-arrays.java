class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int N = nums1.length;
        int M  = nums2.length;
        int p1 = 0;
        int p2 = 0;

       HashSet<Integer> intersection = new HashSet<>();

        while(p1 < N && p2 < M){
            if(nums1[p1] == nums2[p2]){
                intersection.add(nums2[p2]);
                p1++;
                p2++;
            } else if(nums1[p1]<nums2[p2]){
                p1++;
            } else {
                p2++;
            }   
        }
        int k = intersection.size();
        int result[] = new int[k];
        int curr = 0;
        for(int y : intersection){
           result[curr++] = y;
        }
        return result;
    }
}