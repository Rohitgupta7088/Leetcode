class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[] = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        for(int i=0; i<pattern.length(); i++){
            if( arr[i].equals("00") ){
                continue;
            }

            char curr = pattern.charAt(i);
            String value = arr[i];

            for(int j=i+1; j<pattern.length(); j++){
                if(pattern.charAt(j) == curr){
                    if( arr[j].equals(value) ){
                        arr[j] ="00";
                    }
                    else{
                        return false;
                    }
                }
                else if( arr[j].equals(value) ){
                    return false;
                }
            }
        }

        return true;
    }
}