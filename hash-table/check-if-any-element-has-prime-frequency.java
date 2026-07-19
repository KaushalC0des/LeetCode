class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int x : nums) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }
        
        HashMap<Integer, Integer> countOfFreq = new HashMap<>();
        for (int f : freqMap.values()) {
            countOfFreq.put(f, countOfFreq.getOrDefault(f, 0) + 1);
        }
        
        for (int f : countOfFreq.keySet()) {
            if (isPrime(f)) return true;
        }
        return false;
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}