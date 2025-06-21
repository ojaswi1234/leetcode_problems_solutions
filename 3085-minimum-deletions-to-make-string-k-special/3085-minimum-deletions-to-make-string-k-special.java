class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        for (int count : freq) {
            if (count > 0) list.add(count);
        }

        Collections.sort(list); // ascending order
        int n = list.size();
        int minDeletions = Integer.MAX_VALUE;

        // Try choosing each frequency as the baseline
        for (int i = 0; i < n; i++) {
            int x = list.get(i); // chosen min freq
            int deletions = 0;

            for (int j = 0; j < n; j++) {
                int f = list.get(j);
                if (f < x) {
                    deletions += f; // delete all
                } else if (f > x + k) {
                    deletions += f - (x + k); // bring down to x + k
                }
            }
            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions == Integer.MAX_VALUE ? 0 : minDeletions;
    }
}
