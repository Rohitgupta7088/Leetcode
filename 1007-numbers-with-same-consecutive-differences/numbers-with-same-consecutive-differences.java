class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> ll = new ArrayList<>();

        for(int i=1; i<=9; i++){
            sb.append((char)(i+'0'));
            helper(n, k, sb, ll, i);
            sb.deleteCharAt(sb.length()-1);
        }
        int arr[] = new int[ll.size()];
        for(int i=0; i<ll.size(); i++){
            arr[i] = ll.get(i);
        }
        return arr;
    }

    public void helper(int n, int k, StringBuilder sb, List<Integer> ll, int curr){
        if(sb.length() == n){
            ll.add(Integer.parseInt(sb.toString()));
            return;
        }

        if(sb.length() > n || curr > 9){
            return;
        }

        int next1 = sb.charAt(sb.length()-1)-'0'+k;
        int next2 = sb.charAt(sb.length()-1)-'0'-k;

        if(next1>=0 && next1<=9){
            sb.append((char)(next1+'0'));
            helper(n, k, sb, ll, next1);
            sb.deleteCharAt(sb.length()-1);
        }

        if(next2>=0 && next2<=9 && k!=0){
            sb.append((char)(next2+'0'));
            helper(n, k, sb, ll, next2);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}