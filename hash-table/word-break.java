public class Solution {

    // Trie node
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false; // end of word flag
    }

    Node root = new Node();

    // Insert a word into the Trie
    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Search if a word exists in the Trie
    public boolean search(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    // Main function for LeetCode 139
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            insert(word); // Build Trie from dictionary
        }
        return wordBreakHelper(s, new HashMap<>());
    }

    // Recursive helper with memoization
    private boolean wordBreakHelper(String s, Map<String, Boolean> memo) {
        if (s.length() == 0) return true;
        if (memo.containsKey(s)) return memo.get(s);

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);

            if (search(prefix) && wordBreakHelper(suffix, memo)) {
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);
        return false;
    }
}
