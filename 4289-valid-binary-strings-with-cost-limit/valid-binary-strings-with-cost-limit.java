class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ll = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, k, ll, sb, 0, 0);
        return ll;
    }

    public void helper(int n, int k, List<String> ll, StringBuilder sb, int idx, int cost){

        if(sb.length() == n){
            if(cost <= k){
                ll.add(sb.toString());
            }
            return;
        }

        if(sb.length() > 0 && sb.charAt(sb.length()-1) == '1'){
            sb.append('0');
            helper(n, k, ll, sb, idx+1, cost);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append('0');
            helper(n, k, ll, sb, idx+1, cost);
            sb.deleteCharAt(sb.length()-1);

            sb.append('1');
            helper(n, k, ll, sb, idx+1, cost+idx);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}