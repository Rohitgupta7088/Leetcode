class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        int arr[] = new int[26];
        for(int i=0; i<s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == 0){
                int count = 0;
                for(int j=0; j<s.length(); j++){
                    if(s.charAt(i) == s.charAt(j)){
                        count ++;
                    }
                }

                arr[s.charAt(i) - 'a'] = count;
            }
        }

        for(int i=0; i<t.length(); i++){
            int count = 0;
            if(arr[t.charAt(i)-'a'] == -1){
                continue;
            }
            for(int j=0; j<t.length(); j++){
                if(t.charAt(i) == t.charAt(j)){
                    count ++;
                }
            }
            if(arr[t.charAt(i)-'a'] != count){
                return false;
            }
            arr[t.charAt(i)-'a'] = -1;
        }

        return true;
    }
}