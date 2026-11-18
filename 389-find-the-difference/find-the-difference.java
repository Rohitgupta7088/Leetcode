class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        char extra = '\0';
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!hm.containsKey(ch)){
                extra = ch;
                break;
            }
            else{
                hm.put(ch, hm.get(ch)-1);
                if(hm.get(ch) == 0){
                    hm.remove(ch);
                }
            }
        }

        return extra;
    }
}