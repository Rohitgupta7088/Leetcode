class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean visit[] = new boolean[9];

        helper(pattern, sb, temp, visit, 0);
        return sb.toString();
    }

    public void helper(String pattern, StringBuilder sb, StringBuilder temp, boolean visit[], int idx){
        if(idx == pattern.length()){
            if(sb.length() == 0){
                sb.append(temp.toString());
            }
            else if(sb.toString().compareTo(temp.toString()) > 0){
                sb.setLength(0);
                sb.append(temp.toString());
            }
            return;
        }

        char ch = pattern.charAt(idx);

        if(temp.length() == 0){
            for(int i=1; i<10; i++){
                temp.append((char)(i+'0'));
                visit[i-1] = true;
                helper(pattern, sb, temp, visit, idx);
                temp.deleteCharAt(temp.length()-1);
                visit[i-1] = false;
            }
        }

        if(temp.length() > 0 && ch == 'I'){
            for(int i=temp.charAt(temp.length()-1)-'0'+1; i<10; i++){
                if(visit[i-1] == true){
                    continue;
                }

                temp.append((char)(i+'0'));
                visit[i-1] = true;
                helper(pattern, sb, temp, visit, idx+1);
                temp.deleteCharAt(temp.length()-1);
                visit[i-1] = false;
            }
        }

        if(temp.length() > 0 && ch == 'D'){
            for(int i=temp.charAt(temp.length()-1)-'0'-1; i>0; i--){
                if(visit[i-1] == true){
                    continue;
                }

                temp.append((char)(i+'0'));
                visit[i-1] = true;
                helper(pattern, sb, temp, visit, idx+1);
                temp.deleteCharAt(temp.length()-1);
                visit[i-1] = false;
            }
        }
    }
}