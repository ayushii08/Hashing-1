// I used a HashMap sMap to map characters from string `s` to string `t`.
// I used a HashSet `set` to track characters in `t` that are already mapped,
// to ensure that no two characters from `s` point to the same character in `t`.

// Time Complexity : O(n), where n is the length of the strings
// Space Complexity : O(1), as the number of unique characters is bounded (ASCII = 256)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


import java.util.*;

public class IsoMorphic {
    public static boolean isIsomorphic(String s, String t) {
        // Edge case: null or unequal lengths
        if (s == null || t == null || s.length() != t.length()) return false;

        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // If sChar is already mapped
            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) return false;
            } else {
                // If tChar is already used by another sChar
                if (set.contains(tChar)) return false;

                sMap.put(sChar, tChar);
                set.add(tChar);
            }
        }

        return true;
    }
}
