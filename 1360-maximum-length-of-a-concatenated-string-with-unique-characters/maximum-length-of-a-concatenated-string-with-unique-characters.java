class Solution {
    int maxlength = 0;
    public int maxLength(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        helper(arr, sb, hm, 0);
        return maxlength;
    }

    public void helper(List<String> arr, StringBuilder sb, HashMap<Character, Integer> hm, int idx){
        if(idx >= arr.size()){
            maxlength = Math.max(maxlength, sb.length());
            return;
        }

        boolean valid = false;
        for(int i=0; i<arr.get(idx).length(); i++){
            if( hm.containsKey(arr.get(idx).charAt(i)) ){
                valid = true;
                break;
            }
        }

        HashMap<Character, Integer> curr = new HashMap<>();
        for(int i=0; i<arr.get(idx).length(); i++){
            char ch = arr.get(idx).charAt(i);
            if(curr.containsKey(ch)){
                valid = true;
                break;
            }
            else{
                curr.put(ch, 1);
            }
        }

        if(!valid){
            for(int i=0; i<arr.get(idx).length(); i++){
                hm.put(arr.get(idx).charAt(i), 1);
            }

            sb.append(arr.get(idx));
            helper(arr, sb, hm, idx+1);
            
            for(int i=0; i<arr.get(idx).length(); i++){
                hm.remove(arr.get(idx).charAt(i));
            }

            sb.delete(sb.length() - arr.get(idx).length(), sb.length());
            helper(arr, sb, hm, idx+1);
        }
        else{
            helper(arr, sb, hm, idx+1);
        }
    }
}