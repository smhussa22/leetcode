package src;

import java.util.Map;
import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> seenChars = new HashMap<>();

        for (int right = 0; right < s.length(); ++right) {

            if (!seenChars.containsKey(s.charAt(right)) || seenChars.get(s.charAt(right)) < left) {

                seenChars.put(s.charAt(right), right);

            }
            else {

                left = seenChars.get(s.charAt(right)) + 1;
                seenChars.put(s.charAt(right), right);

            }

            int currLength = right - left + 1;
            maxLength = Math.max(maxLength, currLength);

        }

        return maxLength;
        
    }

    // helper to run test cases
    private static void runTest(String s, LongestSubstringWithoutRepeatingCharacters solver) {

        System.out.println("Input: \"" + s + "\"");
        System.out.println("Output: " + solver.lengthOfLongestSubstring(s));
        System.out.println();

    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters solver = new LongestSubstringWithoutRepeatingCharacters();

        runTest("abba", solver);    // expected: 2
        runTest("bbbbb", solver);  // expected: 1
        runTest("pwwkew", solver); // expected: 3

    }
}
