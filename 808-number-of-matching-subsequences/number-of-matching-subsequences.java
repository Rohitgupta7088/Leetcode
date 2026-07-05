class Solution {
    // int count = 0;
    // public int numMatchingSubseq(String s, String[] words) {
    //     HashMap<String, Integer> hm = new HashMap<>();
    //     for(String str: words){
    //         hm.put(str, hm.getOrDefault(str,0)+1);
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     helper(s, 0, sb, hm);
    //     return count;
    // }

    // public void helper(String s, int idx, StringBuilder sb, HashMap<String, Integer> hm){
    //     if(idx == s.length()){
    //         if(hm.containsKey(sb.toString())){
    //             count++;
    //             hm.put(sb.toString(), hm.get(sb.toString())-1);
    //             if(hm.get(sb.toString()) == 0){
    //                 hm.remove(sb.toString());
    //             }
    //         }
    //         return;
    //     }

    //     sb.append(s.charAt(idx));
    //     helper(s, idx+1, sb, hm);
    //     sb.deleteCharAt(sb.length()-1);
    //     helper(s, idx+1, sb, hm);
    // }




    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch, new ArrayList<>());
            }

            hm.get(ch).add(i);
        }

        int count = 0;
        for(String str: words){
            int preidx = -1;
            boolean found = true;
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(hm.containsKey(ch)){
                    int idx = helper(hm.get(ch), 0, hm.get(ch).size()-1, preidx);
                    if(idx != -1){
                        preidx = idx;
                    }
                    else{
                        found = false;
                        break;
                    }
                }
                else{
                    found = false;
                    break;
                }
            }

            if(found){
                count++;
            }
        }

        return count;
    }

    public int helper(ArrayList<Integer> ll, int si, int ei, int target){
        if(si>ei){
            return -1;
        }

        int mid = si+(ei-si)/2;

        if(mid == 0){
            if(ll.get(mid)>target){
                return ll.get(mid);
            }
            else{
                return helper(ll, mid+1, ei, target);
            }
        }

        if(mid == ll.size()-1){
            if(ll.get(mid)>target && ll.get(mid-1)<=target){
                return ll.get(mid);
            }
            else{
                return helper(ll, si, mid-1, target);
            }
        }

        if(ll.get(mid-1)<=target && ll.get(mid)>target){
            return ll.get(mid);
        }

        if(ll.get(mid)<=target){
            return helper(ll, mid+1, ei, target);
        }
        else{
            return helper(ll, si, mid-1, target);
        }
    }
}