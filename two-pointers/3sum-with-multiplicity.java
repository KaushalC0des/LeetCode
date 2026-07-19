class Solution {
    public int threeSumMulti(int[] arr, int target) {
        final int MOD = 1_000_000_007;
        Arrays.sort(arr);  
        int n = arr.length;
        long count = 0;  
    
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                
                if (sum < target) {
                    
                    left++;
                    
                } else if (sum > target) {
                    
                    right--;
                    
                } else {
                    
                    
                    
                    if (arr[left] == arr[right]) {
                        int numElements = right - left + 1;
                        
                        count += (long) numElements * (numElements - 1) / 2;
                        count %= MOD;
                        break;  
                    }
                     
                    else {
                        
                        int leftCount = 1;
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            left++;
                            leftCount++;
                        }
                        
                        int rightCount = 1;
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            right--;
                            rightCount++;
                        }
                        
                        
                        count += (long) leftCount * rightCount;
                        count %= MOD;
                        
                        
                        left++;
                        right--;
                    }
                }
            }
        }
        
        return (int) count;
    }
}