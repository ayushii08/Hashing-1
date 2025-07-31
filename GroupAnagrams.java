// Time Complexity : O(n * k log k), where
//   n = number of strings in input array
//   k = maximum length of a string (due to sorting each string)
// Space Complexity : O(n * k), for storing all strings in the hashmap and the final result
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Approach:
// For each string, sort its characters to get a common signature for anagrams.
// Use a HashMap to group strings by their sorted version.
// Return all the grouped lists from the map.

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store grouped anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Convert word to char array and sort it
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            
            // Convert sorted char array back to string
            String sortedWord = String.valueOf(charArr);

            // If sortedWord is not in map, initialize with new list
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            // Add original word to the corresponding anagram group
            map.get(sortedWord).add(word);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}
