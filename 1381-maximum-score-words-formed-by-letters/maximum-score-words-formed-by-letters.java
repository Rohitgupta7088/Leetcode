class Solution {
    HashMap<Character, Integer> hm = new HashMap<>();
    int maxScore = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        for(char ch: letters){
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> temp = new HashMap<>();
        helper(words, 0, score, 0, temp);
        return maxScore;
    }

    public void helper(String words[], int idx, int score[], int currScore, HashMap<Character,Integer> temp){
        if(idx >= words.length){
            maxScore = Math.max(maxScore, currScore);
            return;
        }

        helper(words, idx+1, score, currScore, temp);
        int wordScore = 0;

        HashMap<Character, Integer> currfreq = new HashMap<>();
        for(int i=0; i<words[idx].length(); i++){
            char ch = words[idx].charAt(i);
            currfreq.put(ch, currfreq.getOrDefault(ch, 0)+1);
        }

        boolean valid = true;

        for(int i=0; i<words[idx].length(); i++){
            char ch = words[idx].charAt(i);
            if(currfreq.get(ch) + temp.getOrDefault(ch, 0) > hm.getOrDefault(ch, 0)){
                valid = false;
                break;
            }
        }

        if(valid){
            for(int i=0; i<words[idx].length(); i++){
                char ch = words[idx].charAt(i);
                temp.put(ch, temp.getOrDefault(ch, 0)+1);
                wordScore += score[ch-'a'];
            }

            helper(words, idx+1, score, currScore+wordScore, temp);

            for(int i=0; i<words[idx].length(); i++){
                char ch = words[idx].charAt(i);
                if(temp.get(ch) > 0){
                    temp.put(ch, temp.get(ch)-1);
                }

                if(temp.get(ch) == 0){
                    temp.remove(ch);
                }
            }
        }
    }
}