class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        return helper(ransomNote, magazine);
    }

    public boolean helper(String s2, String s1){
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
            }
            else{
                hm.put(ch, 1);
            }
        }

        for(int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(hm.containsKey(ch) && hm.get(ch) > 0){
                hm.put(ch, hm.get(ch)-1);
            }
            else{
                return false;
            }
        }

        return true;
    }
}