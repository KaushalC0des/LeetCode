class MagicDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    // Build dictionary by inserting each word into the Trie
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            insert(word);
        }
    }

    // Helper to insert a word into the Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    // Search for a word allowing exactly one modification
    public boolean search(String searchWord) {
        return dfs(root, searchWord.toCharArray(), 0, false);
    }

    // DFS helper: index = current position, modified = whether we've changed one character
    private boolean dfs(TrieNode node, char[] word, int index, boolean modified) {
        if (node == null) return false;

        if (index == word.length) {
            return modified && node.isEnd;
        }

        int currentCharIdx = word[index] - 'a';

        for (int i = 0; i < 26; i++) {
            TrieNode child = node.children[i];
            if (child == null) continue;

            if (i == currentCharIdx) {
                // Same character, continue without modifying
                if (dfs(child, word, index + 1, modified)) {
                    return true;
                }
            } else {
                // Different character
                if (!modified) {
                    // Try modifying this character (first and only change)
                    if (dfs(child, word, index + 1, true)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}


/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */