class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderIndex[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderIndex)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String word1, String word2, int[] orderIndex) {
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return orderIndex[word1.charAt(i) - 'a'] < orderIndex[word2.charAt(i) - 'a'];
            }
        }
        return word1.length() <= word2.length();
    }
}