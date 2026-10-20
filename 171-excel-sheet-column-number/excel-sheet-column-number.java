class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        int k = 0;
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            num += ( (ch-'A'+1)*Math.pow(26, k) );
            k++;
        }

        return num;
    }
}