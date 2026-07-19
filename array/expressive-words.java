class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isStretchy(String s, String word) {
        int i = 0, j = 0;
        int n = s.length(), m = word.length();
        
        while (i < n && j < m) {
            // Characters must match
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            
            // Count the group length in s
            int lenS = 1;
            while (i + lenS < n && s.charAt(i + lenS) == s.charAt(i)) {
                lenS++;
            }
            
            // Count the group length in word
            int lenWord = 1;
            while (j + lenWord < m && word.charAt(j + lenWord) == word.charAt(j)) {
                lenWord++;
            }
            
            // Check validity of this group
            if (lenS < lenWord) {
                // Can't shrink - invalid
                return false;
            } else if (lenS < 3 && lenS != lenWord) {
                // Group in s is too small to stretch, must be exact match
                return false;
            }
            // If lenS >= 3, any lenWord from 1 to lenS is valid
            
            // Move pointers forward
            i += lenS;
            j += lenWord;
        }
        
        // Both must reach the end
        return i == n && j == m;
    }
}