class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        for(int i=0; i<s.length(); i++){
            int ei = 0;
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    ei = j;
                }
            }
            if(ei > 0){
            max = Math.max(s.substring(i+1,ei).length(), max);
            }
        }

        return max;
    }
}