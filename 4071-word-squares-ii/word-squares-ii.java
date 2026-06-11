class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> bigll = new ArrayList<>();
        List<String> ll = new ArrayList<>();
        boolean valid[] = new boolean[words.length];
        helper(words, bigll, ll, valid);

        bigll.sort((a, b) -> {
            for (int i = 0; i < 4; i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        
        return bigll;
    }

    public void helper(String words[], List<List<String>> bigll, List<String> ll, boolean valid[]){

        if(ll.size() == 4){
            bigll.add(new ArrayList<>(ll));
            return;
        }

        for(int  i=0; i<words.length; i++){
            String currword = words[i];
            if(valid[i]){
                continue;
            }

            if(ll.size() == 0){ 
                ll.add(currword); 
                valid[i] = true; 
                helper(words, bigll, ll, valid); 
                ll.remove(ll.size()-1); 
                valid[i] = false; 
            }
            else if(ll.size() == 1){
                if(ll.get(0).charAt(0) == currword.charAt(0)){
                    ll.add(currword); 
                    valid[i] = true; 
                    helper(words, bigll, ll, valid); 
                    ll.remove(ll.size()-1); 
                    valid[i] = false;
                }
            }
            else if(ll.size() == 2){
                if(ll.get(0).charAt(3) == currword.charAt(0)){
                    ll.add(currword); 
                    valid[i] = true; 
                    helper(words, bigll, ll, valid); 
                    ll.remove(ll.size()-1); 
                    valid[i] = false;
                }
            }
            else if(ll.size() == 3){
                if(ll.get(1).charAt(3) == currword.charAt(0) && ll.get(2).charAt(3) == currword.charAt(3)){
                    ll.add(currword); 
                    valid[i] = true; 
                    helper(words, bigll, ll, valid); 
                    ll.remove(ll.size()-1); 
                    valid[i] = false;
                }
            }
        }
    }
}