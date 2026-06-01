class Solution {
    int count = 0;
    HashSet<String> seen = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        List<Character> ll = new ArrayList<>();
        helper(tiles, 0, ll);
        return count;
    }

    public void helper(String tiles, int idx, List<Character> ll){
        if(idx >= tiles.length()){
            if(ll.size()>0){
                HashMap<Character, Integer> hm = new HashMap<>();
                char arr[] = new char[ll.size()];
                for(int i=0; i<ll.size(); i++){
                    char ch = ll.get(i);
                    arr[i] = ch;
                    if(hm.containsKey(ch)){
                        hm.put(ch, hm.get(ch)+1);
                    }
                    else{
                        hm.put(ch, 1);
                    }
                }
                
                Arrays.sort(arr);
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<arr.length; i++){
                    sb.append(arr[i]);
                }

                if(seen.contains(sb.toString())){
                    return;
                }

                seen.add(sb.toString());

                int ways = fact(ll.size());
                for(int repeat : hm.values()){
                    ways /= fact(repeat);
                }

                count += ways;
            }
            return;
        }

        ll.add(tiles.charAt(idx));
        helper(tiles, idx+1, ll);
        ll.remove(ll.size()-1);
        helper(tiles, idx+1, ll);
    }

    public int fact(int n) {
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
}