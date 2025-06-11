import java.util.Arrays;

class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        // Iterate over all ordered pairs of digits a ≠ b
        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                // minDiff[parityA][parityB] tracks the minimum (countA - countB)
                // among all valid left‐end prefixes with those parities
                int[][] minDiff = new int[2][2];
                for (int[] row : minDiff) Arrays.fill(row, Integer.MAX_VALUE / 2);

                // Build prefix sums for a and b
                int[] preA = new int[n + 1];
                int[] preB = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    preA[i + 1] = preA[i] + (s.charAt(i) == a ? 1 : 0);
                    preB[i + 1] = preB[i] + (s.charAt(i) == b ? 1 : 0);
                }

                int l = 0;
                // Slide right end r from 0..n-1
                for (int r = 0; r < n; r++) {
                    // While window [l..r] is size ≥ k and both a and b appear in (l..r]:
                    while (r - l + 1 >= k
                            && preA[l] < preA[r + 1]
                            && preB[l] < preB[r + 1]) {
                        int pa = preA[l] & 1;
                        int pb = preB[l] & 1;
                        minDiff[pa][pb] = Math.min(minDiff[pa][pb], preA[l] - preB[l]);
                        l++;
                    }
                    int currA = preA[r + 1], currB = preB[r + 1];
                    // We need a odd (parity 1) and b even (parity 0) at right end,
                    // so we look up opposite parity prefix
                    ans = Math.max(ans,
                            (currA - currB)
                            - minDiff[1 - (currA & 1)][currB & 1]
                    );
                }
            }
        }

        return (ans == Integer.MIN_VALUE ? -1 : ans);
    }
}
