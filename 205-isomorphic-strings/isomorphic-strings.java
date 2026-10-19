class Solution {
    public boolean isIsomorphic(String s, String t) {
        // if(s.length() != t.length()){
        //     return false;
        // }

        // StringBuilder news = new StringBuilder(s);
        // StringBuilder newt = new StringBuilder(t);
 
        // for(int i=0; i<s.length(); i++){
        //     char chs = s.charAt(i);
        //     char cht = t.charAt(i);
        //     for(int j=0; j<t.length(); j++){
        //         if(newt.charAt(j) == cht){
        //             newt.setCharAt(j, chs);
        //         }
        //     }
        // }

        // for(int i=0; i<t.length(); i++){
        //     char chs = s.charAt(i);
        //     char cht = t.charAt(i);
        //     for(int j=0; j<s.length(); j++){
        //         if(news.charAt(j) == chs){
        //             news.setCharAt(j, cht);
        //         }
        //     }
        // }

        // return (newt.toString().equals(s) && news.toString().equals(t));


        int arrs[] = new int[256];
        int arrt[] = new int[256];

        for(int i=0; i<s.length(); i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);

            if(arrs[chs] == 0 && arrt[cht] == 0){
                arrs[chs] = cht;
                arrt[cht] = chs;
            }
            else{
                if(arrs[chs] != cht || arrt[cht] != chs){
                    return false;
                }
            }
        }

        return true;
    }
}