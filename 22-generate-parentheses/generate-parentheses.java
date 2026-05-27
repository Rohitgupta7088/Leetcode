class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ll = new ArrayList<>();
        helper(n, sb, ll, 0, 0);
        return ll;
    }

    public void helper(int n, StringBuilder sb, List<String> ll, int open, int close){
        if(sb.length() == 2*n){
            ll.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            helper(n, sb, ll, open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(close<open){
            sb.append(')');
            helper(n, sb, ll, open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}