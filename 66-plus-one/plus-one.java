class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = digits[digits.length-1] + 1;
        int newdigit;
        int carry;
        for(int i=digits.length-1; i>=0; i--){
           newdigit = sum%10;
           carry = sum/10;
           list.add(newdigit);
           if (i == 0) {
                if (carry != 0) {
                    list.add(carry);
                }
                break;
            }
           
            sum = digits[i-1] + carry;
           
        }

        int arr[] = new int[list.size()];
        int k = 0;
        for(int i=list.size()-1; i>=0; i--){
            arr[k++] = list.get(i);
        }

        return arr;
    }
}