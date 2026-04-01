class Solution {
    public String largestNumber(int[] nums) {
        String strarr[] = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strarr[i] = String.valueOf(nums[i]);
        }
        String numstr = "";
        for(int i=0; i<strarr.length; i++){
            int idx = -1;
            for(int x = 0; x < strarr.length; x++){
                if(!strarr[x].equals("-11")){
                    idx = x;
                    break;
                }
            }
            
            for(int j=0; j<strarr.length; j++){

                if(j==idx || strarr[j].equals("-11")){
                    continue;
                }

                String a = strarr[idx];
                String b = strarr[j];
                int k=0;
                while( k < a.length() + b.length() ){
                    char ch1 = a.charAt(k % a.length());
                    char ch2 = b.charAt(k % b.length());
                    if(ch1 > ch2){
                        break;
                    }
                    else if(ch1 < ch2){
                        idx = j;
                        break;
                    }
                    else{
                        k++;
                    }

                    if(k >= a.length() + b.length()){
                        break;
                    }
                }
            }
            numstr += strarr[idx];
            strarr[idx] = "-11";
        }

        if(numstr.charAt(0) == '0'){
            return "0";
        }
        return numstr;
    }
}