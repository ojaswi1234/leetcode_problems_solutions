class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        
        // Find the first non-nine digit to replace with 9 for max value
        char firstNonNine = ' ';
        for (char c : numStr.toCharArray()) {
            if (c != '9') {
                firstNonNine = c;
                break;
            }
        }
        String maxNumStr = numStr.replace(firstNonNine, '9');
        int maxNum = Integer.parseInt(maxNumStr);
        
        // Find the first non-zero digit to replace with 0 for min value
        char firstNonZero = numStr.charAt(0); // First digit is best candidate
        String minNumStr = numStr.replace(firstNonZero, '0');
        int minNum = Integer.parseInt(minNumStr);
        
        return maxNum - minNum;
    }
}
