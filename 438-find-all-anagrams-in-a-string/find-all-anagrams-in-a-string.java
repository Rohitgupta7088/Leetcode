class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        List<Integer> ll = new ArrayList<>();

        if(n1==n2 && s.equals(p)){
            ll.add(0);
            return ll;
        }

        HashMap<Character, Integer> hmp = new HashMap<>();

        for(int i=0; i<n2; i++){
            char ch=p.charAt(i);
            if(hmp.containsKey(ch)){
                hmp.put(ch, hmp.get(ch)+1);
            }
            else{
                hmp.put(ch,1);
            }
        }

        HashMap<Character, Integer> hms = new HashMap<>();
        int left=0;
        int right=0;
        while(right<n1){
            char ch = s.charAt(right);
            if(hms.containsKey(ch)){
                hms.put(ch, hms.get(ch)+1);
            }
            else{
                hms.put(ch,1);
            }

            if(right-left+1 == n2){
                if(hms.equals(hmp)){
                    ll.add(left);
                }
                hms.put(s.charAt(left), hms.get(s.charAt(left))-1);
                if( hms.get(s.charAt(left)) == 0 ){
                    hms.remove(s.charAt(left));
                }
                left++;
            }
            right++;
        }
        return ll;
    }
}