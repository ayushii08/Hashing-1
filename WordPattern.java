// Time Complexity : O(n), where n is the number of characters/words in the input
// Space Complexity : O(n), for storing mappings between pattern characters and words
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// I used two HashMaps to ensure a bijective (one-to-one and onto) mapping:
//   1. charToword maps pattern characters to words.
//   2. wordTochar maps words back to pattern characters.
//  We split the input string `s` by spaces into words.
//  For each character-word pair, we check:
//   - If the mapping exists and matches → continue.
//   - If mapping conflicts → return false.
// - If all mappings are consistent, return true.

import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Split the input string into words
        String[] words = s.split(" ");

        // Edge case: number of words and pattern characters must match
        if (words.length != pattern.length()) return false;

        // Mappings from char → word and word → char
        HashMap<Character, String> charToword = new HashMap<>();
        HashMap<String, Character> wordTochar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String word = words[i];

            // Check char → word mapping
            if (charToword.containsKey(patternChar)) {
                if (!charToword.get(patternChar).equals(word)) return false;
            } else {
                charToword.put(patternChar, word);
            }

            // Check word → char mapping
            if (wordTochar.containsKey(word)) {
                if (wordTochar.get(word) != patternChar) return false;
            } else {
                wordTochar.put(word, patternChar);
            }
        }

        return true;
    }
}
