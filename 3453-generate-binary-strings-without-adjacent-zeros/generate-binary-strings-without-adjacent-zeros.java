class Solution {
    public List<String> validStrings(int n) {
        List<String> ll = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, sb, ll);
        return ll;
    }

    public void helper(int n, StringBuilder sb, List<String> ll){
        if(sb.length() == n){
            ll.add(sb.toString());
            return;
        }

        if(sb.length() >0 && sb.charAt(sb.length()-1) == '0'){
            sb.append('1');
            helper(n, sb, ll);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append('1');
            helper(n, sb, ll);
            sb.deleteCharAt(sb.length()-1);

            sb.append('0');
            helper(n, sb, ll);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}