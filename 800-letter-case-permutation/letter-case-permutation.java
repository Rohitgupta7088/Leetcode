class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ll = new ArrayList<>();
        helper(new StringBuilder(s), 0, ll);
        return ll;
    }

    public void helper(StringBuilder sb, int idx, List<String> ll){
        if(idx == sb.length() ){
            ll.add(sb.toString());
            return;
        }

        char ch = sb.charAt(idx);
        if(!(ch>='a' && ch<='z') && !(ch>='A' && ch<='Z')){
            helper(sb, idx+1, ll);
        }
        else{
            sb.setCharAt(idx, Character.toLowerCase(ch));
            helper(sb, idx+1, ll);

            sb.setCharAt(idx, Character.toUpperCase(ch));
            helper(sb, idx+1, ll);
        }
    }
}