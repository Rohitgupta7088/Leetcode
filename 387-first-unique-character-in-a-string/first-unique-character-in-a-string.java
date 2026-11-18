class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        List<Integer> ll = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                ll.add(i);
            }
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<ll.size(); i++){
            if(hm.get(s.charAt(ll.get(i))) == 1){
                return ll.get(i);
            }
        }

        return -1;
    }
}