class Solution {
    public String shortestPalindrome(String s) {
        if (new StringBuilder(s).reverse().toString().equals(s)){
            return s;
        }
        for (int r=s.length()-1; r>=0;r--){
            if (isPalindrome(s,r)){
                String suffix = s.substring(r+1);
                return new StringBuilder(suffix).reverse().toString()+s;
            }
        }
        return "";
    }
    private Boolean isPalindrome(String s, int r) {
        String prefix = s.substring(0,r+1);
        return new StringBuilder(prefix).reverse().toString().equals(prefix);
    }
}