class Solution:
    def shortestPalindrome(self, s: str) -> str:
        if s[::-1]==s:
            return s
        def is_palindrome(s,r):
            if s[:r+1]== s[:r+1][::-1]:
                return True
            return False
        for r in range(len(s)-1,-1,-1):
            if is_palindrome(s,r):
                suffix= s[r+1:]
                return suffix[::-1]+s
            
     