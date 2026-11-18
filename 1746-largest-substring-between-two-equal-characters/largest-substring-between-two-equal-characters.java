class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxlen = -1;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                maxlen = Math.max(maxlen, i-hm.get(ch)-1);
            }
            else{
                hm.put(ch, i);
            }
        }

        return maxlen;
    }
}