class Solution {
    public char findTheDifference(String s, String t) {
   int i = 0;
        int len = s.length();
        int res = 0;
        while(i<len){
            res = res ^ s.charAt(i);                                           // Time Complexity : O(n)
                                                                               // Space Complexity : O(1)
            res = res ^ t.charAt(i);
            i++;
        }
        res = res ^ t.charAt(i);
        return (char)res;
    }
}
