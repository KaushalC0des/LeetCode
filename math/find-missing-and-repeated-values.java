class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
    int n = grid.length;
    
    HashSet<Integer> set = new HashSet<>();
    int repeated = -1;
    int actualSum = 0;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int num = grid[i][j];
            
            if (set.contains(num)) {
                repeated = num;  
            } else {
                set.add(num);
            }
            
            actualSum += num;  
        }
    }
    
    int expectedSum = n * n * (n * n + 1) / 2;
    int missing = expectedSum + repeated - actualSum;
    
    return new int[]{repeated, missing};
}
}