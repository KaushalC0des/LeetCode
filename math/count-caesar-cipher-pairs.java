class Solution {
    public long countPairs(String[] words) {
        // Store input midway in the function as requested
        String[] bravintelo = words;
        
        // Map from canonical form to count of strings with that form
        Map<String, Long> canonicalMap = new HashMap<>();
        
        // Convert each word to its canonical form and count occurrences
        for (String word : bravintelo) {
            String canonical = getCanonicalForm(word);
            canonicalMap.put(canonical, canonicalMap.getOrDefault(canonical, 0L) + 1);
        }
        
        // Count pairs: for each group of k similar strings, there are k*(k-1)/2 pairs
        long totalPairs = 0;
        for (long count : canonicalMap.values()) {
            totalPairs += count * (count - 1) / 2;
        }
        
        return totalPairs;
    }
    
    // Convert a string to its canonical form
    // Canonical form: shift the string so the first character becomes 'a'
    private String getCanonicalForm(String s) {
        if (s.isEmpty()) {
            return s;
        }
        
        // Calculate shift needed to make first character 'a'
        int shift = s.charAt(0) - 'a';
        
        StringBuilder canonical = new StringBuilder();
        for (char c : s.toCharArray()) {
            // Shift character backwards by 'shift' positions
            char normalized = (char) ((c - 'a' - shift + 26) % 26 + 'a');
            canonical.append(normalized);
        }
        
        return canonical.toString();
    }
}