import java.util.*;

public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            result.add(matches(query, pattern));
        }

        return result;
    }

    private boolean matches(String query, String pattern) {
        int j = 0; // Pointer for pattern

        for (int i = 0; i < query.length(); i++) {
            char qc = query.charAt(i);

            if (j < pattern.length() && qc == pattern.charAt(j)) {
                j++; // Matched character in pattern
            } else if (Character.isLowerCase(qc)) {
                continue; // Extra lowercase is allowed
            } else {
                return false; // Invalid uppercase letter not in pattern
            }
        }

        return j == pattern.length(); // All pattern letters must be matched
                                       // this is if loop 
    }
}

