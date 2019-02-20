
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Logan
 */
public class RomanNumeral {
    final int I = 1;
    final int V = 5;
    final int X = 10;
    final int L = 50;
    final int C = 100;
    final int D = 500;
    final int M = 1000;
    
    String letters;
    int sum;
    boolean valid = true;
    boolean dyet = false, lyet = false, vyet = false;
    
    RomanNumeral(String letters) {
// Takes a numeral string, turns it into an array of chars into ints
        sum = 0;
        char[] lnum = letters.toCharArray();
        int[] nums = new int[letters.length()];
       
        for (int i = 0; i<letters.length(); i++) {
            if (lnum[i] == 'M') {
                nums[i] = M;
            }
            else if (lnum[i] == 'C')
                nums[i] = C;
            else if (lnum[i] == 'L')
                nums[i] = L;
            else if (lnum[i] == 'X')
                nums[i] = X;
            else if (lnum[i] == 'V')
                nums[i] = V;
            else nums[i] = I;
        }
        //checks to make sure there's no repeats of the 5's
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == V) {
                if(dyet)
                    valid = false;
                else dyet = true;
            }
            if (nums[i] == L) {
                if (lyet)
                    valid = false;
                else lyet = true;
            }
            if (nums[i] == D) {
                if (dyet)
                    valid = false;
                else dyet = true;
            }
       }
        
        
        //checks that there's no more than 1 number subtracting
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] < nums[i+2] && nums[i+1] < nums[i+2])
                valid = false;
        }
        
        //checks that subtractions are all proper
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == I && nums[i+1] > nums[i]) {
                if (!(nums[i+1] == V || nums[i+1] == X))
                        valid = false; }
            if (nums[i] == X && nums[i+1] > nums[i]) {
                if (!(nums[i+1] == L || nums[i+1] == C))
                        valid = false; }
            if (nums[i] == C && nums[i+1] > nums[i]) {
                if (!(nums[i+1] == D || nums[i+1] == M))
                        valid = false; }
            if ((nums[i] == L || nums[i] == V || nums[i] == D) && (nums[i] < nums[i+1]))
                    valid = false;
            }
        
            
        //Checks that there's no more than 3 in a row of anything
         for (int i = 0; i < nums.length - 3; i++) {
             if(nums[i] == nums[i+1] && nums[i] == nums[i+2] && nums[i] == nums[i+3])
                 valid = false;
             
         }   

         
        // Add it up
         if(valid) {
         for (int i = 0; i < nums.length - 1; i++) {
             if(nums[i] < nums[i+1]) {
                 sum -= nums[i];
             }
             else sum += nums[i];
         }
         sum += nums[nums.length - 1];
         }
        
    }   
    
    public String getLetters() {
        return letters;
    }
    
    
    public int getSum() {
        return sum;
    }
    
    public boolean isValid() {
        return valid;
    }
    
    
    // Constructor that takes in an int the sum and converts it to a string of letters
    RomanNumeral(int sum) {
        Integer fsum = new Integer(sum);
        String str = fsum.toString();
        int[] nums = new int[str.length()];
        if (sum >= 4000)
            valid = false;
        letters = "";
        
        // turn integer into an array of ints,  each digit separated
        for(int i = 0; i < str.length(); i++) {
            nums[i] = Character.getNumericValue(str.charAt(i));
        }
        
        //look at thousands place
        if(nums.length == 4) {
            if (nums[0] == 1)
                letters += "M";
            else if (nums[0] == 2)
                letters += "MM";
            else if (nums[0] == 3)
                letters += "MMM";
        }
        //then hundreds
        if (nums.length >= 3) {
            if (nums[nums.length-3] == 1)
                letters += "C";
           else if (nums[nums.length-3] == 2)
                letters += "CC";
           else if (nums[nums.length-3] == 3)
                letters += "CCC";
           else if (nums[nums.length-3] == 4)
                letters += "CD";
           else if (nums[nums.length-3] == 5)
                letters += "D";
          else  if (nums[nums.length-3] == 6)
                letters += "DC";
          else if (nums[nums.length-3] == 7)
                letters += "DCC";
           else if (nums[nums.length-3] == 8)
                letters += "DCCC";
           else if (nums[nums.length-3] == 9)
                letters += "CM";
        }
        //tens
         if (nums.length >= 2) {
            if (nums[nums.length-2] == 1)
                letters += "X";
           else if (nums[nums.length-2] == 2)
                letters += "XX";
           else if (nums[nums.length-2] == 3)
                letters += "XXX";
           else if (nums[nums.length-2] == 4)
                letters += "XL";
           else if (nums[nums.length-2] == 5)
                letters += "L";
          else  if (nums[nums.length-2] == 6)
                letters += "LX";
          else if (nums[nums.length-2] == 7)
                letters += "LXX";
           else if (nums[nums.length-2] == 8)
                letters += "LXXX";
           else if (nums[nums.length-2] == 9)
                letters += "XC";
        }
            
         // and ones

           if (nums[nums.length-1] == 1)
                letters += "I";
           else if (nums[nums.length-1] == 2)
                letters += "II";
           else if (nums[nums.length-1] == 3)
                letters += "III";
           else if (nums[nums.length-1] == 4)
                letters += "IV";
           else if (nums[nums.length-1] == 5)
                letters += "V";
          else  if (nums[nums.length-1] == 6)
                letters += "VI";
          else if (nums[nums.length-1] == 7)
                letters += "VII";
           else if (nums[nums.length-1] == 8)
                letters += "VIII";
           else if (nums[nums.length-1] == 9)
                letters += "IX";
        
    }
        
        
        
        
 
    public static void main(String args[]) {
        RomanNumeral good = new RomanNumeral("CXXVII");
        RomanNumeral bad = new RomanNumeral("XVXIIII");
        RomanNumeral question = new RomanNumeral(4234);
        
        System.out.println(question.getLetters());
        System.out.println(good.getSum());
        System.out.println(bad.isValid());
        System.out.println(bad.getSum());
    }
    
}
