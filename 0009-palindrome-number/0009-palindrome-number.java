class Solution {
    public boolean isPalindrome(int x) {
       
        String s = Integer.toString(x);

        StringBuilder sb = new StringBuilder(s);

       

        return s.equals(sb.reverse().toString());
    }
}