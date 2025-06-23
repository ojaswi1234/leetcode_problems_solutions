class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;
        
        while (count < n) {
            for (long i = (long) Math.pow(10, (length - 1) / 2); count < n && i < (long) Math.pow(10, (length + 1) / 2); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                String left = sb.toString();
                String right = new StringBuilder(left.substring(0, length / 2)).reverse().toString();
                long num = Long.parseLong(left + right);
                if (isKPalindrome(num, k)) {
                    sum += num;
                    count++;
                }
            }
            length++;
        }

        return sum;
    }

    private boolean isKPalindrome(long num, int k) {
        return isPalindrome(Long.toString(num)) && isPalindrome(toBaseK(num, k));
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }
}
