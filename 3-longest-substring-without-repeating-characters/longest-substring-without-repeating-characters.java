class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashMap<Character, Integer> map = new HashMap<>();
        // int left = 0;
        // int max = 0;
        // for(int i=0; i<s.length(); i++){
        //     if(map.containsKey(s.charAt(i))){
        //         left = Math.max(left,map.get(s.charAt(i)) + 1);
        //     }
        //     map.put(s.charAt(i),i);
        //     max = Math.max(max,i-left+1);
        // }
        // return max;

        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxlength = 0;
        for(int right=0; right<s.length(); right++){
            while( set.contains(s.charAt(right)) ){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlength = Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
}