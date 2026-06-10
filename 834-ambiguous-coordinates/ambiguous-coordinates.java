class Solution {
    String op = ".,_";
    public List<String> ambiguousCoordinates(String s) {
        List<String> ll = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        helper(s, sb, ll, 2);
        return ll;
    }

    public void helper(String num, StringBuilder sb, List<String> ll, int idx){
        if(idx == num.length()-1){
            sb.append(num.charAt(idx));
            if(isvalid(sb.toString())){
                int i=0;

                while(i<sb.length()){
                    if(sb.charAt(i) == ','){
                        sb.insert(i+1,' ');
                        break;
                    }
                    i++;
                }

                ll.add(sb.toString());
                sb.deleteCharAt(i+1);
            }
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        for(int i=0; i<op.length(); i++){
            char ch = op.charAt(i);
            if(ch != '_'){
                if(idx < num.length()-1){
                    sb.append(op.charAt(i));
                    sb.append(num.charAt(idx));
                    helper(num, sb, ll, idx+1);
                    sb.deleteCharAt(sb.length()-1);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else{
                if(idx < num.length()-1){
                    sb.append(num.charAt(idx));
                    helper(num, sb, ll, idx+1);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }

    public boolean isvalid(String curr) {
        int commaIdx = -1;
        int commaCount = 0;

        for(int i = 0; i < curr.length(); i++) {
            if(curr.charAt(i) == ',') {
                commaCount++;
                commaIdx = i;
            }
        }

        if(commaCount != 1) return false;

        String left = curr.substring(1, commaIdx); // skip '('
        String right = curr.substring(commaIdx + 1, curr.length() - 1); // skip ')'

        return validNumber(left) && validNumber(right);
    }

    public boolean validNumber(String s) {
        if(s.length() == 0) return false;

        int dotCount = 0;
        int dotIdx = -1;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.') {
                dotCount++;
                dotIdx = i;
            }
        }

        if(dotCount > 1) return false;

        if(dotCount == 0) {
            if(s.length() > 1 && s.charAt(0) == '0'){
                return false;
            }
            return true;
        }

        if(dotIdx == 0 || dotIdx == s.length() - 1){
            return false;
        }

        String intPart = s.substring(0, dotIdx);
        String fracPart = s.substring(dotIdx + 1);

        if(intPart.length() > 1 && intPart.charAt(0) == '0')
            return false;

        if(fracPart.charAt(fracPart.length() - 1) == '0')
            return false;

        return true;
    }
}