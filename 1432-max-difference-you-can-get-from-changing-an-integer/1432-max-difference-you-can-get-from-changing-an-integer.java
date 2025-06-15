class Solution {
    public int maxDiff(int num) {
        // Convert number to character array for manipulation
        char[] numStr = String.valueOf(num).toCharArray();
        
        // First operation: Maximize the number (a)
        char[] a = numStr.clone();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != '9') {
                char x = a[i];
                for (int j = i; j < a.length; j++) {
                    if (a[j] == x) {
                        a[j] = '9';
                    }
                }
                break; // Stop after replacing the first non-9 digit
            }
        }
        
        // Second operation: Minimize the number (b)
        char[] b = numStr.clone();
        if (b[0] != '1') {
            // Replace first digit if it's not 1
            char x = b[0];
            for (int j = 0; j < b.length; j++) {
                if (b[j] == x) {
                    b[j] = '1';
                }
            }
        } else {
            // If first digit is 1, replace a non-first non-0 digit with 0
            for (int i = 1; i < b.length; i++) {
                if (b[i] != '0' && b[i] != '1') {
                    char x = b[i];
                    for (int j = i; j < b.length; j++) {
                        if (b[j] == x) {
                            b[j] = '0';
                        }
                    }
                    break;
                }
            }
        }
        
        // Convert results to integers
        int maxA = Integer.parseInt(new String(a));
        int minB = Integer.parseInt(new String(b));
        
        // Return the maximum difference
        return maxA - minB;
    }
}