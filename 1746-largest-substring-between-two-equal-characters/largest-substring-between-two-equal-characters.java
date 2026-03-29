class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int arr[] = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            int ei = 0;
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    ei = j;
                }
            }

            if( ei == 0 ){
                arr[i] = -1;
            }
            else{
                arr[i] = s.substring(i+1, ei).length();
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length; i++){
            max = Math.max(arr[i], max);
        }

        return max;
    }
}