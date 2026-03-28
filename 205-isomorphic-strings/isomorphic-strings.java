class Solution {
    public boolean isIsomorphic(String s, String t) {
        // if(s.length() != t.length()){
        //     return false;
        // }

        // StringBuilder newstr_s = new StringBuilder(s);
        // StringBuilder newstr_t = new StringBuilder(t);

        // for(int i=0; i<s.length(); i++){
        //     char ch1 = s.charAt(i);
        //     char ch2 = t.charAt(i);
        //     for(int j=0; j<t.length(); j++){
        //         if(newstr_t.charAt(j) == ch2){
        //             newstr_t.setCharAt(j, ch1);
        //         }
        //     }

        // }

        // for(int i=0; i<t.length(); i++){
        //     char ch1 = t.charAt(i);
        //     char ch2 = s.charAt(i);
        //     for(int j=0; j<s.length(); j++){
        //         if(newstr_s.charAt(j) == ch2){
        //             newstr_s.setCharAt(j, ch1);
        //         }
        //     }
        // }

        // return ( newstr_t.toString().equals(s) && newstr_s.toString().equals(t) );

        if(s.length() != t.length()){
            return false;
        }
        
        int map1[] = new int[256];
        int map2[] = new int[256];

        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map1[c1] == 0 && map2[c2] == 0){
                map1[c1] = c2;
                map2[c2] = c1;
            }
            else{
                if(map1[c1]!=c2 || map2[c2]!=c1){
                    return false;
                }
            }
        }

        return true;
    }
}