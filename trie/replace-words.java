class Solution {

    // Step 1: Define the Trie Node class
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26 letters for 'a' to 'z'
        boolean isEndOfWord = false; // Marks end of a root word
    }

    private TrieNode root = new TrieNode(); // Root of the Trie

    // Step 2: Insert a root word into the Trie
    private void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);              // Get character
            int index = ch - 'a';                  // Convert to index (0-25)
            if (node.children[index] == null) {    // If path doesn't exist, create it
                node.children[index] = new TrieNode();
            }
            node = node.children[index];           // Move to next node
        }
        node.isEndOfWord = true; // Mark the end of a root word
    }

    // Step 3: Search for the shortest prefix/root in the Trie for a given word
    private String getShortestPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);             // Get character
            int index = ch - 'a';

            if (node.children[index] == null) {
                break; // No further path in Trie — root not found
            }

            prefix.append(ch);                     // Add char to prefix
            node = node.children[index];

            if (node.isEndOfWord) {
                return prefix.toString(); // Found the shortest root
            }
        }

        return word; // No prefix found, return the original word
    }

    // Step 4: Main method to replace words in the sentence
    public String replaceWords(List<String> dictionary, String sentence) {
        // Step 4.1: Build the Trie with dictionary root words
        for (int i = 0; i < dictionary.size(); i++) {
            insert(dictionary.get(i)); // Insert each root word into Trie
        }

        // Step 4.2: Split the sentence into individual words
        String[] words = sentence.split(" "); // Example: "the cattle" → ["the", "cattle"]

        // Step 4.3: Create an array to store replaced words
        String[] replacedWords = new String[words.length];

        // Step 4.4: Replace each word using the Trie
        for (int i = 0; i < words.length; i++) {
            replacedWords[i] = getShortestPrefix(words[i]);
        }

        // Step 4.5: Build the final result sentence manually
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < replacedWords.length; i++) {
            result.append(replacedWords[i]); // Add the replaced word
            if (i < replacedWords.length - 1) {
                result.append(" "); // Add space if it's not the last word
            }
        }

        // Step 4.6: Return the final sentence
        return result.toString();
    }
}
