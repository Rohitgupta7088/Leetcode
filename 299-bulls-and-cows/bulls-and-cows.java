class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder s = new StringBuilder(secret);
        StringBuilder g = new StringBuilder(guess);

        int bull = 0;
        for(int i=0; i<s.length(); i++){
            if( s.charAt(i) == g.charAt(i) ){
                bull++;
                s.deleteCharAt(i);
                g.deleteCharAt(i);
                i--;
            }
        }

        StringBuilder hint = new StringBuilder();
        hint.append(String.valueOf(bull));
        hint.append('A');

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        int cows = 0;
        for(int i=0; i<g.length(); i++){
            char ch = g.charAt(i);
            if(hm.containsKey(ch)){
                cows++;
                hm.put(ch, hm.get(ch)-1);
                if(hm.get(ch) == 0){
                    hm.remove(ch);
                }
            }
        }

        hint.append(String.valueOf(cows));
        hint.append('B');

        return hint.toString();
    }
}