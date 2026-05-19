import java.util.*;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        // Store dictionary words in HashSet
        HashSet<String> set = new HashSet<>(wordDict);

        // DP array
        boolean[] dp = new boolean[s.length() + 1];

        // Empty string is always valid
        dp[0] = true;

        // Check every position
        for (int i = 1; i <= s.length(); i++) {

            // Try every possible split
            for (int j = 0; j < i; j++) {

                // Left part valid
                // and current substring exists in dictionary
                if (dp[j] && set.contains(s.substring(j, i))) {

                    dp[i] = true;

                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
