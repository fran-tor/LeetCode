function isPalindrome(s:string, r:number) : boolean {
    return s.slice(0,r+1)===s.slice(0,r+1).split("").reverse().join("")
}

function shortestPalindrome(s: string): string {
    if (s.split("").reverse().join("")===s){
        return s
    }
    for (let r=s.length-1; r>=0; r--){
        if (isPalindrome(s,r)){
            const suffix = s.slice(r+1)
            return suffix.split("").reverse().join("")+s
        }
    }
    return ""
}; 