class Solution {
    String op = "abc";
    public String getHappyString(int n, int k) {
        List<String> ll = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(ll, sb, n);
        return ll.size()>=k ? ll.get(k-1) : "";
    }

    public void helper(List<String> ll, StringBuilder sb, int n){
        if(sb.length() == n){
            ll.add(sb.toString());
            return;
        }

        if(sb.length() > n){
            return;
        }

        for(int i=0; i<op.length(); i++){
            if(sb.length()>0 && sb.charAt(sb.length()-1) == op.charAt(i)){
                continue;
            }
            sb.append(op.charAt(i));
            helper(ll, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}