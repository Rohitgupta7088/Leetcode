class Solution {
    StringBuilder finaltime = new StringBuilder();
    public String largestTimeFromDigits(int[] arr) {
        StringBuilder temp = new StringBuilder();
        helper(arr, temp);
        if(finaltime.length() != 0){
            finaltime.insert(2, ':');
        }
        return finaltime.toString();
    }

    public void helper(int arr[], StringBuilder temp){
        if(arr.length == 0){
            int hour = ( (temp.charAt(0)-'0')*10 )+(temp.charAt(1)-'0');
            int min = ( (temp.charAt(2)-'0')*10 )+(temp.charAt(3)-'0');
            if(hour<24 && min<60){
                if(finaltime.length() == 0){
                    finaltime.append(temp.toString());
                }
                else{
                    if( currhigh(finaltime.toString(), temp.toString()) ){
                        finaltime.setLength(0);
                        finaltime.append(temp.toString());
                    }
                }
            }
            return;
        }

        for(int i=0; i<arr.length; i++){
            int curr = arr[i];

            int digit[] = new int[arr.length-1];
            for(int j=0; j<arr.length; j++){
                if(i==j){
                    continue;
                }
                else if(j<i){
                    digit[j] = arr[j];
                }
                else if(j>i){
                    digit[j-1] = arr[j];
                }
            }

            temp.append((char)(curr+'0'));
            helper(digit, temp);
            temp.deleteCharAt(temp.length()-1);

        }
    }

    public boolean currhigh(String prevtime, String currtime){
        for(int i=0; i<currtime.length(); i++){
            if( currtime.charAt(i) > prevtime.charAt(i) ){
                return true;
            }
            else if( currtime.charAt(i) < prevtime.charAt(i) ){
                return false;
            }
        }

        return false;
    }
}