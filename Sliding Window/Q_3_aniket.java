class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        
        Set<Character> set = new HashSet<>();
        
        while( j < s.length()){
            if(set.add(s.charAt(j))){
                max = Math.max(max,j-i+1);
                j++;
            }else{
                while(!set.add(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}