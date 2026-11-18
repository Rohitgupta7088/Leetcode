class Solution {
    public String frequencySort(String s) {
        int arr[] = new int[256];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            arr[ch]++;
        }

        StringBuilder ans = new StringBuilder();
        while(ans.length()<s.length()){
            int max = 0;
            int maxidx = -1;

            for(int i=0; i<arr.length; i++){
                if(max<arr[i]){
                    max = arr[i];
                    maxidx = i;
                }
            }

            if(max == 0){
                break;
            }
            else{
                arr[maxidx] = 0;
                for(int i=0; i<max; i++){
                    ans.append((char)maxidx);
                }
            }
        }

        return ans.toString();
    }
}