class Solution {
    public int maxProduct(String[] words) {
        int arr[] = new int[words.length];
        for(int i=0; i<words.length; i++){
            arr[i] = words[i].length();
        }

        int mlp = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if( nocommon(words[i], words[j]) ){
                    mlp = Math.max(mlp, arr[i]*arr[j]);
                }
            }
        }

        return mlp;
    }

    public boolean nocommon(String s1, String s2){
        int m=0;
        int n=0;
        for(int i = 0; i < s1.length(); i++){
            m |= (1 << (s1.charAt(i) - 'a'));
        }

        for(int i = 0; i < s2.length(); i++){
            n |= (1 << (s2.charAt(i) - 'a'));
        }

        if( (m & n) == 0){
            return true;
        }
        else{
            return false;
        }
    }
}