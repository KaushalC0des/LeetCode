class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;  
        
        while(left < right) {
            
            while(left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
         
            while(left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }
            
            if(Character.toLowerCase(s.charAt(left)) != 
               Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}