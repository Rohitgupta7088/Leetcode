class Solution {
    public int countSegments(String s) {
        if(s.length() == 0){
            return 0;
        }
        List<String> ll = new ArrayList<>();
        s = s.trim();
        String newstr = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                newstr += s.charAt(i);
            }
            else{
                if(i>0 && s.charAt(i) == ' ' && s.charAt(i-1) == ' '){
                    continue;
                }
                else if(s.charAt(i) == ' '){
                    ll.add(newstr);
                    newstr = "";
                    continue;
                }
            }

            if(i==s.length()-1){
                ll.add(newstr);
            }
        }

        return ll.size();
    }
}