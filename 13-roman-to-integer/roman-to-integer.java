class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int i=s.length()-1;
        while(i>=0){
            if( i>0 && (s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i-1) == 'I'){
                if(s.charAt(i) == 'V'){
                    num += 5;
                }
                if(s.charAt(i) == 'X'){
                    num += 10;
                }
                num -= 1;

                i -= 2;
            }
            else if( i>0 && (s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i-1) == 'X'){
                if(s.charAt(i) == 'L'){
                    num += 50;
                }
                if(s.charAt(i) == 'C'){
                    num += 100;
                }
                num -= 10;

                i -= 2;
            }
            else if( i>0 && (s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i-1) == 'C'){
                if(s.charAt(i) == 'D'){
                    num += 500;
                }
                if(s.charAt(i) == 'M'){
                    num += 1000;
                }
                num -= 100;

                i -= 2;
            }
            else if(s.charAt(i) == 'I'){
                num +=1;
                i--;
            }
            else if(s.charAt(i) == 'V'){
                num +=5;
                i--;
            }
            else if(s.charAt(i) == 'X'){
                num +=10;
                i--;
            }
            else if(s.charAt(i) == 'L'){
                num +=50;
                i--;
            }
            else if(s.charAt(i) == 'C'){
                num +=100;
                i--;
            }
            else if(s.charAt(i) == 'D'){
                num +=500;
                i--;
            }
            else if(s.charAt(i) == 'M'){
                num +=1000;
                i--;
            }
        }

        return num;
    }
}