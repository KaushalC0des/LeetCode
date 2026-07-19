class Solution {
    public int residuePrefixes(String s) {
            int count = 0;
        Set<Character> distinctChars = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            // Add current character to the set of distinct characters
            distinctChars.add(s.charAt(i));
            
            // Current prefix length
            int prefixLength = i + 1;
            
            // Check if this prefix is a residue
            if (distinctChars.size() == prefixLength % 3) {
                count++;
            }
        }
        
        return count;
   
    }
}