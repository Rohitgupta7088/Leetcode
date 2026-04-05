class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder sec = new StringBuilder(secret);
        StringBuilder gue = new StringBuilder(guess);
        String hintstr = "";
        int countbull = 0;
       for(int i=0; i<sec.length(); i++){
            if( sec.charAt(i) == gue.charAt(i) ){
                countbull += 1;
                sec.deleteCharAt(i);
                gue.deleteCharAt(i);
                i--;
            }
        }

        hintstr += String.valueOf(countbull);;
        hintstr += 'A';

        int arr[] = new int[10];
        for(int i=0; i<sec.length(); i++){
            arr[sec.charAt(i)-'0'] += 1;
        }

        int countcow = 0;
        for(int i=0; i<gue.length(); i++){
            char ch = gue.charAt(i);
            if(arr[ch-'0'] > 0){
                countcow++;
                arr[ch-'0']--;
            }
        }

        hintstr += String.valueOf(countcow);;
        hintstr += 'B';

        return hintstr;
    }
}