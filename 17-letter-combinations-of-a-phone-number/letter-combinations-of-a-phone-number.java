class Solution {
    String[] arr = {
        "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> bigll = new ArrayList<>();

        if (digits.length() == 0) {
            return bigll;
        }

        StringBuilder sb = new StringBuilder();
        helper(digits, 0, sb, bigll);

        return bigll;
    }

    public void helper(String digits, int idx,
                       StringBuilder sb,
                       List<String> bigll) {

        if (idx == digits.length()) {
            bigll.add(sb.toString());
            return;
        }

        int arrIdx = digits.charAt(idx) - '0' - 2;
        String str = arr[arrIdx];

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            helper(digits, idx + 1, sb, bigll);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}