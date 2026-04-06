class Solution {
    public String frequencySort(String s) {
        // int small[] = new int[26];
        // int cap[] = new int[26];

        // for(int i=0; i<s.length(); i++){
        //     char ch = s.charAt(i);
        //     if(ch>='a' && ch<='z'){
        //         small[ch-'a'] += 1;
        //     }

        //     if(ch>='A' && ch<='Z'){
        //         cap[ch-'A'] += 1;
        //     }
        // }

        // StringBuilder str = new StringBuilder();
        // while(str.length() < s.length()){
        //     int smcount = 0;
        //     int smidx = 0;
        //     int capcount = 0;
        //     int capidx = 0;
        //     for(int i=0; i<small.length; i++){
        //         if(smcount < small[i]){
        //             smcount = small[i];
        //             smidx = i;
        //         }
        //     }
        
        //     for(int i=0; i<cap.length; i++){
        //         if(capcount < cap[i]){
        //             capcount = cap[i];
        //             capidx = i;
        //         }
        //     }

        //     if(smcount == 0 && capcount == 0){
        //         break;
        //     }
        //     else if(smcount >= capcount){
        //         small[smidx] = 0;
        //         for(int i=1; i<=smcount; i++){
        //             str.append( (char)(smidx+'a') );
        //         }
        //     }
        //     else if ((smcount <= capcount)){
        //         cap[capidx] = 0;
        //         for(int i=1; i<=capcount; i++){
        //             str.append( (char)(capidx+'A') );
        //         }
        //     }
        // }

        // return str.toString();


        int arr[] = new int[256];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            arr[ch]++;
        }

        StringBuilder str = new StringBuilder();
        while(str.length() < s.length()){
            int max = 0;
            int maxidx = 0;
            for(int i=0; i<arr.length; i++){
                if(max < arr[i]){
                    max = arr[i];
                    maxidx = i;
                }
            }
            if(max == 0){
                break;
            }
            else{
                arr[maxidx] = 0;
                for(int i=1; i<=max; i++){
                    str.append((char)maxidx);
                }
            }
        }

        return str.toString();
    }
}