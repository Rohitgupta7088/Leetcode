class Solution {
    String[] arr = {
        "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> bigll = new ArrayList<>();
        List<Character> ll = new ArrayList<>();
        helper(digits, 0, ll, bigll);

        return bigll;
    }

    public void helper(String digits, int idx,List<Character> ll, List<String> bigll) {

        if (ll.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for(char ch: ll){
                sb.append(ch);
            }
            bigll.add(sb.toString());
            return;
        }

        int arridx = digits.charAt(idx) - '0' - 2;
        String str = arr[arridx];

        for (int i = 0; i < str.length(); i++) {
            ll.add(str.charAt(i));
            helper(digits, idx + 1, ll, bigll);
            ll.remove(ll.size() - 1);
        }
    }
}